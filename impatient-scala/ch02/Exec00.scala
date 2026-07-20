package com.progscala3.exec00

import java.util.Random
import com.progscala3.util.Util.*
import ArrayPractice.*

@main def main(args: String*): Unit =
  val randomNumber: Int = userInput("Enter a random number: ").toInt
  generateInclusiveArray(randomNumber).foreach(print)
  println()
  generateExclusiveArray(randomNumber).foreach(print)
  println()

package ArrayPractice:
  import scala.collection.mutable.ArrayBuffer

  def generateInclusiveArray(n: Int): Array[Int] =
    val buffer = ArrayBuffer[Int]()
    for num <- 0 to n do buffer += num
    buffer.toArray

  def generateExclusiveArray(n: Int): Array[Int] =
    val buffer = ArrayBuffer[Int]()
    for num <- 0 until n do buffer += num
    buffer.toArray
