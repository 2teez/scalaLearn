package com.progscala3.book

class Book(val name: String = "", val isbn: String = "isbn-000"):
  override def toString: String = s"Book($name, $isbn)"
