package miscprogram

import scala.annotation.tailrec

trait BTree[+A] {
  def value: Option[A] = this match {
    case n: Node[A] => Some(n.v)
    case l: Leaf[A] => Some(l.v)
    case Empty => None
  }

  def left: Option[BTree[A]] = this match {
    case n: Node[A] => Some(n.l)
    case l: Leaf[A] => None
    case Empty => None
  }

  def right: Option[BTree[A]] = this match {
    case n: Node[A] => Some(n.r)
    case l: Leaf[A] => None
    case Empty => None
  }

  private case class Eval[A](v: A) extends BTree[A]

  @tailrec
  private def foldLoop[A, B](a: List[BTree[A]], z: B)(f: (B, A) => B)(o: (Node[A], List[BTree[A]]) => List[BTree[A]]): B = a match {
    case (n: Node[A]) :: t1 => foldLoop(o(n, t1), z)(f)(o) // never directly evaluate nodes, function o will create new accumulator
    case (l: Leaf[A]) :: tz => foldLoop(tz, f(z, l.v))(f)(o) //evaluate leaf
    case (e: Eval[A]) :: ty => foldLoop(ty, f(z, e.v))(f)(o) //evaluate eval
    case Empty :: te => foldLoop(te, z)(f)(o) //ignore empty
    case _ => z //will always be null/empty list
  }

  def foldPreorder[B](z: B)(f: (B, A) => B): B = {
    foldLoop(List(this), z)(f) { (n, tl) => Eval(n.v) :: n.l :: n.r :: tl }
  }

  /**
   * fold with inorder traversal (left, root, right)
   * tail recursive optimized
   *
   *        F
   *      /   \
   *    B       G
   *   / \       \
   *  A   D       I
   *     / \     /
   *    C   E   H
   *
   * head evaluate accumulator
   * ---- -------- -----------
   *              | (F)
   * F   | ()     | B::F::G::()
   * B   | ()     | A::B::D::(F,G)
   * A   | (A)    | (B,D,F,G)
   * B   | (B)    | (D,F,G)
   * D   | ()     | C::D::E::(F,G)
   * C   | (C)    | (D,E,F,G)
   * D   | (D)    | (E,F,G)
   * E   | (E)    | (F,G)
   * F   | (F)    | (G)
   * G   | ()     | G::I::()
   * G   | (G)    | (I)
   * I   | ()     | H::I::()
   * H   | (H)    | H
   * I   | (I)    | ()
   *
   * result
   * A,B,C,D,E,F,G,H,I
   */
  def foldInorder[B](z: B)(f: (B, A) => B): B = {
    foldLoop(List(this), z)(f) { (n, tl) => n.l :: Eval(n.v) :: n.r :: tl }
  }

  /**
   * fold with postorder traversal (left, right, root)
   * tail recursive optimized
   *
   *        F
   *      /   \
   *    B       G
   *   / \       \
   *  A   D       I
   *     / \     /
   *    C   E   H
   *
   * head evaluate accumulator
   * ---- -------- -----------
   *              | (F)
   * F   | ()     | B::G::F::()
   * B   | ()     | A::D::(B,G,F)
   * A   | (A)    | (D,B,G,F)
   * D   | ()     | C::E::D::(B,G,F)
   * C   | (C)    | (E,D,B,G,F)
   * E   | (E)    | (D,B,G,F)
   * D   | (D)    | (B,G,F)
   * B   | (B)    | (G,F)
   * G   | ()     | I::G::(F)
   * I   | ()     | H::I::(G,F)
   * H   | (H)    | (I,G,F)
   * I   | (I)    | (G,F)
   * G   | (G)    | (F)
   * F   | (F)    | ()
   *
   * result
   * A,C,E,D,B,H,I,G,F
   */
  def foldPostorder[B](z: B)(f: (B, A) => B): B = {
    foldLoop(List(this), z)(f) { (n, tl) => n.l :: n.r :: Eval(n.v) :: tl }
  }

  /**
   * fold with levelorder traversal
   * tail recursive optimized
   *
   *        F
   *      /   \
   *    B       G
   *   / \       \
   *  A   D       I
   *     / \     /
   *    C   E   H
   *
   * head evaluate accumulator
   * ---- -------- -----------
   *              | (F)
   * F   | ()     | (F::()) ::: (B,G)
   * F   | (F)    | (B,G)
   * B   | ()     | (B::(G)) ::: (A,D)
   * B   | (B)    | (G,A,D)
   * G   | ()     | (G::(A,D)) ::: (I)
   * G   | (G)    | (A,D,I)
   * A   | (A)    | (D,I)
   * D   | ()     | (D::(I)) ::: (C,E)
   * D   | (D)    | (I,C,E)
   * I   | ()     | (I::(C,E)) ::: (H)
   * I   | (I)    | (C,E,H)
   * C   | (C)    | (E,H)
   * E   | (E)    | (H)
   * H   | (H)    | ()
   *
   * result
   * F, B, G, A, D, I, C, E, H
   */

  def foldLevelorder[B](z: B)(f: (B, A) => B): B = {
    foldLoop(List(this), z)(f) { (n, tl) => (Eval(n.v) :: tl) ::: List(n.l, n.r) }
  }

  /**
   * calls foldInorder
   */
  def fold[B](z: B)(f: (B, A) => B): B = foldInorder(z)(f)

  /**
   * P02
   * (*) Count the number of nodes in a binary tree.
   */
  def size: Int = fold(0) { (sum, v) => sum + 1 }

  /**
   * P03
   * (*) Determine the height of a binary tree.
   * Definition:  The height of a tree is the length of the path from the root to the deepest node in the tree. A (rooted) tree with only one node (the root) has a height of zero.
   */
  def height: Int = {
    def loop(t: BTree[A]): Int = t match {
      case l: Leaf[A] => 1
      case n: Node[A] => Seq(loop(n.left.get), loop(n.right.get)).max + 1
      case _          => 0
    }
    loop(this) - 1
  }

  /**
   * P04
   * (*) Count the number of leaves in a binary tree.
   */
  def leafCount: Int = {
    @tailrec
    def loop(t: List[BTree[A]], z: Int): Int = t match {
      case (l: Leaf[A]) :: tl => loop(tl, z + 1)
      case (n: Node[A]) :: tl => loop(n.left.get :: n.right.get :: tl, z)
      case _ :: tl            => loop(tl, z)
      case _                  => z
    }
    loop(List(this), 0)
  }

  def toSeq: Seq[A] = fold(List[A]()) { (l, v) => v :: l } reverse

  def toSeqPreorder: Seq[A] = foldPreorder(List[A]()) { (l, v) => v :: l } reverse
  def toSeqInorder: Seq[A] = foldInorder(List[A]()) { (l, v) => v :: l } reverse
  def toSeqPostorder: Seq[A] = foldPostorder(List[A]()) { (l, v) => v :: l } reverse
  def toSeqLevelorder: Seq[A] = foldLevelorder(List[A]()) { (l, v) => v :: l } reverse

  /**
   * P05
   * (**) Find the last element in a binary tree using pre/in/post/level order traversals.
   *  Note:  This is S-99 problem P01 converted from lists to binary trees.
   */
  def lastPreorder = toSeqPreorder.last
  def lastInorder = toSeqInorder.last
  def lastPostorder = toSeqPostorder.last
  def lastLevelorder = toSeqLevelorder.last

  /**
   * P06
   * (**) Find the last but one element in a binary tree using pre/in/post/level order traversals.
   *  Note:  This is S-99 problem P02 converted from lists to binary trees.
   */
  def penultimatePreorder = toSeqPreorder.dropRight(1).last
  def penultimateInorder = toSeqInorder.dropRight(1).last
  def penultimatePostorder = toSeqPostorder.dropRight(1).last
  def penultimateLevelorder = toSeqLevelorder.dropRight(1).last

  /**
   * P07
   * (**) Find the Nth element in a binary tree using pre/in/post/level order traversals.
   * By convention, the first element in the tree is element 0.
   *
   */
  def nthPreorder(n: Int) = toSeqPreorder(n)
  def nthInorder(n: Int) = toSeqInorder(n)
  def nthPostorder(n: Int) = toSeqPostorder(n)
  def nthLevelorder(n: Int) = toSeqLevelorder(n)

}

case class Node[A](v: A, l: BTree[A], r: BTree[A]) extends BTree[A]
case class Leaf[A](v: A) extends BTree[A]
case object Empty extends BTree[Nothing]

object Run extends App {
  val t: BTree[Symbol] = Node('F, Node('B, Leaf('A), Node('D, Leaf('C), Leaf('E))), Node('G, Empty, Node('I, Leaf('H), Empty)))
  println("tree: " + t)

  //print the value of b node navigating from root
  for {
    b <- t.left
    value <- b.value
  } println("B node: " + value)

  //print the value of e node navigating from root
  for {
    b <- t.left
    d <- b.right
    value <- d.value
  } println("D node: " + value)

  //no println() is executed for empty node chain
  for {
    b <- t.left
    d <- b.right
    e <- d.right
    x <- e.right
    value <- x.value
  } println("X node SHOUL NOT PRINT!: " + value)

  println("as seq: " + t.toSeq)

  println("count: " + t.size)
  assert(t.size == 9)

  println("height: " + t.height)
  assert(t.height == 3)

  println("leaft count: " + t.leafCount)
  assert(t.leafCount == 4)

  println("as seqPreorder: " + t.toSeqPreorder)
  println("as seqInorder: " + t.toSeqInorder)
  println("as seqPostorder: " + t.toSeqPostorder)
  println("as seqLevelorder: " + t.toSeqLevelorder)

  println("last preorder :" + t.lastPreorder)
  println("last inorder :" + t.lastInorder)
  println("last postorder :" + t.lastPostorder)
  println("last levelorder: " + t.lastLevelorder)

  println("nth preorder 5 : " + t.nthPreorder(5))
  println("nth inorder 5 : " + t.nthInorder(5))
  println("nth postorder 5 : " + t.nthPostorder(5))
  println("nth levelorder 5 : " + t.nthLevelorder(5))

  //
  /**
   * **** output *********
   *
   * tree: Node('F,Node('B,Leaf('A),Node('D,Leaf('C),Leaf('E))),Node('G,Empty,Node('I,Leaf('H),Empty)))
   * B node: 'B
   * D node: 'D
   * as seq: List('A, 'B, 'C, 'D, 'E, 'F, 'G, 'H, 'I)
   * count: 9
   * height: 3
   * leaft count: 4
   * as seqPreorder: List('F, 'B, 'A, 'D, 'C, 'E, 'G, 'I, 'H)
   * as seqInorder: List('A, 'B, 'C, 'D, 'E, 'F, 'G, 'H, 'I)
   * as seqPostorder: List('A, 'C, 'E, 'D, 'B, 'H, 'I, 'G, 'F)
   * as seqLevelorder: List('F, 'B, 'G, 'A, 'D, 'I, 'C, 'E, 'H)
   * last preorder :'H
   * last inorder :'I
   * last postorder :'F
   * last levelorder: List('F, 'B, 'G, 'A, 'D, 'I, 'C, 'E, 'H)
   * nth preorder 5 : 'C
   * nth inorder 5 : 'E
   * nth postorder 5 : 'B
   * nth levelorder 5 : 'D
   *
   * ***********************
   */

}

