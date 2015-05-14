package functions.scalafunctions

/**
 * Created by Cloud on 12/05/2015.
 */
object ListPractice {
  val seq1: Seq[String] = Seq("Hello", "Goodbye", "Omg")
  var seq2: Seq[String] = Seq("Hello", "Goodbye", "Omg")
  val list1: List[String] = List("Hello", "Goodbye", "Omg")
  var list2: List[String] = List("Hello", "Goodbye", "Omg")
  val vect1: Vector[String] = Vector("Hello", "Goodbye", "Omg")
  var vect2: Vector[String] = Vector("Hello", "Goodbye", "Omg")

  "Doggie" +: seq1
  "Doggie" +: seq2

  "Doggie" +: list1
  val lb = list1 :+ "Doggie"
  "Doggie" +: list2
  "Doggie" +: vect1
  val vb = vect1 :+ "Doggie"
  "Doggie" +: vect2

  println(seq1)
  println(seq2)
  println(list1)
  println(lb)
  println(list2)
  println(vect1)
  println(vb)
  println(vect2)
  val vectt: Vector[Int] = Vector(1, 2, 3, 5)
  val vbt = vectt :+ 8
  println(vbt)
}
