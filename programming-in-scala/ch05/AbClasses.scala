package com.progscala3.abclasses

abstract class Element:
  def contents: Vector[String]
  def height: Int = contents.length
  def width: Int = if contents.isEmpty then 0 else contents(0).length
