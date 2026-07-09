package com.progscala3.color

enum Colors extends Enum[Colors]:
  case Red, Green, Blue

@main def Color(args: String*): Unit =
  val color = Colors.valueOf("Blue")
  println(color)
