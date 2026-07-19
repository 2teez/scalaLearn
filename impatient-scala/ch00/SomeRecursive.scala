package com.progscala3.somerecursive

import scala.annotation.tailrec
import Func.*

object Func:
  def recSum(args: Int*): Int =
    args.length match
      case 0 => 0
      case _ => args.head + recSum(args.tail*)

  def recSummation(args: Int*): Int =
    @tailrec
    def rInner(acc: Int, args: Int*): Int =
      if args.length == 0 then acc
      else rInner(acc + args.head, args.tail*)
    rInner(0, args*)

  def recCount[T](args: T*): Int =
      @tailrec
      def innerCounter(acc: Int, args: T*): Int =
        if args.length == 0 then acc
        else innerCounter(acc + 1, args.tail*)
      innerCounter(0, args*)

  def recReverse[T](args: List[T]): List[T] =
    @tailrec
    def innerReversal(args: List[T], nl: List[T]): List[T] =
      if args.length == 0 then nl
      else innerReversal(args.tail, args.head :: nl )
    innerReversal(args, List.empty)

@main def main(args: String*): Unit =
  val r = 1 to 5
  println(recSum(r*))
  println(recSummation(r*))
  println(recCount(List("java", "clojure", "scala")*))
  println(recReverse(List("java", "javaScript", "scala", "kotlin")))
  val oneTo25 = 1.to(25).toList
  println(recReverse(oneTo25))
