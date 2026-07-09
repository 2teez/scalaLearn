package com.progscala3.color

enum Colors extends Enum[Colors]:
  case RED, GREEN, BLUE

@main def Color(args: String*): Unit =
  val color = Colors.valueOf("BLUE")
  println(color)
