package de.simplyroba.kata.calender

/**
 * @author simplyroba
 */
fun main(args: Array<String>) {
    CalenderPrinter.printMonth(Calender.getMonth(args[0].toInt(), args[1].toInt()))
}
