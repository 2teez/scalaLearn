package com.progscala3.exe4

trait App:
  def reversal(strs: Array[String]): String =
     (strs.reverse).mkString(" ").trim()

trait Description:
  def describe(): String = s"this"

class Point(x: Int, y: Int):
  override def toString(): String = s"Point[x=${x}, y=${y}]"

object Point extends Description:
  private val x: Int = 0
  private val y: Int = 0
  def apply(x: Int = 0, y: Int = 0): Point = new Point(x, y)
  override def describe(): String = s"Point[x=${x}, y=${y}]"

def say(what: App, msg: Array[String]): Unit =
  println(what.reversal(msg))

class Application extends App

@main def main(args: String*): Unit =
  val pt = Point(2, 7)
  println(pt)
  println(Point.describe())
  //
  say(new Application, "Hello, World".split(","))
