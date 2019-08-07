// Exercise 4.3. Get, Average, and Reversal Given a list, perform the following:
// 1. Given an integer index, get the value corresponding to this index.
// 2. Calculate the average of values.
// 3. Reverse the list.
// 4. Get the last element using foldLeft.
// 5. Calculate the length using foldLeft.

val elems = List(1, 2, 3, 4, 5)
println(elems)
elems.foldLeft(0)(_ + _)

def indexOf(elems: List[Int], elem: Int): Int = {
  val index = -1
  elems.foldLeft(0)((acc, curr) => {
    //    println(x, i)
    if (curr == elem) {
      println(index)
    }
    -1
  })
  //  -1
}

val num1 = indexOf(elems, 2)
println(num1)

println("Answer ", 3, "Reverse",
  elems.reverse)
println("Answer ", 4, "Last elem",
  elems.foldLeft(0)((acc, e) => e))
println("Answer ", 5, "Length",
  elems.foldLeft(0)((acc, e) => acc + 1))
