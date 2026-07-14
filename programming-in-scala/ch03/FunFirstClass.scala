package com.progscala3.funfirstclass

import Summation._
import Recursion._
import scala.annotation.tailrec

@main def main(args: String*): Unit =
  // using a first-class function
  val summation = (x: Int, y: Int) => x + y
  val result = summation(2, 3) //> result: Int = 5
  // display the result, using a first-class function as an argument
  display(() => println(result), "Addition: ")
  // using result as a partial function
  // apply the partial function to a value
  val partial = summation(2, _: Int) /// = summation(value, _) // without indicating, type
  display(() => println(partial(8)), "Partial Function: ") //> Partial Function: 10
  //
  // using recursion to calculate the Fibonacci sequence
  display(() => println(factorial(5)), "Factorial: ") //> Factorial: 120
  val one120 = factorial(_)
  display(() => println(factorialWithTailRecursion(one120(5))),
    "Factorial with Tail Recursion: ") //> Factorial with Tail Recursion: 120

object Summation:
  def display(f: () => Unit, label: String): Unit =
    print(label)
    f()

object Recursion:
  def factorial(n: BigInt): BigInt =
    if n <= 1 then n
    else n * factorial(n - 1)

  def factorialWithTailRecursion(n: BigInt): BigInt =
    @tailrec
    def factWithTailRecursion(n: BigInt, acc: BigInt): BigInt =
      if n <= 1 then acc
      else factWithTailRecursion(n - 1, acc * n)

    factWithTailRecursion(n, 1)
