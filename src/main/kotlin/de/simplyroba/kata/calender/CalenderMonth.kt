package de.simplyroba.kata.calender

/**
 * @author simplyroba
 */
class CalenderMonth(
    val month: Month,
    val year: Int,
    val days: CalenderDays
) {
    companion object {
        private const val LINE_LENGTH: Int = 20
    }

    fun buildOutput(startWeekday: Weekday = Weekday.SUNDAY): StringBuilder {
        val sb = StringBuilder()
        buildTitle(sb)
        buildWeekDayLine(sb, startWeekday)
        buildDays(sb, startWeekday)
        repeat(2) { sb.appendLine() }
        return sb
    }

    private fun buildTitle(sb: StringBuilder) {
        sb.appendLine("%${LINE_LENGTH}s".format("${month.printName} $year"))
    }

    private fun buildWeekDayLine(sb: StringBuilder, startWeekday: Weekday) {
        for (x in 0..6) {
            val shiftedIndex = (x.plus(startWeekday.ordinal) % 7).plus(1)
            sb.append("%2s ".format(Weekday.byIndex(shiftedIndex).shortName))
        }
        sb.appendLine()
    }

    private fun buildDays(sb: StringBuilder, startWeekday: Weekday) {
        val firstDay = days.getValue(1)

        val startingOffset = (firstDay.ordinal.minus(startWeekday.ordinal) % 7)
        repeat(startingOffset) { sb.append("   ") }

        var counter = startingOffset.plus(1)
        for (day in days) {
            if (counter%7 == 0) {
                sb.appendLine("%2d".format(day.key))
            } else {
                sb.append("%2d ".format(day.key))
            }
            counter++
        }
    }
}

fun StringBuilder.print() {
    print(this.toString())
}
