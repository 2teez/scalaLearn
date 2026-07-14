package com.progscala3.curried

@main def main(args: String*): Unit =
  val twoPlusis = curried(2)
  println(twoPlusis)
  println(twoPlusis(3))

def curried(x: Int)(y: Int): Int = x + y
