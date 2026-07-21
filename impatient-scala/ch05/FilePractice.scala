package com.progscala3.filepractice

import scala.io.{Source, BufferedSource}
import com.progscala3.util.Util.*
import java.io.FileNotFoundException

@main def main(args: String*): Unit =
  val file = userInput("Enter filename: ").trim()
  try
    val fileSource = Source.fromFile(file)
    try
      val lines = fileSource.getLines()
      for line <- lines do println(line)
    finally
      fileSource.close()
  catch
    case ex: FileNotFoundException => println(ex.getMessage)
    case ex: Exception             => println(ex.getMessage)
