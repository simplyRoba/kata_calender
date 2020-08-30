package de.simplyroba.kata.calender

import de.simplyroba.kata.calender.Weekday.SUNDAY

/**
 * @author simplyroba
 */
object CalenderPrinter {

    private const val LINE_LENGTH: Int = 20

    fun printMonth(monthToPrint: CalenderMonth, startDay: Weekday = SUNDAY) {
        printTitle(monthToPrint)
        printWeekDayLine(startDay)
        printDays(monthToPrint.days)
    }

    private fun printTitle(monthToPrint: CalenderMonth) {
        println("%${LINE_LENGTH}s".format("${monthToPrint.month.printName} ${monthToPrint.year}"))
    }

    private fun printWeekDayLine(startDay: Weekday) {
        for (x in 0..6) {
            val shiftedIndex = (x.plus(startDay.ordinal) % 7).plus(1)
            print("%2s ".format(Weekday.byIndex(shiftedIndex).shortName))
        }
        println()
    }

    private fun printDays(days: CalenderDays) {
        val firstDay = days.getValue(1)

        val startingOffset = firstDay.ordinal
        repeat(startingOffset) { print("   ") }

        var counter = firstDay.index
        for (day in days) {
            if (counter%7 == 0) {
                println("%2d".format(day.key))
            } else {
                print("%2d ".format(day.key))
            }
            counter++
        }
    }
}
