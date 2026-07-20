package com.progscala3.exer00

import java.util.Random
import Functions.*

package Functions:
  def minmax(values: Array[Int]): Option[(Int, Int)] =
    if values.isEmpty then None
    else Some(values.min, values.max)

  def generateRandomArray(len: Int = 6, size: Int = 10): Array[Int] =
      val rand = Random()
      (for _ <- 0 to len yield rand.nextInt(size)).toArray

@main def main(args: String*): Unit =
  val array = generateRandomArray(len = 0)
  array.foreach(print)
  println()
  println(
    minmax(Array[Int]()) match
      case Some(min, max) => s"$min, $max"
      case _ => "None"
  )
