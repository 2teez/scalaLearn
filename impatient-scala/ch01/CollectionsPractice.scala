package com.progscala3.collectionspractice

import scala.collection.mutable.ArrayBuffer

@main def main(args: String*): Unit =
  val names = ArrayBuffer[String]()
  names += "java"; names += "clojure"; names += "groovy"
  println(names)
  names.insertAll(0, Array("perl", "bash", "python"))
  println(names.toArray.mkString(","))
