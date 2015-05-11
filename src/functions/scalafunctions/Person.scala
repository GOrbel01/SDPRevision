package functions.scalafunctions

import scala.collection.immutable.Stream.Empty

case class Person(name: String, avaPersona: Vector[Persona]) {
  private var equippedPersona: Option[Persona] = None
  private var availablePersona: Vector[Persona] = avaPersona

  def this(nam: String) = {
   this(nam, Vector[Persona]())
  }

  def addPersona(persona: Persona): Unit = {
    availablePersona = availablePersona :+ persona
  }

  def removePersona(persona: Persona): Unit = {
    availablePersona = availablePersona.filter((mo) => mo != persona)
  }

  def equipPersona(nam: String): Unit = {
    val pers = availablePersona filter ((ps) => ps.name.equals(nam))
    if (pers.nonEmpty) {
      equippedPersona = Some(pers.head)
    }
    else {
      println("You have No Persona's Available!")
    }
  }

  override def toString: String = {
    val s: String = "Name: " + name + " Available Persona:" + availablePersona + " Equipped Persona: " + equippedPersona
    s
  }
}

object Person {
  def apply(n: String): Person = new Person(n)
}

object testPerson extends App {
  val prs1 = Person("Makoto")
  val pna4 = Persona("Norn", "Fortune", Vector("Garudyne", "Diarama"))
  println(prs1)
  prs1.addPersona(pna4)
  prs1.equipPersona("Norn")
  println(prs1)
}
