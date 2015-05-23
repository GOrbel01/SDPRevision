package functions.scalafunctions

import scala.collection.immutable.Stream.cons
import scala.collection.immutable.{HashSet, SortedMap}

object MapAndSetFunctionPractice extends App {
  val testSet: HashSet[String] = HashSet("Jenna", "Jessica", "Daniel", "Robert"
  , "Jason", "Iain", "Emily", "Rachel", "Ross", "Eric", "Charlotte")
  val testMap: scala.collection.immutable.SortedMap[Int, String] = SortedMap(
    1 -> "Cloud", 2 -> "Tifa", 3 -> "Squall", 4 -> "Rinoa", 5 -> "Zidane", 6 -> "Garnet",
    7 -> "Tidus", 8 -> "Yuna")
  val tmb: SortedMap[Int, String] = testMap.+(9 -> "Auron") //MAP Add = + //Types Sorted, Tree, Normal
  val tms: Set[String] = testSet + "Dylan"
  testMap + (0 -> "Garnet")
  val range = 1 until 40
  println(range.toVector)
  println(tmb)
  println(tms)

  /*
    FUNCTIONS
   */
  println(testMap mapValues((str) => str.substring(0, 4)))

  class A
  class B extends A
  class C
  class D extends C

//  val x1: Int => D = (b: A) => new D

  def iterate[T](x: T)(f: T => T): Stream[T] = {
    cons (x, iterate(f(x))(f))
  }
}
