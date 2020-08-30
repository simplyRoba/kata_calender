package de.simplyroba.kata.calender

import kotlinx.collections.immutable.PersistentMap

/**
 * @author simplyroba
 */
object CalenderPrinter {

    fun printMonth(monthToPrint: CalenderMonth) {
        printTitle(monthToPrint)
        printWeekDayLine()
        printDays(monthToPrint.days)
    }

    private fun printTitle(monthToPrint: CalenderMonth) {
        println("   ${monthToPrint.month.printName} ${monthToPrint.year}")
    }

    private fun printWeekDayLine() {
        println("Su Mo Tu We Th Fr Sa")
    }

    private fun printDays(days: CalenderDays) {
        val firstDay = days.getValue(1)

        val startingOffset = firstDay.ordinal
        repeat(startingOffset) { print("   ") }

        var counter = firstDay.index
        for (day in days) {
            if (counter%7 == 0) {
                println(String.format("%2d", day.key))
            } else {
                print(String.format("%2d ", day.key))
            }
            counter++
        }
    }
}
