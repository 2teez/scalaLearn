package com.progscala3.hof

import java.io.File
import FileMatcher._

@main def main(args: String*): Unit =
  println(filesEnding(".scala").mkString(", "))

object FileMatcher:
  private def filesGetter: Array[File] = new File(".").listFiles()

  def filesEnding(query: String): Array[File] =
    // filesGetter.filter(_.getName.endsWith(query))
    for file <- filesGetter if file.getName.endsWith(query)
    yield file
