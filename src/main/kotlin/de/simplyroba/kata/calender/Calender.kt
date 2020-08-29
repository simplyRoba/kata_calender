package de.simplyroba.kata.calender

/**
 * @author simplyroba
 */
// TODO find better name for index
enum class Month (val index: Int, val printName: String){
    JANUARY(1, "January"),
    FEBRUARY(2, "February"),
    MARCH(3, "March"),
    APRIL(4, "April"),
    MAY(5, "May"),
    JUNE(6, "June"),
    JULY(7, "July"),
    AUGUST(8, "August"),
    SEPTEMBER(9, "September"),
    OCTOBER(10, "October"),
    NOVEMBER(11, "November"),
    DECEMBER(12, "December");

    companion object {
        fun byIndex(index: Int): Month {
            return values().first { it.index == index }
        }
    }
}

object Calender {

    fun getMonth(month: Int, year: Int): MonthInformation {
        return MonthInformation(Month.byIndex(month), year)
    }
}
