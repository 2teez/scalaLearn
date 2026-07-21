package com.progscala3.filepractice

import scala.io.Source
import com.progscala3.util.Util.*
import java.io.FileNotFoundException

@main def main(args: String*): Unit =
   val file = userInput("Enter filename: ").trim()
   try
     var fileSource = Source.fromFile(file)
     for line <- fileSource.getLines() do println(line)
   catch ex => println(ex)
