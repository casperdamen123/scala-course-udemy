package lectures.part3fp

object MapFlatmapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // print all combinations between two lists
  val number = List(1, 2, 3, 4)
  val chars = List("a", "b", "c", "d")
  val colors = List("black", "white")

  // iterates over the number list and for each number, iterates over the chars list and for each char, iterates over the colors list
  val combinations = number.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations)

  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
      n <- number if n % 2 == 0 // keep only even numbers
      c <- chars
      color <- colors
  } yield "" + c + n + "-" + color

  for {
    n <- number
  } println(n)

  // syntax overload
  list.map { x =>
    x * 2
  }

  /*
   1. MyList supports for comprehensions?
        - map(f: A => B) => MyList[B]
        - filter(p: A => Boolean) => MyList[A]
        - flatMap(f: A => MyList[B]) => MyList[B]
   2. A small collection of at most ONE element - Maybe[+T]
      - map, flatMap, filter
   */
  
}
