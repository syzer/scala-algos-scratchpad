object DecimalToBinaryConvApp {
  def main(args: Array[String]): Unit = {
    println(decToBinConv(3))
    println(decToBinConv(12))
  }

  def decToBinConv(x: Int): String = {
    Iterator
      .iterate(x)(a => a / 2)
      .takeWhile(a => a > 0)
      .map(x => x % 2)
      .mkString
      .reverse
  }
}
