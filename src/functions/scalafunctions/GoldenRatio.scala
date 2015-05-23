package functions.scalafunctions

import miscprogram.Empty

/**
 * Created by Squall on 17/05/2015.
 */

object GoldenRatio extends App {
  import scala.math._

  def estimateB(a: Double, bMin: Double, bMax: Double, err: Double): Double = {
    val b = (bMax + bMin)/2
    val estimate: Double = abs((a + b)/a) - (a/b)
    if (estimate < err) {
      b
    }
    else {
      if ((a + b)/a > a/b) {
        estimateB(a, b, bMax, err)
      }
      else {
        estimateB(a, bMin, b, err)
      }
    }
  }

  val a = 10
  val b = estimateB(a, 0, a, 0.000000001)
  println("Estimate for B is: " + (a/b))

//  println(lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), ('d, 'e),
//    List('i, 'j, 'k, 'l), List('m, 'n), List('o))))

  def lsort(list: List[List[Symbol]]): List[List[Symbol]] = {
    val sortedList = list.sortBy((f) => f.length)
    sortedList
  }
}