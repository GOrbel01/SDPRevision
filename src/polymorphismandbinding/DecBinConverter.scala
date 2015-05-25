package polymorphismandbinding

import java.util.Scanner

/**
 * Created by Cloud on 24/05/2015.
 */
object DecBinConverter {
  def main(args: Array[String]) = {
    val num: Double = getInput
    println(convertDec(num, ""))
  }

  def getInput: Double = {
    println("Enter Integer To Convert to Binary")
    val sc: Scanner = new Scanner(System.in)
    val num: Double = sc.nextDouble()
    num
  }

  def convertDec(dec: Double): String = {
    while (dec > 0) {

    }
  }
}
