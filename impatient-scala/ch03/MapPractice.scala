package com.progscala3.mappractice

@main def main(args: String*): Unit =
  val langs = Map("Java" -> 30, "C++" -> 39, "C" -> 42)
  for (key, value) <- langs do println(s"$value => $key")
  val invertedMap = for(key, value) <- langs yield value -> key
  println(invertedMap)
  println(invertedMap.getOrElse(28, "Perl"))
