package lectures.part2oop

class Generics extends App {

  // Generic class
  class MyList[+A] {
    // Use the type A
    def add[B >: A](element: B): MyList[B] = ???
    
    /* 
      A = Cat
      B = Dog = Animal
     */
  }

  // Instantiating the generic class
  // We can use the generic class with any type
  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION => we return a list of Animals

  // 2. NO = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage [A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  // won't work
  // class Car
  // val newCage = new Cage(new Car)
  
  // expend 
  
}
