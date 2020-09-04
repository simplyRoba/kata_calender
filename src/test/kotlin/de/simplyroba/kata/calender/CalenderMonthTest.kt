package de.simplyroba.kata.calender

import com.google.common.truth.Truth.assertThat
import de.simplyroba.kata.calender.Month.FEBRUARY
import de.simplyroba.kata.calender.Weekday.MONDAY
import de.simplyroba.kata.calender.Weekday.SUNDAY
import org.junit.jupiter.api.Test

/**
 * @author simplyroba
 */
internal class CalenderMonthTest {

    @Test
    internal fun `should output month`() {
        val month = FEBRUARY
        val output = Calender.getMonth(month.index, 2020).buildOutput().toString()
        assertThat(output).contains(month.printName)
    }

    @Test
    internal fun `should output year`() {
        val year: Int = 1995
        val output = Calender.getMonth(6, year).buildOutput().toString()
        assertThat(output).contains(year.toString())
    }

    @Test
    internal fun `should output weekdays in default order`() {
        val output = Calender.getMonth(6, 1997).buildOutput(SUNDAY).toString()
        assertThat(output).contains("Su Mo Tu We Th Fr Sa")
    }

    @Test
    internal fun `should output weekdays in correct order starting with monday`() {
        val output = Calender.getMonth(6, 1997).buildOutput(MONDAY).toString()
        assertThat(output).contains("Mo Tu We Th Fr Sa Su")
    }

    @Test
    internal fun `should output days in correct order for FEB 2014`() {
        val output = Calender.getMonth(2, 2014).buildOutput(SUNDAY).toString()
        assertThat(output).contains("9 10 11 12 13 14 15")
        assertThat(output).contains("16 17 18 19 20 21 22")
        assertThat(output).contains("23 24 25 26 27 28")
    }

    @Test
    internal fun `should output days in correct order FEB 2100`() {
        val output = Calender.getMonth(2, 2100).buildOutput(SUNDAY).toString()
        assertThat(output).contains("1  2  3  4  5  6")
        assertThat(output).contains("7  8  9 10 11 12 13")
        assertThat(output).contains("14 15 16 17 18 19 20")
        assertThat(output).contains("21 22 23 24 25 26 27")
    }

    @Test
    internal fun `should output 29th on FEB 2024`() {
        val output = Calender.getMonth(2, 2024).buildOutput(SUNDAY).toString()
        assertThat(output).contains("29")
        assertThat(output).doesNotContain("30")
    }
}
