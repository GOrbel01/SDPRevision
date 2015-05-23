package implicits

/**
 * Created by Squall on 16/05/2015.
 */
object ImplicitTest extends App {
  implicit val f: Double = 0.8
  calcTax(12.0)
  def calcTax(amount: Double)(implicit rate: Double): Unit = {
    println(amount * rate)
  }
}
