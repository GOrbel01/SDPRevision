package functions.scalafunctions

import scala.annotation.tailrec

/**
 * Created by Cloud on 23/05/2015.
 */
object MergeSort extends App {
  def merge[T](as: List[T], bs: List[T])(cmp: (T, T) => Boolean): List[T] = {
    (as, bs) match {
      case (Nil, _) => bs
      case (_, Nil) => as
      case (x :: xs, y :: ys) =>
        if (cmp(x, y)) x :: merge(xs, bs)(cmp)
        else y :: merge(as, ys)(cmp)
    }
  }

  def merge2[T](as: List[T], bs: List[T])(cmp: (T, T) => Boolean): List[T] = {
    @tailrec
    def loop(tmpAS: List[T], tmpBS: List[T], tmpRes: List[T]): List[T] = {
      (tmpAS, tmpBS) match {
        case (Nil, _) => println("TR1: " + tmpRes); println("TB: " + tmpBS); tmpRes.reverse ++ tmpBS
        case (_, Nil) => println("TR2: " + tmpRes); println("TB: " + tmpAS); tmpRes.reverse ++ tmpAS
        case (x :: xs, y :: ys) =>
          if (cmp(x, y)) loop(xs, tmpBS, x :: tmpRes)
          else loop(tmpAS, ys, y :: tmpRes)
      }
    }
    loop(as, bs, Nil)
  }

  println(merge(List(1, 2, 5, 7, 9), List(3, 6, 9, 11, 14))((x, y) => x >= y))
  println(merge(List(1, 4, 7, 10, 11), List(2, 3, 5, 7, 12, 16))((x, y) => x <= y))
  println(merge2(List(1, 4, 7, 10, 11), List(2, 3, 5, 7, 12, 16))((x, y) => x <= y))

}
