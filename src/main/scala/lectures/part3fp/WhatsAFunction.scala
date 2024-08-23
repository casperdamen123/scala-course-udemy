package lectures.part3fp

object WhatsAFunction extends App {

  // DREAM: use functions as first class elements
  // problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2)) // 4

  // function types = Function1[A, B]
  val stringToIntConverter = new((String) => Int) {
    override def apply(string: String): Int = string.toInt
  }

  val adder = new((Int, Int) => Int) {
    override def apply(a: Int, b: Int): Int = a + b
  }

  trait MyPredicate[-T] {
    def test(elem: T): Boolean
  }

  trait MyTransformer[-A, B] {
    def transform(elem: A): B
  }

  val my_predicate = new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }

  val my_transformer = new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }

  println(stringToIntConverter("3") + 4) // 7
  println(adder(4, 5)) // 9

  /*
    1. a function which takes 2 strings and concatenates them
    2. transform the MyPredicate and MyTransformer into function types
    3. define a function which takes an int and returns another function which takes an int and returns an int
      - what's the type of this function
      - how to do it
   */

  val concatenator = new ((String, String) => String) {
    override def apply(a: String, b: String): String = a + b
  }
  println(concatenator("Hello, ", "Scala")) // Hello, Scala

  val superAdder = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val superAdder1 = (x : Int) => (y : Int) => x + y
  val superAdder2: Int => Int => Int = x => y => x + y

  println(superAdder2(3)(4)) // 7
  val adder3 = superAdder2(3)

  println(adder3(4)) // 7
  println(superAdder2(3)(4)) // 7 // curried function

}



trait MyFunction[A, B] {
  def apply(element: A): B
}