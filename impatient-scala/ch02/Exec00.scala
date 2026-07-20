package com.progscala3.exec00

import java.util.Random
import scala.collection.mutable.ArrayBuffer
import com.progscala3.util.Util.*
import ArrayPractice.*

@main def main(args: String*): Unit =
  val randomNumber: Int              = userInput("Enter a random number: ").toInt
  generateInclusiveArray(randomNumber).foreach(print)
  println()
  generateExclusiveArray(randomNumber).foreach(print)
  println()
  //
  val num                            = Array(1, 2, 3, 4, 5, 6)
  // var counter = 0
  val buffer2                        = ArrayBuffer[Int]()
  var index                          = 0
  while index <= num.length - 1 do
    if index == num.length - 1 then buffer2 += num(index)
    else
      val (first, second) = swapper(num(index), num(index + 1))
      buffer2 += (first, second)
    index += 2
  println(buffer2)
  //
  // Average of array of double, and arraybuffer of doubles
  val arraysOfDoubles: Array[Double] = Array(4.5, 1.01, 3.8, 0.09, 4.13)
  println(averageOf(arraysOfDoubles))
  println(generateRandomDoubleNumbers(5).sortInPlace().mkString(","))
  //
  val values = Array(4, 0, 5, -3, 7, -2, -6, 9)
  println("["+removeAllNegativeExceptFirst(values).mkString("][")+"]")

package ArrayPractice:

  def averageOf(values: Array[Double]): Double = values.sum / values.size.toDouble

  def swapper(first: Int, second: Int): (Int, Int) = (second, first)
  def generateInclusiveArray(n: Int): Array[Int]   =
    val buffer = ArrayBuffer[Int]()
    for num <- 0 to n do buffer += num
    buffer.toArray

  def generateExclusiveArray(n: Int): Array[Int]         =
    val buffer = ArrayBuffer[Int]()
    for num <- 0 until n do buffer += num
    buffer.toArray
  def generateRandomDoubleNumbers(n: Int): Array[Double] =
    val rand = Random()
    (for _ <- 0 to n yield f"${rand.nextDouble(10) % 10.2f}".toDouble).toArray

  def removeAllNegativeExceptFirst(values: Array[Int]): Array[Int] =
    var seenNegative = false

    values.filter { x =>
      if x >= 0 then
        true
      else if !seenNegative then
        seenNegative = true
        true
      else
        false
    }

    // same solution practicing Array and ArrayBuffer
    /*
    val negatives = values.filter(_ < 0)

    if negatives.isEmpty then values
    else
      val positives = values.filter(_ >= 0).toBuffer
      val firstNegative = negatives(0)
      val index = values.indexOf(firstNegative)

      positives.insert(index, firstNegative)
      positives.toArray
    */
