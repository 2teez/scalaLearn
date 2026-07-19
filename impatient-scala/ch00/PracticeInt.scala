package com.progscala3.practiceint

  package practice.newint:
    trait DoubleCross:
      def ++(): Int

    case class MyInt(value: Int) extends DoubleCross:
      export value.*
      def ++(): Int = value + 1

  @main def main(args: String*): Unit =
    import practice.newint.MyInt
    val value = MyInt(3)
    println(s"Started Value: $value")
    val nValue = value + 1
    println(s"Changed Value: ${nValue}; $value; ${value.++()}")
