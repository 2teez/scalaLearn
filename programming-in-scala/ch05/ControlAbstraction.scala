package com.progscala3.controlabstraction

import scala.io.StdIn
import major._

@main def main(args: String*): Unit =
  val age = userInput("Enter your age: ").toInt
  // using if expression
  if age < 18 then
    println("You are a minor. You can't vote.")
  else
    println("You are an adult.")

  // using match expression
  age match
    case age if age < 18  => println("You are a minor. You can't vote.")
    case age if age >= 18 => println("You are an adult.")

  // using control abstraction
  checkAge(age)(_ >= 18)
  checkAge(age,
    whenTrue = "You are a minor. You can't vote",
    whenFalse = "You are an adult.") {
    _ < 18
  }

object major:
  def userInput(msg: String): String =
    print(msg)
    StdIn.readLine().trim

  def checkAge(
      age: Int,
      whenTrue: String = "You are an adult.",
      whenFalse: String = "You are a minor. You can't vote."
  )(f: Int => Boolean): Unit =
    if f(age) then println(whenTrue)
    else println(whenFalse)
