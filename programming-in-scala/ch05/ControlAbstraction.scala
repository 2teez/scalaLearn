package com.progscala3.controlabstraction

import scala.io.StdIn

@main def main(args: String*): Unit =
  val age = userInput("Enter your age:").toInt
  // using if expression
  if age < 18 then
    println("You are a minor. You can't vote.")
  else
    println("You are an adult.")

  // using match expression
  age match
    case age if age < 18 => println("You are a minor. You can't vote.")
    case age if age >= 18 => println("You are an adult.")

  // using control abstraction

object ControlAbstraction:
  def userInput(msg: String): String =
    println(msg)
    StdIn.readLine().trim
