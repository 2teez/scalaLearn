package com.progscala3.rationalmain

import com.progscala3.rational.Rational

@main def main(args: String*): Unit =
  val x = Rational(1, 2)
  val y = Rational(2, 3)
  val z = x + y
  println(z)
  //
  println(x + x * y)
  println(2 * y + x)
