/**
 * Created by Squall on 09/05/2015.
 */
object HelloWorld {
  def main(args: Array[String]): Unit = {

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

  //Basic For
  for (i <- 2 to 5) {
    println(i + " squared is: " + i * i)
  }
  for (i <- "SUPER") {
    print(i + "-")
  }
  println()
  var sum = 0; for(i <- 1 to 100) sum = sum + i
  println(sum)

  //Range
  for (i <- Range(1, 5)) { print(i) } //1, 2, 3, 4
  println()

  //For With Filter (Condition)
  for (i <- 1 to 8 if i != 5) print(i + " ")
  println()
  //For With Multi Filter (Multi Conditions)
  for (i <- 1 to 8 if i != 4
        && i % 2 == 0) print(i + " ")
  println()
  //Multi Generators
  for (i <- -1 to 3; j <- 1 to 200 by 50) { print(i + ": " + j + " "); if (j + 50 >= 200) println()}
  //Value (Variables) in For
  for (i <- 1 to 10; j = 4) print(i * j + " ")
  //Sequence Comprehension (for comprehension)
  println()
  print(for (i <- 1 to 10) yield i * i)
  println()
  //Long for/seq comprehension method
  def rot13(message: String) = {
    for (c <- message) yield {
      if (c.isLetter) {
        val cRotated = (c + 13).toChar
        if (cRotated.isLetter) { cRotated } else { (c - 13).toChar }
      }
      else {
        c
      }
    }
  }
  val sentence = "Scala is a great programming language"
  println(rot13(rot13(sentence)))
  //Infinite final parameter. Applies to Classes and Methods
  def numbers(num: Int*) = for (c <- num) println(c)
  numbers(1, 5, 6, 10)
  //Named Params. Note - Param order does not matter
  def nParam(str: String, num: Int) = println(num + ": " + str)
  nParam(num = 2, str = "Very Good")

  val mTest: Map[Int, String] = Map(
    1 -> "Cloud",
    2 -> "Squall",
    3 -> "Selphie"
  )
  println(mTest)
}
