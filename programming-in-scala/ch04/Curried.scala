package com.progscala3.curried

import Curried.displayln

@main def main(args: String*): Unit =
  val twoPlusis = curried(2)
  println(twoPlusis)
  println(twoPlusis(3))

  displayln(twoPlusis(3), "twoPlusis(3)\n")

def curried(x: Int)(y: Int): Int = x + y

object Curried:
  def displayln(value: => Unit, label: String): Unit =
    print(label)
    value
