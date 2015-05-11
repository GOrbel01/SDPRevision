package functions.scalafunctions

/**
 * Created by Cloud on 10/05/2015.
 */

sealed trait Summonable {
  def summon: Unit
}

case class Persona(name: String, arcana: String, var moves: Vector[String]) extends Summonable {
  def this(n: String) = {
    this(n, "Unknown", Vector[String]())
  }

  def this(n: String, a: String) = {
    this(n, a, Vector[String]())
  }

  def addMove(move: String): Unit = {
    moves = moves :+ move
  }

  def removeMove(move: String): Unit = {
    moves = moves.filter((mo) => mo != move)
  }

  def testPrint = {
    for ((mov) <- this.moves) println(mov)
  }

  def summon: Unit = {
    ???
  }

  override def toString: String = { "Name: " + name + ", Arcana: " + arcana + ", Move-List: " + moves.toString() }
}

object Persona {
//  def apply(n: String, p: String, m: Vector[String]) = { new Persona(n, p, m) }
  def apply(n: String, p: String): Persona = { new Persona(n, p) }
  def apply(n: String): Persona = new Persona(n)
}

object testPersona extends App {
  val p1 = Persona("Jack Frost", "Magicican")
  val p2 = Persona("Isis", "Empress")
  val p3 = Persona("Odin")
  val p4 = Persona("Norn", "Fortune", Vector("Garudyne", "Diarama"))

  p3 addMove "Ziodyne"
  p4 removeMove "Garudyne"
  p4 removeMove "Diarama"
  p4 addMove "Garudyne"

  println(p1)
  println(p2)
  println(p3)
  println(p4)

  p2.arcana match {
    case "Empress" => println("Empress Arcana")
    case "Unknown" => println("Unknown Arcana")
    case "Fortune" => println("Fortune Arcana")
    case arc => println("No Idea what Arcana")
  }
}
