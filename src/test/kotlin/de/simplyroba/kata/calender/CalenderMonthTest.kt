package de.simplyroba.kata.calender

import com.google.common.truth.Truth.assertThat
import de.simplyroba.kata.calender.Month.FEBRUARY
import de.simplyroba.kata.calender.Weekday.MONDAY
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
        val output = Calender.getMonth(6, 1997).buildOutput().toString()
        assertThat(output).contains("Su Mo Tu We Th Fr Sa")
    }

    @Test
    internal fun `should output weekdays in correct order starting with monday`() {
        val output = Calender.getMonth(6, 1997).buildOutput(MONDAY).toString()
        assertThat(output).contains("Mo Tu We Th Fr Sa Su")
    }

    // TODO more output tests
}
