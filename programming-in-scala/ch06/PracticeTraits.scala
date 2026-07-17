package com.progscala3.practicetraits

trait Philosophical:
  def philosophize: Unit =
    println("I consume memory, therefore I am!")

trait HasLegs

class Animal
class Frog extends Animal, Philosophical, HasLegs:
  override def toString: String = "green!"

@main def main(args: String*): Unit =
  val frog = Frog()
  frog.philosophize
  val phil: Philosophical = frog
  phil.philosophize
