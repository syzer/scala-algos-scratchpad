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

val eng1 = Engineer("Isaac", "Newton", "IT", 4500.50, "Engineering")

println(eng1)
