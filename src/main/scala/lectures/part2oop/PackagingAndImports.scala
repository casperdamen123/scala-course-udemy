package lectures.part2oop

import playground.{Cinderella, PrinceCharming}

import java.sql.Date
import java.util.{Date => UtilDate}


object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // import the package
  val princess = new Cinderella // playground.Cinderella = fully qualified name

  // packages are in hierarchy
  // matching folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  // 1. use FQ names
//  val date = new Date
//  val sqlDate = new java.sql.Date(2018, 5, 4)
  
  //  2. use aliasing
  val utilDate = new UtilDate

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???    
  
}
