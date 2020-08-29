[![Test](https://github.com/simplyRoba/kata_calender/workflows/Test/badge.svg?branch=master)](https://github.com/simplyRoba/kata_calender/actions?query=workflow%3ATest)

# CALENDER KATA

## Task

Write a command line program that prints a monthly calendar on the console.

The program will be called with month and year as command line parameters and 
prints the calendar fort he given month on the console:
```	
 C:>cal 2 2014
     February 2014
 Su Mo Tu We Th Fr Sa
                    1
  2  3  4  5  6  7  8
  9 10 11 12 13 14 15
 16 17 18 19 20 21 22
 23 24 25 26 27 28
 ```

## Variation #1

If called without any parameter the program should print the calendar for the current month.

## Variation #2

The day of week that starts the week can be given as an optional third parameter. 
In Germany for example the month starts on Monday:
```
C:>cal 2 2014 Monday
```

Month and year can be omitted:
```	
C:>cal Monday
```

**Description and idea from:** https://ccd-school.de/en/coding-dojo/application-katas/cal/
