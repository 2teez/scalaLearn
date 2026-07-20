package com.progscala3.util

import scala.io.StdIn
import com.progscala3.util.Util

object Util:
  def userInput(msg: String): String =
    StdIn.readLine(msg).trim()
