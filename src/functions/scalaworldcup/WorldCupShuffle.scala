package functions.scalaworldcup

import collection.mutable._

case class Team(name: String)

case class Player(name: String)



object teamGenerator extends App {
  val teams = List(Team("Brazil"), Team("England"), Team("Japan"), Team("South Korea"), Team("Italy"), Team("France"),
    Team("Spain"), Team("Uruguay"), Team("Germany"), Team("Switzerland"), Team("Holland")
  , Team("Denmark"), Team("Chile"), Team("Greece"), Team("Ivory Coast"))

  println(teams)

  def shuffle(teams: List[Team], players: List[Player]) : HashMap[Player, List[Team]] = {
    
    val players.map((p) => )
  }
}
