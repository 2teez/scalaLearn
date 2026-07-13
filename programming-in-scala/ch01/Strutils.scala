package com.progscala3.strutils
import com.progscala3.strutils.String._

@main def main(args: String*): Unit =
  val str = "scalame"
  println(str.toTitleCase)


//class Strutils(private val value: String)
//object Strutils:
  //def apply(value: String): Strutils = new Strutils(value)
object String:
  extension (str: String)
    def toTitleCase: String = str.substring(0, 1).toUpperCase + str.substring(1).toLowerCase
