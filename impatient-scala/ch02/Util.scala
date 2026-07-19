package com.progscala3.util

import scala.io.StdIn

object Util:
  def userInput(msg: String): String =
    StdIn.readLine(msg).trim()
