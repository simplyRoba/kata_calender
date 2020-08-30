package de.simplyroba.kata.calender

/**
 * @author simplyroba
 */

enum class Month (
    val printName: String
){
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
    DECEMBER("December");

    val index: Int
        get() = ordinal.plus(1)

    companion object {
        fun byIndex(index: Int): Month {
            return values().first { it.ordinal == index.minus(1) }
        }
    }
}
