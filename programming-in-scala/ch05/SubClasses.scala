package com.progscala3.subclasses

import com.progscala3.abclasses.Element

// class ElementVector(cont: Vector[String]) extends Element:
  // can be overridden using the override keyword
  // or by using the val keyword
  //val contents: Vector[String] = cont
// the above class is equivalent to the following:
class ElementVector(val contents: Vector[String]) extends Element
