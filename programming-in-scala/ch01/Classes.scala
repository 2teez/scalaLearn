package com.progscala3.classes

@main def main(args: String*): Unit =
  val person = Person("Alice", 30)
  println(person)
  println(person.toString)
  //
  val another = AnotherPerson("Bob", 25)
  println(another)
  println(another.toString)

case class Person(name: String, age: Int)

class AnotherPerson(name: String, age: Int):
  override def toString: String = s"AnotherPerson($name, $age)"
