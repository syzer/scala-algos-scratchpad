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
  var index = -1
  var currIndex = 0
  elems.foldLeft(0)((acc, curr) => {
    currIndex = currIndex + 1
    if (curr == elem) {
      index = currIndex
    }
    index
  })
}

println("Answer ", 1, "indexOf",
  indexOf(elems, 3))
println("Answer ", 2, "Average",
  elems.sum / elems.length)
println("Answer ", 3, "Reverse",
  elems.reverse)
println("Answer ", 4, "Last elem",
  elems.foldLeft(0)((acc, e) => e))
println("Answer ", 5, "Length",
  elems.foldLeft(0)((acc, e) => acc + 1))
