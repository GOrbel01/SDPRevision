/**
 * Created by Squall on 09/05/2015.
 */
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello World!")
  }

  def take3(v: Vector[Int]): Vector[Int] = v match {
    case Vector(a, b, c, _*) =>
      println("No Problem")
      Vector(a, b, c)
    case Vector(c, z) =>
      println("Found two. Adding 99 To End to take 3")
      v :+ 99
    case _ =>
      println("I cant take 3. Returning Input")
      v
  }

  def printType(x: Any) = x match {
    case d: Double => println(s"$d is a Double")
    case i: Int => println(s"$i is an Integer")
    case s: String => println(s"$s is a String")
    case other => println(s"$other... What the Hell was that?")
  }

  printType(2.3)
  printType(1)
  printType("Hello")
  printType('f')

  println(take3(Vector(11, 22)))

  //Option In Search
  val names = List("Cloud", "Tidus", "Squall", "Zidane", "Garnet", "Rinoa", "Yuna")
  val names2 = List("Iain", "John", "Squall", "Benjamin", "James", "Jake", "Lucy")

  val testMap1: scala.collection.immutable.Map[String,String] =
    Map("England" -> "London", "France" -> "Paris", "Japan" -> "Tokyo", "Germany" -> "Berlin")

  def find(name: String, namestr: List[String] = names): Option[Int] = {
    var result: Option[Int] = None
    for (i <- 0 until namestr.length if result == None) {
      println(i)
      if (name == namestr(i)) result = Some(i)
    }
    result
  }

  def mapFind(city: String, cityCapitals: Map[String, String]): Option[String] = {
    var result: Option[String] = None
    val iter: Iterator[String] = cityCapitals.valuesIterator
    for (elem <- iter if result == None) {
      if (city == elem) {
        result = Some(elem)
      }
    }
    result
  }

  println(find("Squall"))
  println(find("Lucy"))

  //Pattern Match Find
  find("Benjamin", names2) match {
    case Some(a) => println(s"Found at $a")
    case None => println("Nothing Found")
  }

  println(mapFind("London", testMap1))

}
