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
   val players: List[Player] = createPlayers

   var teams = List(Team("Brazil"), Team("England"), Team("Japan"), Team("South Korea"), Team("Italy"), Team("France"),
     Team("Spain"), Team("Uruguay"), Team("Germany"), Team("Switzerland"), Team("Holland")
     , Team("Australia"), Team("Chile"), Team("Greece"), Team("Ivory Coast"), Team("Ecuador"), Team("Colombia")
    , Team("Iran"), Team("Ghana"), Team("Nigeria"), Team("Mexico"), Team("Cameroon"), Team("Algeria"), Team("Belgium")
    , Team("Argentina"), Team("United States"), Team("Portugal"), Team("Russia"), Team("Croatia"), Team("Bosnia")
    , Team("Honduras"), Team("Costa Rica"))
   val bestDivisor: Int = Math.floor(teams.length/playerCount).toInt
   val remainder: Int = teams.length - (bestDivisor * playerCount)
   val shuffledTeams = Random shuffle teams

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

   def createPlayers: List[Player] = {
      val pl: List[Player] = List[Player]()
      for (i <- 0 until playerCount) {
        pl :+ Player("Player " + i)
      }
     pl
   }

   def assignTeams: Map[Int, List[Team]] = {
     var pm: Map[Int, List[Team]] = new HashMap[Int, List[Team]]
     val count = 0
     for (pl <- players) {
        val map = Map(pl.plID -> shuffledTeams.take(bestDivisor))
       println(map)
     }
     pm
   }

//   def printMap(map: Map[Int, List[Team]]) = {
//      for ((mp) <- map.size) {
//        print(mp)
//      }
//   }

   println(bestDivisor)
 }


