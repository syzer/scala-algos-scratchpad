/**
 * Created by lukas on 05/08/19.
 */
import scala.runtime.ScalaRunTime._

object Hello extends App {
  val myNumbers = Array(0, 2, 4, 6, 8, 10)
  println("Hello, World!", stringOf(myNumbers))
  println(myNumbers(2)) // 4

  val numMult2 = myNumbers.map(_ * 2)
  println(stringOf(numMult2))

  // reverse
  println(stringOf(myNumbers.reverse))

  // concat
  println(stringOf((myNumbers ++ myNumbers))) // Array(0, 2, 4, 6, 8, 10, 0, 2, 4, 6, 8, 10)

  // map-reduce
  println(stringOf(myNumbers.filter(x => x == 2)))
  println(stringOf(myNumbers.contains(2))) // same as exists

  // string
  val fruits = Array("banana", "apple","orange")
  println(stringOf(fruits.sorted))

}
