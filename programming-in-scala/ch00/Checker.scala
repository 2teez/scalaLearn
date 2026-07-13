package com.progscala3.checker

import java.io.Console

@main def main(args: String*): Unit =
  println(User.input("Enter a name: ").exists(_.isUpper))

  object User:
    def input(prompt: String): String =
      System.console().readLine(prompt)
