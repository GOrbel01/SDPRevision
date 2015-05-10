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
  //SCALA HIGHER ORDER FUNCTIONS
  /*
    MAP
   */
  println("boogie" map ((ch: Char) => "aeiou" contains ch))
  println("boogie" map ((ch: Char) => ch == 'o'))
  println("boogie" map ((ch: Char) => if (ch == 'o') 'a' else ch))
  /*
    FILTER
   */
  println(List(3, 1, 4, 6, 7, 10, 12, 14, 20) filter ((x: Int) => x > 6))
  println(List("Game", "Geep", "Janitor", "Jam", "Jumper", "Sun", "gone")
    filter ((s: String) => s.charAt(0) == 'G' || s.charAt(0) == 'g'))
  case class Companion(name: String, age: Int)
  val comps = List(Companion("Nord", 2), Companion("Imperial", 24), Companion("Falmer", 40), Companion("Orc", 44),
  Companion("Forsworn", 20), Companion("Ningheim", 27), Companion("Dremora", 52))
  println(comps filter ((c: Companion) => c.age < 40))
  println(comps filter ((c: Companion) => c.age < 40)
    sortWith((c: Companion, b: Companion) => c.age > b.age))
  println(List(1, 5, 6) filter ((i: Int) => i == 3))
  /*
    REDUCE
   */
  val foods: List[String] = List("Cake", "Cookie", "Pizza", "Milk", "Pepper", "Bread", "Bacon", "Egg", "Cheese")
  println(foods reduce((a: String, b: String) => a.substring(0, 1) + b.substring(0, 1)))
  println(foods map ((str: String) => str.substring(0, 1)) reduce ((a, b) => a + b))
}


