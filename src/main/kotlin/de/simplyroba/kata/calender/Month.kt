package de.simplyroba.kata.calender

/**
 * @author simplyroba
 */
class Month(
    private val month: Int,
    val year: Int
) {
    val name: Calender.Months
        get() = Calender.Months.values()[month - 1]

    val daysCount: Int
        get() = TODO()
}
