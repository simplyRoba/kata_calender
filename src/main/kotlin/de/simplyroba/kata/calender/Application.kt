package de.simplyroba.kata.calender

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.default
import com.xenomachina.argparser.mainBody
import de.simplyroba.kata.calender.Weekday.SUNDAY
import java.lang.Exception

/**
 * @author simplyroba
 */
fun main(args: Array<String>) = mainBody {
    ArgParser(args).parseInto(::Args).run {
        if (interactive) {
            while (true) {
                try {
                    println("Month between 1 and 12: ")
                    val month = readLine()?.toInt()
                    println("Year as 4 digits number: ")
                    val year = readLine()?.toInt()
                    CalenderPrinter.printMonth(Calender.getMonth(month!!, year!!))
                } catch (ex: Exception) {
                    println("retry..")
                }
            }
        } else {
            CalenderPrinter.printMonth(Calender.getMonth(month, year), weekStart)
        }
    }
}

class Args(parser: ArgParser) {
    val interactive by parser.flagging(
        "-i", "--interactive",
        help = "enable interactive mode"
    )

    val month: Int by parser.positional(
        "MONTH",
        help = "month between 1 and 12",
        transform = { Integer.valueOf(this) }
    ).default(1)

    val year: Int by parser.positional(
        "YEAR",
        help = "year as 4 digit number",
        transform = { Integer.valueOf(this) }
    ).default(1)

    val weekStart: Weekday by parser.positional(
        "WEEK_START",
        help = "name of day the week starts with",
        transform = { Weekday.valueOf(this.toUpperCase()) }
    ).default(SUNDAY)
}

