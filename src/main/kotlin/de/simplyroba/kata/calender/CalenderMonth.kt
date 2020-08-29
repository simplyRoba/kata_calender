package de.simplyroba.kata.calender

import de.simplyroba.kata.calender.Month.*

/**
 * @author simplyroba
 */
class CalenderMonth(
    val month: Month,
    val year: Int
) {
    fun weekdayOf(dayInMonth: Int): Day {
        var month: Int = this.month.index
        var year: Int = this.year

        // https://en.wikipedia.org/wiki/Zeller%27s_congruence
        if (this.month == JANUARY) {
            month = 13
            year = year.minus(1)
        }
        if (this.month == FEBRUARY) {
            month = 14
            year = year.minus(1)
        }

        val q: Int = dayInMonth
        val m: Int = month
        val k = year % 100
        val j = year / 100
        val h = (q + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7
        return Day.byOrdinal(h)
    }

    val daysCount: Int
        get() {
            return when (month) {
                APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30
                FEBRUARY -> {
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) 29 else 28
                }
                else -> 31
            }
        }

}
