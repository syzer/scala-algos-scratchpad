import scala.runtime.ScalaRunTime._
import java.util.Calendar
import scala.collection.immutable.Stream._

object MemoizationAndLazy extends App {
  lazy val lazyTime = Calendar.getInstance.getTime // lazy is reserved keyword
  val eagerTime = Calendar.getInstance.getTime

  println(lazyTime)
  println(eagerTime)

  def myMethod(myArg: () => Int) =
    println(myArg())

  myMethod(() => 5)

  def calcFactorial(x: Int): Int = {
    if (x == 0 || x == 1)
      1
    else {
      println("Computing factorial")
      x * calcFactorial(x - 1)
    }
  }

  calcFactorial(5)

  // streams
  val myNums = Stream(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  myNums(3)

  val myTestSteam = cons('a', empty)
}

