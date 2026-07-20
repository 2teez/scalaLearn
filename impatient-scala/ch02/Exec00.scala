package com.progscala3.exec00

import java.util.Random
import scala.collection.mutable.ArrayBuffer
import com.progscala3.util.Util.*
import ArrayPractice.*

@main def main(args: String*): Unit =
  val randomNumber: Int = userInput("Enter a random number: ").toInt
  generateInclusiveArray(randomNumber).foreach(print)
  println()
  generateExclusiveArray(randomNumber).foreach(print)
  println()
  //
  val num = Array(1, 2, 3, 4, 5, 6)
  //var counter = 0
  val buffer2 = ArrayBuffer[Int]()
  var index = 0
  while index <= num.length - 1 do
    if index == num.length - 1 then buffer2 += num(index)
    else
      val (first, second) = swapper(num(index), num(index+1))
      buffer2 += (first, second)
    index += 2
  println(buffer2)
  //
  // Average of array of double, and arraybuffer of doubles
  val arraysOfDoubles: Array[Double] = Array(4.5, 1.01, 3.8, 0.09, 4.13)
  println(averageOf(arraysOfDoubles))

package ArrayPractice:

  def averageOf(values: Array[Double]): Double =
    var sum = 0.0D
    for n <- values do sum += n
    sum / values.size.toDouble


  def swapper(first: Int, second: Int): (Int, Int) = (second, first)
  def generateInclusiveArray(n: Int): Array[Int] =
    val buffer = ArrayBuffer[Int]()
    for num <- 0 to n do buffer += num
    buffer.toArray

  def generateExclusiveArray(n: Int): Array[Int] =
    val buffer = ArrayBuffer[Int]()
    for num <- 0 until n do buffer += num
    buffer.toArray
