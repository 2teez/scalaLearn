package com.progscala3.abclasses

//import com.progscala3.subclasses._

import com.progscala3.abclasses.Element._

abstract class Element:
  def contents: Vector[String]
  def height: Int = contents.length
  def width: Int = if contents.isEmpty then 0 else contents(0).length
  def above(that: Element): Element =
    VectorElement(this.contents ++ that.contents)
  def beside(that: Element): Element =
    VectorElement(
      for (line1, line2) <- this.contents.zip(that.contents) yield line1 + line2
    )
  override def toString(): String = contents.mkString("\n")
end Element

object Element:
  private class VectorElement(val contents: Vector[String]) extends Element

  private class LineElement(s: String) extends Element:
    val contents = Vector(s)
    override def width = s.length
    override def height = 1

  private class UniformElement(
    ch: Char,
    override val width: Int,
    override val height: Int
  ) extends Element:
    private val line = ch.toString * width
    def contents = Vector.fill(height)(line)

  def elem(contents: Vector[String]): Element = VectorElement(contents)

  def elem(char: Char, width: Int, height: Int): Element =
      UniformElement(char, width, height)

  def elem(line: String): Element =
      LineElement(line)
end Element
