package functions.scalafunctions

/**
 * Created by Cloud on 08/05/2015.
 */
object FunctionPractice extends App {
  val testList1 = List("Name", "Gone", "Word", "Sound", "Height")
//  val testMap1 = Map(
//    "England" -> "London",
//    "France" -> "Paris",
//    "Japan" -> "Tokyo",
//    "Germany" -> "Berlin")
  val testMap1: scala.collection.immutable.Map[String,String] =
    Map("England" -> "London", "France" -> "Paris", "Japan" -> "Tokyo", "Germany" -> "Berlin")

  testList1 foreach { l => println("String: " + l) }
  testMap1 foreach { case (k, v) => println(k + ": " + v)}

  val mList = testList1.map((str) => str.length())

  val list = List("now", "is", "", "the", "time")
  var newList = list.flatMap((s) => s.toList)
  println(newList)

  println(mList)
}


