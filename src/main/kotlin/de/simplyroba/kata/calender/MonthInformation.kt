package de.simplyroba.kata.calender

import de.simplyroba.kata.calender.Month.*


/**
 * @author simplyroba
 */
class MonthInformation(
    val month: Month,
    val year: Int
) {

    val daysCount: Int
        get() {
            return when (month) {
                APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30
                FEBRUARY -> {
                    if (year%4 == 0 && year%100 != 0 || year%400 == 0) 29 else 28
                }
                else -> 31
            }
        }

}
