package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${name} is hanging out with ${person.name}"
    def +(nickname: String): String = s"${name} ($nickname)"
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(n: Int) = s"${this.name} watched ${this.favoriteMovie} $n times"
    def learns: String = s"${this.name} learns Scala"
    def learnsScala: String = learns
  }

  val mary = new Person("Mary", "Inception", 12)
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (syntactic sugar)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club", 13)
  
  println(mary. + (tom))
  println(mary + "the rockstar")
  println(+mary.age)
  println(mary learnsScala)
  println(mary.apply(2))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS
  // Akka actors have ! ?

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix
  println(mary.isAlive)
//  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  /*
  1. Overload the + operator
      mary + "the rockstar" => new person with new name "Mary (the rockstar)"
  2. Add an age to the Person class
     Add a unary + operator => new person with the age + 1
     +mary => mary with the age incrementer
  3. Add a "learns" method in the Person class => "Mary learns Scala"
     Add a learnsScala method, calls learn method with "Scala"
     Use it in postfix notation.
  4. Overload the apply method
     mary.apply(2) => "Mary watched Inception 2 times"
   */

}
