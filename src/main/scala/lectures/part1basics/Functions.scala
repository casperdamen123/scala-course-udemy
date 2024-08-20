package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  private def aFunction (a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  private def aParameterlessFunction(): Int = 42 // You can call this function without parentheses

  println(aParameterlessFunction())

  private def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION


  // 1. A greeting function (name, age) => "Hi, my name is $name, and I am $age years old."

  private def greet(name: String, age: Int) = {

    "Hi my name is " + name + " and I am " + age + " years old"

  }

  println(greet("Casper", 10))

  // 2. Factorial function 1 * 2 * 3 ... * n
  private def factorial(n: Int): Int = {

    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  println(factorial(5))

  // 3. A Fibonacci function
  private def fibonacci(n: Int): Int = {

    if (n <= 1) 1
    else fibonacci(n - 1) + fibonacci(n - 2)

  }

  println(fibonacci(10))

  // 4. Test if a number is prime
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)

  }

}
