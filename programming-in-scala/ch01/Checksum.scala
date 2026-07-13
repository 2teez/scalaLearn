package com.progscala3.checksum

@main def main(args: String*): Unit =
  val acc = ChecksumAccumulator()
  val csa = new ChecksumAccumulator

  csa.add(1)
  println(csa.checksum())

class ChecksumAccumulator:
   private var sum = 0

   def add(b: Byte): Unit =
     sum += b

   def checksum(): Int = ~(sum & 0xFF) + 1
