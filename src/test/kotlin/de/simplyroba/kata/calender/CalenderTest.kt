package de.simplyroba.kata.calender

import com.google.common.truth.Truth.assertThat
import de.simplyroba.kata.calender.Month.MARCH
import org.junit.jupiter.api.Test

/**
 * @author simplyroba
 */
internal class CalenderTest {

    @Test
    internal fun `should return correct year`() {
        val year = 2019
        val month: MonthInformation = Calender.getMonth(2, year)
        assertThat(month.year).isEqualTo(year)
    }

    @Test
    internal fun `should return correct month`() {
        val month: MonthInformation = Calender.getMonth(3, 2018)
        assertThat(month.month).isEqualTo(MARCH)
    }

    @Test
    internal fun `should return correct number of days for month in june`() {
        val month: MonthInformation = Calender.getMonth(6, 2013)
        assertThat(month.daysCount).isEqualTo(30)
    }

    @Test
    internal fun `should return correct number of days for month in february 2000`() {
        val month: MonthInformation = Calender.getMonth(2, 2000)
        assertThat(month.daysCount).isEqualTo(29)
    }

    @Test
    internal fun `should return correct number of days for month in february 1900`() {
        val month: MonthInformation = Calender.getMonth(2, 1900)
        assertThat(month.daysCount).isEqualTo(28)
    }
}
