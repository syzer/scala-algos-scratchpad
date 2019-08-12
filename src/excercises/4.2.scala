// Exercise 4.2. Application
// of fold, foldLeft, and f oldRight
// Functions
// Given the following signature for three implementations of folding— f old, f oldLe f t,
// and f oldRight, write sample programs of your choice to demonstrate how these
//  functions work. In your explanation, show detailed calculation steps for at least one
// application, demonstrating operations for all three functions.

val elems = List(1, 2, 3, 4, 5)
println(elems)
elems.foldLeft(0)(_ + _)


// fold is
// def fold[A1 >: A](z: A1)(op: (A1, A1) => A1): A1
// so A1 has to be subtype of A
// so it knows how to aggregate so can be run in **parallel**
println(elems.fold(0) { (z, i) =>
  z + i
})

class Person(val name: String, val age: Int, val sex: Symbol)

object Person {
  def apply(name: String, age: Int, sex: Symbol) = new Person(name, age, sex)
}

val persons =
  Person("Hugh Jass", 25, 'male) ::
  Person("Biggus Dickus", 43, 'male) ::
  Person("Incontinentia Buttocks", 37, 'female) ::
  Nil


val personList = persons.foldLeft(List[String]()) { (left, right) =>
  val salutation = right.sex match {
    case 'male => "Mr."
    case 'female => "Ms."
  }
  left :+ s"${salutation} ${right.name}, ${right.age}"
}

println(personList(0))
println(personList(1))
println(personList(2))
