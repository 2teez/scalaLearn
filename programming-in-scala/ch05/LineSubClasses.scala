package com.progscala3.linesubclasses

import com.progscala3.subclasses._

class LineElement(s: String) extends ElementVector(Vector(s)):
  override def width: Int = s.length
  override def height: Int = 1
