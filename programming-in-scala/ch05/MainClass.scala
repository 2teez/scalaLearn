package com.progscala3.mainclass

import com.progscala3.abclasses._
import com.progscala3.subclasses._


@main def main(args: String*): Unit =
  val ve: Element = ElementVector(Vector("hello", "world"));
  println(ve.width)
