package lectures.part2oop

object OOBasics extends App {

  // test person
  private val person = new Person()
  println(person.age)
  person.greet("Daniel")

  // test writer/novel
  val casper = Writer("Casper", "Damen", 1993)
  val my_novel = Novel("Trees", 2010, casper)
  println(my_novel.authorAge)
  println(my_novel.isWrittenBy(casper))
  val new_novel = my_novel.copy(2011)
  println(new_novel.authorAge)

  // test counter
  val counter = Counter(10)
  counter.dec(4)

}

  // constructor
  class Person(name: String, val age: Int) {
    // body
    val x = 2

    println(1 + 3)

    // method
    def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

    // overloading
    def greet(): Unit = println(s"Hi, I am $name")

    // multiple constructors
    def this(name: String) = this(name, 0)

    def this() = this("John Doe")

    // class parameters are NOT FIELDS

  }


  // exercises
  // 1. writer + novel
  class Writer(firstName: String, surname: String, val birthYear: Int) {

    def fullName(): String = firstName + " " + surname

  }

  class Novel(name: String, var releaseYear: Int, writer: Writer) {

    def authorAge: Int = releaseYear - writer.birthYear

    def isWrittenBy(author: Writer): Boolean = this.writer == author

    def copy(newReleaseYear: Int): Novel = {
      Novel(name = this.name, releaseYear = newReleaseYear, writer = this.writer)
    }

  }

class Counter(val count: Int) {

  def inc: Counter = {
    println("Incrementing...")
    Counter(count + 1)
  }

  def dec: Counter = {
    println("Decrementing...")
    Counter(count - 1)
  }

  def inc(n : Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }
  
  def dec(n : Int): Counter = {
    if (n >= 0) this
    else dec.dec(n + 1)
  }
  
  def print(): Unit = println(count)

}







