package lectures.part3fp

object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"
  val aTuple = (2, "hello, Scala") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) // ("hello, Scala", 2)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1)
  // a -> b is sugar for (a, b)
  println(phonebook)

  // map ops
  println(phonebook.contains("Jim"))

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  // functional on maps
  // map, flatMap, filter
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phonebook.view.filterKeys(x => x.startsWith("J")).toMap)
  // mapValues
  println(phonebook.view.mapValues(number => "0245-" + number).toMap)

  // conversions to other collections
  println(phonebook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  /*
        1. What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900?
        2. Overly simplified social network based on maps
        Person = String
        - add a person to the network
        - remove
        - friend (mutual)
        - unfriend

        - number of friends of a person
        - person with most friends
        - how many people have NO friends
        - if there is a social connection between two people (direct or not)
 */

}
