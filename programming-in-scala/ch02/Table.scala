package com.progscala3.table

@main def main(args: String*): Unit =

  // using iteration loops; namely while and for
  makeWhileTable(6, 6)
  makeForTable(6, 6)

  // using recursion
  println(makeTable(6, 6))
  printTable(3, 3, makeTable, "recursion table maker:")

  def makeWhileTable(rows: Int, cols: Int): Unit =
    var row = 1
    while row < rows do
      var col = 1
      while col < cols do
        printf(s" %3d * %3d = %3d ", col, row, col * row)
        col += 1
      println()
      row += 1

  def makeForTable(rows: Int, cols: Int): Unit =
    for
      row <- 1 until rows
      col <- 1 until cols
    do
      printf(s" %3d * %3d = %3d ", col, row, col * row)
      if col == cols - 1 then println()

  def makeRow(row: Int): String =
    (for
      col <- 1 until 6
    yield s" %3d * %3d = %3d " format (col, row, col * row))
      .mkString

  def makeTable(rows: Int, cols: Int): String =
    (for
      row <- 1 until rows
    yield makeRow(row))
      .mkString("\n")

  def printTable(rows: Int, cols: Int, tableMaker: (Int, Int) => String, msg: String): Unit =
    println(msg)
    println(tableMaker(rows, cols))
