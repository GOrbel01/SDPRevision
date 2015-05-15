package miscprogram

/**
 * Created by Squall on 15/05/2015.
 */
trait Addable[A] {
  def plus(x: A, y: A): A
}

class AddableOps[A](lhs: A)(implicit ev: Addable[A]) {
  def +(rhs: A): A = ev.plus(lhs, rhs)
}

object testObj {
//  def main (args: Array[String]) {
//    add(2, 5)
//  }
//  def add[A: Addable](xa: A, ya: A): A = xa + ya
}
