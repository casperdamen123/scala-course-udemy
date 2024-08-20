package lectures.part1basics

import scala.language.postfixOps

object Expressions extends App {

  val x = 1 + 2 // EXPRESSION

  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= ... side effects
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)
  private val aCondition = true
  private val aConditionedValue = if (aCondition) 5 else 3 // IF EXPRESSION

  println(aConditionedValue)

  // NEVER WRITE THIS AGAIN.
  private var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // EVERYTHING in Scala is an Expression!
  private val aWeirdValue: Unit = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // this is not possible, since z is not defined outside the code block
  // val anotherValue = z + 1

  val someValue = {
    2 < 3
  }
}
