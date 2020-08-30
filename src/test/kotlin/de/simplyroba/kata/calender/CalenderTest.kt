package de.simplyroba.kata.calender

import com.google.common.truth.Truth.assertThat
import de.simplyroba.kata.calender.Weekday.*
import de.simplyroba.kata.calender.Month.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

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

    @ParameterizedTest
    @MethodSource("dateWeekDayData")
    internal fun `should return correct week day `(day: Int, monthIndex: Int,
                                                   year: Int, weekday: Weekday) {
        val calenderMonth: CalenderMonth = Calender.getMonth(monthIndex, year)
        assertThat(calenderMonth.days[day]).isEqualTo(weekday)
    }

    companion object {
        @JvmStatic
        fun dateWeekDayData(): Stream<Arguments> =
            Stream.of(
                Arguments.of(22, 1, 1992, WEDNESDAY),
                Arguments.of(9, 2, 2014, SUNDAY),
                Arguments.of(24, 12, 2100, FRIDAY),
                Arguments.of(11, 9, 2011, SUNDAY),
                Arguments.of(3, 10, 1990, WEDNESDAY)
            )
    }
}
