package com.progscala3.strutils
import com.progscala3.strutils.StringExtentions._

@main def main(args: String*): Unit =
  val str = "scalame"
  println(s"$str in Title case: ${!str}")
  val str2 = str.toTitleCase
  println(s"$str2 in Title case: ${!str2}")



//class Strutils(private val value: String)
//object Strutils:
  //def apply(value: String): Strutils = new Strutils(value)
object StringExtentions:
  extension (str: String)
    def toTitleCase: String = str.substring(0, 1).toUpperCase + str.substring(1).toLowerCase
    def unary_! : Boolean = str.toTitleCase == str
