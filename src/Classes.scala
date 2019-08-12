abstract class Employee(
                         firstName: String,
                         lastName: String,
                         department: String,
                         salary: Double)

//defined class Employee
//
case class Engineer(firstName: String,
                    lastName: String,
                    department: String,
                    salary: Double,
                    group: String)
  extends Employee(
    firstName, lastName,
    department, salary)


case class Doctor(firstName: String,
                  lastName: String, department: String, salary: Double,
                  group: String) extends Employee(firstName, lastName,
  department, salary)

val eng1 = Engineer("Isaac", "Newton", "IT", 4530.50, "Engineering")
val eng2 = Engineer("Albert", "Einstein", "Infra", 4600.50, "Engineering")

println(eng1, eng2)

val doc1 = Doctor("Michael", "Young", "Cardio", 2000.5, "Medicine")
val doc2 = Doctor("Jeffrey", "Hall", "Pathology", 1100.5, "Medicine")

val engineers = List(eng1, eng2)
val doctors = List(doc1, doc2)
val employees = engineers ::: doctors

val emp2 = List(engineers, doctors).flatten
println(emp2)
println(employees.contains(doc1)) // true
println("-=======-")


// Now, let’s take another problem and develop an application using lists.
// Our task is to create a mini-dictionary containing at least the following words:
// apple, cow, color, god, goat, dog, house, mother, orange, rat, zeal, university.
// Here are the additional requirements:
// 1. Sort the words in ascending order.
// 2. Find whether there are duplicate words in the dictionary.
// 3. Find the total number of words in the dictionary.
// 4. Find whether the word “monkey” exists. Also check whether the word “university” exists.
// 5. Use immutable APIs as much as possible; however, you may use println for manual validation.

//abstract class Thing(name: String) {
//  implicit def ordering[A <: Thing]: Ordering[A] = Ordering.by(_.toString)
//}
//
////class Word(name: String) extends Thing(name)
//
//case class Animal(name: String) extends Ordered Thing(name)
//
//case class Fruit(name: String, taste: String) extends Thing(name)
//
////val dict = List(Animal("rat"), Fruit("apple"), Thing("color"), Thing("university"))
//val dict = List(Animal("rat"))
//println(dict.sorted)


val myDict = List("apple", "cow", "color", "god",
  "goat", "dog", "house", "mother", "orange", "house",
  "rat", "zeal", "university")

myDict.foreach(println)
myDict.sorted.foreach(println)

println("Duplicate words: ",
  myDict.groupBy(identity).collect {
    case (x, List(_, _, _*)) => x
  }.size)

println("Words count: ", myDict.size)
println(myDict.contains("monkey"))
println(myDict.contains("university"))
