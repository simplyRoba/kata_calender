package de.simplyroba.kata.calender

import de.simplyroba.kata.calender.Month.FEBRUARY
import de.simplyroba.kata.calender.Month.JANUARY
import kotlinx.collections.immutable.toImmutableMap
import kotlinx.collections.immutable.toPersistentMap

/**
 * @author simplyroba
 */
object Calender {

    fun getMonth(monthIndex: Int, year: Int): CalenderMonth {
        val month = Month.byIndex(monthIndex)
        val daysCount: Int = daysCount(month, year)
        val days = HashMap<Int, Weekday> ()
        (1..daysCount).forEach { day -> days[day] = weekdayOf(day, month, year) }

        return CalenderMonth(month, year, days.toPersistentMap())
    }

    private fun daysCount(month: Month, year: Int): Int {
        return when (month) {
            Month.APRIL, Month.JUNE, Month.SEPTEMBER, Month.NOVEMBER -> 30
            FEBRUARY -> {
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) 29 else 28
            }
            else -> 31
        }
    }

    private fun weekdayOf(dayInMonth: Int, month: Month, year: Int): Weekday {
        var monthInternal: Int = month.index
        var yearInternal: Int = year

        // https://en.wikipedia.org/wiki/Zeller%27s_congruence
        if (month == JANUARY) {
            monthInternal = 13
            yearInternal = yearInternal.minus(1)
        }
        if (month == FEBRUARY) {
            monthInternal = 14
            yearInternal = yearInternal.minus(1)
        }

        val q: Int = dayInMonth
        val m: Int = monthInternal
        val k = yearInternal % 100
        val j = yearInternal / 100
        val h = (q + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7
        val d = ((h+5)%7) + 1
        return Weekday.byIndex(d)
    }
}
