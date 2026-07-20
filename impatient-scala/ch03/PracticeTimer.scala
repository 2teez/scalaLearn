package com.progscala3.practicetimer

import timer.*

package timer:
  class Time(val hrs: Int = 0, val mins: Int = 0):
    require((hrs >= 0 && hrs <= 23) && (mins >= 0 && mins <= 59))
    def before(other: Time): Boolean = (hrs * 60 + mins) < (other.hrs * 60 + other.mins)
    override def toString(): String  = s"Time($hrs:$mins)"

  object Time:
    def apply(hrs: Int = 0, mins: Int = 0): Time = new Time(hrs, mins)

@main def main(args: String*): Unit =
  val startTime = Time(15, 59)
  val endTime   = Time(2, 45)
  println(startTime.before(endTime))
  println(endTime.before(startTime))
