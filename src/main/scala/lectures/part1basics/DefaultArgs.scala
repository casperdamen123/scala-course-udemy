package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  private def trFact(n : Int, acc: Int = 1): Int =
    if (n == 1) acc
    else trFact(n - 1, n * acc)

  val fact10 = trFact(10, 2)

  println(trFact(4, 1))

  def savePicture(format: String = "jpeg", width: Int, height: Int): Unit = println("Saving picture")

  savePicture("jpeg", 3, 3)
}


