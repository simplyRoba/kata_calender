package de.simplyroba.kata.calender

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

/**
 * @author simplyroba
 */
class CalenderTest {

    @Test
    fun `should return correct year`() {
        val year = 2019
        val month: Month = Calender.getMonth(2, year)
        assertThat(month.year).isEqualTo(year)
    }
}
