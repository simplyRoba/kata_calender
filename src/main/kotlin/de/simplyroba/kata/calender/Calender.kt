package de.simplyroba.kata.calender

/**
 * @author simplyroba
 */
object Calender {

    enum class Months (val printName: String){
        JANUARY("January"),
        FEBRUARY("February"),
        MARCH("March"),
        APRIL("April"),
        MAY("May"),
        JUNE("June"),
        JULY("July"),
        AUGUST("August"),
        SEPTEMBER("September"),
        OCTOBER("October"),
        NOVEMBER("November"),
        DECEMBER("December")
    }

    fun getMonth(month: Int, year: Int): Month {
        return Month(month, year)
    }
}
