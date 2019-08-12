import scala.runtime.ScalaRunTime._
import scala.collection.immutable.Stream._

object Prime {

  def main(args: Array[String]): Unit = {
    println(primes.take(10000).toList)
    // List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47)
  }

  val primes: Stream[Int] = 2 #:: Stream.from(3)
    .filter {
      x => {
        val sqrtOfPrimes = primes.takeWhile(y =>
          y <= math.sqrt(x))

        !sqrtOfPrimes.exists(y => x % y == 0)
      }
    }

}

