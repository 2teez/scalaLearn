package com.progscala3.rational

class Rational(val n: Int, val d: Int):
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  def this(n: Int) = this(n, 1)
  override def toString: String = s"Rational(${n / g}/${d / g})"
  private def gcd(a: Int, b: Int): Int =
    if b == 0 then a else gcd(b, a % b)

object Rational:
  def apply(n: Int, d: Int): Rational =
    new Rational(n, d)
  def apply(n: Int): Rational         = new Rational(n)
