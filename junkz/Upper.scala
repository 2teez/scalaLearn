
class Upper1:
  def convert(str: Seq[String]): Seq[String] =
    str.map((s: String) => s.toUpperCase)

@main def m() =
    val upper = new Upper1()
    println(upper.convert(List("Hello, World")))
