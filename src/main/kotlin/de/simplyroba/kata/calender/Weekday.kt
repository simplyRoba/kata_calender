package de.simplyroba.kata.calender

/**
 * @author simplyroba
 */
enum class Weekday(
    val printName: String,
    val shortName: String
) {
    MONDAY("Monday", "Mo"),
    TUESDAY("Tuesday", "Tu"),
    WEDNESDAY("Wednesday", "We"),
    THURSDAY("Thursday", "Th"),
    FRIDAY("Friday", "Fr"),
    SATURDAY("Saturday", "Sa"),
    SUNDAY("Sunday", "Su");

    val index: Int
        get() = ordinal.plus(1)

    companion object {
        fun byIndex(index: Int): Weekday {
            return values().first() { it.ordinal == index.minus(1)}
        }
    }
}
