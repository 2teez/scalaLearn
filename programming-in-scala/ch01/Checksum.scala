package com.progscala3.checksum

import scala.collection.mutable

@main def main(args: String*): Unit =
  val acc = ChecksumAccumulator()
  val csa = new ChecksumAccumulator

  csa.add(1)
  println(csa.checksum())

  println(ChecksumAccumulator.calculate("Every value is an object to be considered seriously."))

class ChecksumAccumulator:
  private var sum        = 0
  def add(b: Byte): Unit = sum += b
  def checksum(): Int    = ~(sum & 0xff) + 1

object ChecksumAccumulator:
  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int =
    if cache.contains(s) then
      cache(s)
    else
      val acc = new ChecksumAccumulator
      for c <- s do
        acc.add((c >> 8).toByte)
        acc.add(c.toByte)

      val cs = acc.checksum()
      cache(s) = cs
      cs
