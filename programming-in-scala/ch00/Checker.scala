package com.progscala3.checker

import java.io.Console

@main def main(args: String*): Unit =
  val name = System.console().readLine("Enter a name: ")
  if name == null then return
  println(name.exists(_.isUpper))
