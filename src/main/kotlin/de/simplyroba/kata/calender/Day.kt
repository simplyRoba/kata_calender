package de.simplyroba.kata.calender

/**
 * @author simplyroba
 */
enum class Day(
    val printName: String,
    val shortName: String
) {
    SATURDAY("Saturday", "Sa"),
    SUNDAY("Sunday", "Su"),
    MONDAY("Monday", "Mo"),
    TUESDAY("Tuesday", "Tu"),
    WEDNESDAY("Wednesday", "We"),
    THURSDAY("Thursday", "Th"),
    FRIDAY("Friday", "Fr");

    companion object {
        fun byOrdinal(ordinal: Int): Day {
            return values().first() { it.ordinal == ordinal}
        }
    }
}
