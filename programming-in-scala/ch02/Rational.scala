package com.progscala3.rational

class Rational(val n: Int, val d: Int):
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  def this(n: Int) = this(n, 1)

  def +(that: Rational): Rational =
    Rational(this.n * that.d + that.n * this.d, this.d * that.d)

  def +(that: Int): Rational =
    Rational(this.n + that * this.d, this.d)

  def -(that: Rational): Rational =
    Rational(this.n * that.d - that.n * this.d, this.d * that.d)

  def -(that: Int): Rational =
    Rational(this.n - that * this.d, this.d)

  def *(that: Rational): Rational =
    Rational(this.n * that.n, this.d * that.d)

  def *(that: Int): Rational =
    Rational(this.n * that, this.d)

  def /(that: Rational): Rational =
    Rational(this.n * that.d, this.d * that.n)

  def /(that: Int): Rational =
    Rational(this.n, this.d * that)

  override def toString: String = s"Rational(${n / g}/${d / g})"

  private def gcd(a: Int, b: Int): Int =
    if b == 0 then a else gcd(b, a % b)

object Rational:
  def apply(n: Int, d: Int): Rational =
    new Rational(n, d)
  def apply(n: Int): Rational         = new Rational(n)

  extension (r: Int)
    def +(that: Rational): Rational =
      Rational(r) + that

    def -(that: Rational): Rational =
      Rational(r) - that

    def *(that: Rational): Rational =
      Rational(r) * that

    def /(that: Rational): Rational =
      Rational(r) / that
