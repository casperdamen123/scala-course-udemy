package lectures.part3fp

object AnonymousFunctions extends App {

  // anonymous function (LAMBDA)
  val doubler = (x: Int) => x * 2

  // equivalent to
  // val doubler: Int => Int = x => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a, b) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }
  val stringToInt2: String => Int = a => a.toInt

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdded: (Int, Int) => Int = _ + _

  /*
    1. MyList: replace all FunctionX calls with lambdas
    2. Rewrite the "special" adder as an anonymous function
   */

  println(stringToInt2("4"))

  println(doubler(3)) // 6
  println(adder(3, 4)) // 7

  println(justDoSomething) // function itself
  println(justDoSomething()) // call

}
