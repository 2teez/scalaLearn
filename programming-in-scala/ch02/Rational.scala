package com.progscala3.rational

class Rational(n: Int, d: Int):
  require(d != 0)
  def this(n: Int) = this(n, 1)
  override def toString: String = s"Rational($n/$d)"

object Rational:
  def apply(n: Int, d: Int): Rational =
    new Rational(n, d)
  def apply(n: Int): Rational         = new Rational(n)
