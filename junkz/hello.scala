@main def m() = {
  println(f"Summation of values: ${sum(1, 6, 9, 40, 2)}")
    println(
      f"Summation of values using recursive Summation: ${
        recursiveSum(1, 6, 9, 40, 2)}")
}

def sum(args: Int*) = {
  var result = 0
  for i <- args do result += i
  result
}

def recursiveSum(args: Int*): Int = if args.length == 0 then 0
                                    else args.head + recursiveSum(args.tail*)
