package de.simplyroba.kata.calender

import com.google.common.truth.Truth.assertThat
import de.simplyroba.kata.calender.Weekday.WEDNESDAY
import de.simplyroba.kata.calender.Month.MARCH
import org.junit.jupiter.api.Test

/**
 * @author simplyroba
 */
internal class CalenderTest {

    @Test
    internal fun `should return correct year`() {
        val year = 2019
        val calenderMonth: CalenderMonth = Calender.getMonth(2, year)
        assertThat(calenderMonth.year).isEqualTo(year)
    }

    @Test
    internal fun `should return correct month`() {
        val calenderMonth: CalenderMonth = Calender.getMonth(MARCH.index, 2018)
        assertThat(calenderMonth.month).isEqualTo(MARCH)
    }

    @Test
    internal fun `should return correct number of days for month in june`() {
        val calenderMonth: CalenderMonth = Calender.getMonth(6, 2013)
        assertThat(calenderMonth.days.size).isEqualTo(30)
    }

    @Test
    internal fun `should return correct number of days for month in february 2000`() {
        val calenderMonth: CalenderMonth = Calender.getMonth(2, 2000)
        assertThat(calenderMonth.days.size).isEqualTo(29)
    }

    @Test
    internal fun `should return correct number of days for month in february 1900`() {
        val calenderMonth: CalenderMonth = Calender.getMonth(2, 1900)
        assertThat(calenderMonth.days.size).isEqualTo(28)
    }

    @Test
    internal fun `should return correct week day`() {
        val calenderMonth: CalenderMonth = Calender.getMonth(1, 1992)
        assertThat(calenderMonth.days[22]).isEqualTo(WEDNESDAY)
    }
}
