package lectures.part1basics

object CallByValueName extends App {

  private def calledByValue(x : Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  private def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  private def infinite(): Int = 1 + infinite()
  private def printFirst(x: Int, y: => Int): Unit = println(x)

  // results in error
  // printFirst(infinite(), 23)

  // works since infinite() is never called within function
  printFirst(23, infinite())

}
