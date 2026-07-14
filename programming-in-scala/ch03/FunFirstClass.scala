package com.progscala3.funfirstclass

import Summation._

@main def main(args: String*): Unit =
  // using a first-class function
  val summation = (x: Int, y: Int) => x + y
  val result = summation(2, 3) //> result: Int = 5
  // display the result, using a first-class function as an argument
  display(() => println(result), "Addition: ")
  // using result as a partial function
  // apply the partial function to a value
  val partial = summation(2, _: Int)
  display(() => println(partial(8)), "Partial Function: ") //> Partial Function: 10

object Summation:
  def display(f: () => Unit, label: String): Unit =
    print(label)
    f()
