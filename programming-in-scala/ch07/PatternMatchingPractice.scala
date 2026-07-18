package com.progscala3.patternmatchingpractice

  import expressions.*

  def simplifyTop(expr: Expr): Expr =
    expr match
      case UnOp("-", UnOp("-", e)) => e
      case BinOp("+", e, Num(0)) => e
      case BinOp("*", e, Num(1)) => e
      case _ => expr
package expressions:
  trait Expr
  case class Var(name: String) extends Expr
  case class Num(number: Double) extends Expr
  case class UnOp(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

package main:
  @main def main(args: String*): Unit =
    val x = Var("21")
    println(BinOp(("*"), x, Num(23)))
