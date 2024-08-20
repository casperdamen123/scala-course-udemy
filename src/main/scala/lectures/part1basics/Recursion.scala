package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println(s"Computing factorial of $n - I first need factorial of ${n - 1}")
      val result = n * factorial(n - 1)
      println(s"Computed factorial of $n")
      result
    }

  println(factorial(10))

  // println(factorial(5000)) will result in StackOverflowError because recursive depth is too big

  private def anotherFactorial(n: Int): Int = {
    @tailrec
    def factHelper(x: Int, accumulator: Int): Int =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)

    factHelper(n, 1)

  }

  // print(anotherFactorial(5000)) // TAIL RECURSION = use recursive call as the LAST expression


  // 1. Concatenate a string n times
  @tailrec
  private def concatenateString(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatenateString(aString, n - 1, accumulator)
  }

  println(concatenateString("hello", 3, ""))

  // 2. IsPrime function recursive
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)

  }

  // 3. Fibonacci function, tail recursive
  // 3. A Fibonacci function
  private def fibonacci(n: Int): Int = {

    @tailrec
    def fibonacciTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fibonacciTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fibonacciTailrec(2, 1, 1)
    
  }
  
  println(fibonacci(8))
  

  // Another easy example
  private def countdown(n: Int): Unit = {
    @tailrec
    def countdownHelper(current: Int): Unit = {
      if (current <= 0) println("Done!") // Base case: If the current number is 0 or less, stop.
      else {
        println(current) // Print the current number.
        countdownHelper(current - 1) // Recursive call: Continue with the next lower number.
      }
    }

    countdownHelper(n) // Start the countdown with the initial number `n`.
  }

  countdown(5)
  
}
