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
}
