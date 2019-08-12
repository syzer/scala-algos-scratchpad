import scala.runtime.ScalaRunTime._

object Counts extends App {
  val counts = Array(
    "666,google.com",
    "60,mail.yahoo.com",
    "10,mobile.sports.yahoo.com",
    "40,sports.yahoo.com",
    "10,stackoverflow.com",
    "2,en.wikipedia.org",
    "1,es.wikipedia.org",
    "1,mobile.sports")

  println(stringOf(counts))

  val countsMap = counts.map(_.split(",")).map {
    case Array(s1,s2) => (s1,s2)}

  println(stringOf(countsMap))

  val comCounts = countsMap.map {
    case(x,y) if y.endsWith(".com") => x.toInt
    case _ => 0
  }.reduceLeft(_ + _)

  println(stringOf(comCounts)) // 786


  // Vectors - like immutable array
  val myFruits = List("grape", "banana", "apple", "mango")
  val myFruits2 = Vector("grape", "banana", "apple", "mango")

  val combinedFruits = myFruits ++ myFruits2
  val apples = combinedFruits.filter(x => x == "apple")
  println(stringOf(apples)) // List(apple, apple)


  val grouped = combinedFruits groupBy {x => x.length}
  println(stringOf(grouped)) //HashMap(5 -> List(grape, apple, mango, grape, apple, mango), 6 -> List(banana, banana))

}

