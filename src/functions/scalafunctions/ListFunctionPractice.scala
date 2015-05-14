package functions.scalafunctions

import scala.util.Random

/**
 * Created by Squall on 14/05/2015.
 */
object ListFunctionPractice extends App {
  var orig: Vector[String] = Vector("Cloud", "Tifa", "Barret", "Vincent", "Aeris", "Squall", "Rinoa", "Zell", "Quistis", "Selphie",
    "Zidane", "Garnet", "Steiner", "Freya", "Vivi", "Tidus", "Yuna", "Auron", "Rikku", "Wakka")
  var ffnames: Vector[String] = Random shuffle orig

println(ffnames.map((str: String) => 'B' + str.substring(1))) //Replace First Char of all with B
println(ffnames.map((str: String) => str.length()).sortWith((f: Int, b: Int) => f < b))
println(ffnames.sortBy((str) => str.length))
println(ffnames.map((str: String) => if (str.length > 5) str.substring(0, 5) else str))
}
