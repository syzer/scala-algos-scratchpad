/**
 * Created by lukas on 05/08/19.
 */

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
}

