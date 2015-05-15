package functions.scalafunctions

import scala.util.Random

/**
 * Created by Squall on 14/05/2015.
 */
object ListFunctionPractice extends App {
  val orig: Vector[String] = Vector("Cloud", "Tifa", "Barret", "Vincent", "Aeris", "Squall", "Rinoa", "Zell", "Quistis", "Selphie",
    "Zidane", "Garnet", "Steiner", "Freya", "Vivi", "Tidus", "Yuna", "Auron", "Rikku", "Wakka")
  val ffnames: Vector[String] = Random shuffle orig

  val names: Vector[String] = Vector("June", "Jane", "James", "Iain", "Kate", "Beth", "George", "Jack", "Ben", "Bob", "Neil", "Simon")

  for (num <- Range(0, 5)) println(num)

  print("Map:");println(ffnames.map((str: String) => 'B' + str.substring(1))) //Replace First Char of all with B
  print("Map:");println(ffnames.map((str: String) => str.length()).sortWith((f: Int, b: Int) => f < b)) //Get all lengths and sort in ascending order
  print("Map:");println(ffnames.map((str: String) => if (str.length > 5) str.substring(0, 5) else str))
  print("FlatMap:");println(ffnames.flatMap((f) => f.toList)) //Same effect as statement below
  print("Map:");println(ffnames.map((f) => f.toList).flatten) //Turns all strings to a list of chars. flatten whole list into a vector of chars
  print("Sort:");println(ffnames.sortBy((str) => str.length))
  print("FilterNot:");println(ffnames filterNot((str) => str.length() > 4))
  print("Collect:");println(ffnames.collect { case "Cloud" => "Tifa" ; case "Vincent" => "Lucrecia" case any => "None" })
  print("Drop:");println(orig drop 5)
  print("DropWhile:");println(orig dropWhile((p) => p.length() > 5))
  print("Exists:");println(ffnames exists(p => p.equals("Cloud")))
  print("Find:");println(ffnames find(p => p.equals("Tidus"))) //Option with first matching element
  print("ForAll:");println(ffnames forall (p => p.length >= 4)) //Return true if all elements match a predicate
  print("ForAll:");println(ffnames forall (p => p.length > 5)) //False otherwise
  print("Partition:");println(ffnames partition(p => p.length() > 4))   //Seperate elements using predicate. In this case length of 4 or less
  print("PartitionGet:");println(ffnames partition(p => p.length() > 4)_2) //First consists of elements meeting predicate, second of all that do not
  print("Take:");println(ffnames take 4) //Takes first n (4 here) elements of collection (all if length less than n)
  print("TakeWhile");println(ffnames takeWhile (p => p.length < 6))

  val ab = names.reduceLeft((str1: String, str2: String) => str1 + str2.substring(0, 2))
  val bc = names.foldLeft("")((str1, str2) => str1 + str2.substring(0, 2))
  println("AB:" + ab)
  println("BC" + bc)
  val numList: Vector[Int] = Vector(1, 4, 5, 7, 9)
  print("REDUCE:");println((numList reduceRight)(_ + _))
  print("FOLD:");println((numList fold 1)(_ * _))
  print("FOLD2:");println((numList fold 1)((n1: Int, n2: Int) => n1 * n2))
  val b = (ffnames foldRight Vector.empty[String]) {  //Using Fold to perform an operation that would be done using map
    (x, list) => list :+ ("[" + x + "]")
  }
  print("FOLDRIGHT:" + b)
  //println(ffnames.foldLeft(_ + _))
//  println(ffnames.reduceLeft(_ + _))
}
