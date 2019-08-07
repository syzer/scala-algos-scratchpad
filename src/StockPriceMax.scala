object MaxContSubArrayApp {
  def main(args: Array[String]): Unit = {
    // => 27
    val bufferedSource = io.Source.fromFile("./data/series.csv")
    for (line <- bufferedSource.getLines) {
      val dayilyDiffs = line.split(",").map(_.trim).map(_.toInt).toVector
      println(findContSubArrayMax(dayilyDiffs))
    }
    bufferedSource.close
  }

  //  sum of the maximum producing continuous subarray,
  // AKA is the maximum stock price increase
  def findContSubArrayMax(data: Vector[Int]): Int =
    data match {
      case Vector(x) => x
      case _ => {
        val (l, r) = data.splitAt(data.length / 2)
        val leftMax = findContSubArrayMax(l)
        val rightMax = findContSubArrayMax(r)
        val leftRightCrossMaxVal = leftRightCrossMax(l, r)
        List(leftMax, rightMax, leftRightCrossMaxVal).max
      }
    }

  // computes the sum of the maximum of the left subarray sums and the maximum of the right subarray sums
  def leftRightCrossMax(leftSub: Vector[Int], rightSub: Vector[Int]): Int = {
    val collLeftSums = for (i <- 1 to leftSub.length) yield
      leftSub.takeRight(i).sum
    val collRightSums = for (i <- 1 to rightSub.length) yield
      rightSub.take(i).sum
    collLeftSums.max + collRightSums.max
  }
}
