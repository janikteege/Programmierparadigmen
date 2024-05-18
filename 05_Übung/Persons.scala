//Zusammenarbeit von Janik Teege und Nele Hüsemann


import java.time.LocalDate;
import java.time.Period;

class Person(
  val firstname: String,
  val lastname: String,
  val dayOfBirth: LocalDate
) {
  override def toString(): String = {
    firstname + " " + lastname
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val persons = List(
      new Person("Kerstin", "Herz", LocalDate.of(1995, 5, 31)),
      new Person("Matthias", "Zimmermann", LocalDate.of(1950, 1, 23)),
      new Person("Jana", "Schultheiss", LocalDate.of(1973, 10, 10)),
      new Person("Jennifer", "Fischer", LocalDate.of(1944, 12, 4)),
      new Person("Andreas", "Kaufmann", LocalDate.of(1964, 4, 3))
    );
    val lastNames = persons.map(person => person.lastname)
    val birthdayOctober = persons.filter(person => person.dayOfBirth.getMonthValue == 10)
    val age = persons.map(person => Period.between(person.dayOfBirth, LocalDate.now()).getYears())
    val averageAge = age.sum / age.size
    
    println(lastNames)
    println(birthdayOctober)
    println(age)
    println(averageAge)
  }

} 
