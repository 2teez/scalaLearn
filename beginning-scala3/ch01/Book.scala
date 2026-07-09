package com.progscala3.book

class Book(val name: String, val isbn: String):
  override def toString: String = s"Book($name, $isbn)"
