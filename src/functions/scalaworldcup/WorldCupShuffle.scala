package functions.scalaworldcup

import java.util.Scanner

import scala.collection.immutable.HashMap
import scala.util.Random

case class Team(name: String)

case class Player(name: String) {
  val plID = Player.inc
}

object Player {
  private var id = 0
  private def inc : Int = { id += 1; id }
}


 object TeamGenerator extends App {
   val playerCount: Int = choosePlayers
   val players: Vector[Player] = createPlayers

   var teams = Vector(Team("Brazil"), Team("England"), Team("Japan"), Team("South Korea"), Team("Italy"), Team("France"),
     Team("Spain"), Team("Uruguay"), Team("Germany"), Team("Switzerland"), Team("Holland")
     , Team("Australia"), Team("Chile"), Team("Greece"), Team("Ivory Coast"), Team("Ecuador"), Team("Colombia")
    , Team("Iran"), Team("Ghana"), Team("Nigeria"), Team("Mexico"), Team("Cameroon"), Team("Algeria"), Team("Belgium")
    , Team("Argentina"), Team("United States"), Team("Portugal"), Team("Russia"), Team("Croatia"), Team("Bosnia")
    , Team("Honduras"), Team("Costa Rica"))
   val bestDivisor: Int = Math.floor(teams.length/playerCount).toInt
   val remainder: Int = teams.length - (bestDivisor * playerCount)
   val shuffledTeams = Random shuffle teams
   println(shuffledTeams)
   println(assignTeams)

   def choosePlayers: Int = {
     val sc = new Scanner(System.in)
     println("Enter Number of Players")
     val choose: String = sc.nextLine()
     if ((choose filter ((ch: Char) => ch.isLetter)).isEmpty) {
        Integer.parseInt(choose)
     }
     else {
       println("Incorrect Input: Try Again.")
       choosePlayers
     }
   }

   def createPlayers: Vector[Player] = {
      var pl: Vector[Player] = Vector[Player]()
      for (i <- 1 to playerCount) {
        pl = pl :+ Player("Player " + i)
      }
     pl
   }

   def assignTeams: Map[Int, Vector[Team]] = {
     var pm: Map[Int, Vector[Team]] = new HashMap[Int, Vector[Team]]
     var count = 0
     for (pl <- players) {
        pm = pm ++ HashMap(pl.plID -> shuffledTeams.slice(count, count + bestDivisor))
        count += bestDivisor
     }
     assignRemainders(pm)
   }

   def assignRemainders(assigns: Map[Int, Vector[Team]]): Map[Int, Vector[Team]] = {
     var map = assigns
     var index = teams.length - remainder
     val rnd = new scala.util.Random
     val range = 1 to playerCount
     for (i <- 0 until remainder) {
       val num = range(rnd.nextInt(range length))
       var oldTeams = map(num)
       oldTeams = oldTeams :+ shuffledTeams(index)
       map = map + (num -> oldTeams)
       index += 1
     }
     map
   }
 }


