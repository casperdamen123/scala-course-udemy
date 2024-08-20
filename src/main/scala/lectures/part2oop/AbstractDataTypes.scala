package lectures.part2oop

import javax.xml.crypto.Data

object AbstractDataTypes extends App {
  
  // abstract
  abstract class Animal {
    val creatureType: String = "wild"
    def eat(): Unit
  }
  
  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat(): Unit = println("crunch crunch")
  }
  
  // trait
  trait Carnivor {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }
  
  trait ColdBlooded
  
  
  class Crocodile extends Animal with Carnivor with ColdBlooded {
    override val creatureType: String = "croc"
    def eat(): Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a crocodile and I'm eating ${animal.creatureType}")
  }
  
  val dog = new Dog 
  val croc = new Crocodile
  croc.eat(dog)  
  
  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = behavior, abstract class = "thing"
  
  
}
