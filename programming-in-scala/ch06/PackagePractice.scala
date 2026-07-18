package com.progscala3.packagepractice // root package

abstract class Fruit(val name: String, val color: String)

package show: // show package with only one function fruitDetails
  def fruitDetails(fruit: Fruit): String =
    s"${fruit.name} is ${fruit.color}"

object Fruits: // `static` object Fruits belongs to the root package
  object Orange extends Fruit("Orange", "Yellow")
  object Pear   extends Fruit("Pear", "Green")
  object Banana extends Fruit("Banana", "Yellow")

package Main:
  import com.progscala3.packagepractice.Fruits.*
  import com.progscala3.packagepractice.show.fruitDetails

  @main def main(args: String*): Unit =
    println((for fruit <- List(Orange, Banana, Pear)
    yield fruitDetails(fruit)).mkString("\n"))
