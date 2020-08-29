package de.simplyroba.kata.calender

/**
 * @author simplyroba
 */
object Calender {

    fun getMonth(month: Int, year: Int): CalenderMonth {
        return CalenderMonth(Month.byIndex(month), year)
    }
}
