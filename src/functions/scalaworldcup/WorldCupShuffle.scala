package functions.scalaworldcup

case class Team(name: String)

case class Player(name: String)

class WorldCupShuffle {

}

object teamGenerator extends App {
  val teams = List(Team("Brazil"), Team("England"), Team("Japan"), Team("South Korea"), Team("Italy"), Team("France"),
    Team("Spain"), Team("Uruguay"), Team("Germany"), Team("Switzerland"), Team("Holland")
  , Team("Denmark"), Team("Chile"), Team("Greece"), Team("Ivory Coast"))

  println(teams)

}
