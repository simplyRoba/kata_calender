package de.simplyroba.kata.calender

import de.simplyroba.kata.calender.Weekday.SUNDAY

/**
 * @author simplyroba
 */
object CalenderPrinter {

    private const val LINE_LENGTH: Int = 20

    fun printMonth(monthToPrint: CalenderMonth, startWeekday: Weekday = SUNDAY) {
        printTitle(monthToPrint)
        printWeekDayLine(startWeekday)
        printDays(startWeekday, monthToPrint.days)
        repeat(3) { println() }
    }

    private fun printTitle(monthToPrint: CalenderMonth) {
        println("%${LINE_LENGTH}s".format("${monthToPrint.month.printName} ${monthToPrint.year}"))
    }

    private fun printWeekDayLine(startWeekDay: Weekday) {
        for (x in 0..6) {
            val shiftedIndex = (x.plus(startWeekDay.ordinal) % 7).plus(1)
            print("%2s ".format(Weekday.byIndex(shiftedIndex).shortName))
        }
        println()
    }

    private fun printDays(startWeekday: Weekday, days: CalenderDays) {
        val firstDay = days.getValue(1)

        val startingOffset = (firstDay.ordinal.minus(startWeekday.ordinal) % 7)
        repeat(startingOffset) { print("   ") }

        var counter = startingOffset.plus(1)
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
