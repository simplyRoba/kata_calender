package de.simplyroba.kata.calender

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

/**
 * @author simplyroba
 */
internal class CalenderTest {

    @Test
    internal fun `should return correct year`() {
        val year = 2019
        val month: Month = Calender.getMonth(2, year)
        assertThat(month.year).isEqualTo(year)
    }

    @Test
    internal fun `should return correct month`() {
        val month: Month = Calender.getMonth(3, 2018)
        assertThat(month.name).isEqualTo(Calender.Months.MARCH)
    }
}
