package miscprogram

import java.io.File
import scala.io._

/**
 * Created by Squall on 12/05/2015.
 */

object Battle extends App {
  var player: Person = PlayerSetup.setupPlayer()
  player.getAvailablePersona.head.name match {
    case "Isis" => println("You Win. With the Thunder of Isis")
    case "Jack Frost" => println("You Win with the Freezing Cold of Jack Frost")
    case other => println("Somehow you are here")
  }
}

object PlayerSetup {
  private var personaList: Vector[Persona] = FileManager.readFile(new File("PersonaList.txt"))
  private var personList: Vector[Person] = FileManager.readFile(new File("Person.txt"))

  private var player: Person = _

  def setupPlayer(): Person = {
    setupChar()
    setupPersona()
    player
  }

  def setupChar(): Unit = {
    var sel: String = ""
    var done = false
    while (!done) {
      println("Selectable Characters:")
      personList.foreach((per) => println(per))
      if (personList.nonEmpty) {
        println("Create or Select? (Type Cre or Sel)")
        val m: String = StdIn.readLine()
        m match {
          case "Sel" | "sel" => sel = personSelect(); println(s"Selected $sel"); done = true
          case "Cre" | "cre" => personCreate()
          case other => println("Invalid Input")
        }
      }
      else {
        println("Person List Empty, Create a Person.")
        personCreate()
      }
    }
    player = personList.filter((pers) => pers.name == sel).head
  }

  def setupPersona() {
    var done = false
    while (!done) {
      println("Selectable Persona:")
      personaList.foreach((pna) => println(pna))
      var sel: String = ""
      if (player.getAvailablePersona.isEmpty) {
        println("You Must have at least one Persona Available")
        println("Choose a Persona to Add by entering the name from the List: ")
        sel = StdIn.readLine()
        personaAdd(sel)
      }
      else {
        println("Add Persona or Finish (Add, Fin)")
        val selType = StdIn.readLine()
        selType match {
          case "Add" | "add" => sel = StdIn.readLine(); personaAdd(sel)
          case "Fin" | "fin" => done = true
          case wrong => println("Invalid Input")
        }
      }
    }
  }

  def personSelect(): String = {
      println("Select from the list of characters")
      StdIn.readLine()
  }

  def personCreate(): Unit = {
    println("Enter a Name for your Character")
    val name = StdIn.readLine()
    println(s"Creating a New Character named: $name")
    personList = personList :+ Person(name)
  }

  def personaAdd(sel: String): Unit = {
    println(s"Attempting to Equip Persona named $sel")
    if (personaList.exists((pers: Persona) => pers.name.equals(sel))) {
      println(s"Equipping Persona $sel" )
      player.addPersona(personaList.filter((pers) => pers.name.equals(sel)).head)
      println(player)
    }
    else {
      println("Persona not found")
    }
  }

  def personaCreate(): Unit = {

  }

}
