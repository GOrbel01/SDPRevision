package miscprogram

sealed trait Person {
  val name: String
  val avaPersona: Vector[Persona]

  def getAvailablePersona: Vector[Persona]

  def hasAvailablePersona: Boolean

  def addPersona(persona: Persona): Unit

  def removePersona(persona: Persona): Unit

  def equipPersona(name: String): Unit
}

case class PersonImpl(name: String, avaPersona: Vector[Persona]) extends Person {
  private var equippedPersona: Option[Persona] = None
  private var availablePersona: Vector[Persona] = avaPersona

  def getAvailablePersona: Vector[Persona] = availablePersona

  def this(nam: String) = {
   this(nam, Vector[Persona]())
  }

  def hasAvailablePersona: Boolean = availablePersona.nonEmpty

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
  def apply(n: String): Person = new PersonImpl(n)
  def copy(n: String, a: Vector[Persona]) = new PersonImpl(n, a)
}

object testPerson extends App {
  val prs1 = Person("Makoto")
  val pna4 = Persona("Norn", "Fortune", Vector("Garudyne", "Diarama"))
  println(prs1)
  prs1.addPersona(pna4)
  prs1.equipPersona("Norn")
  println(prs1)
}
