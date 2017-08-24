package com.stulsoft.exercises.binary.trees

/**
  * @author Yuriy Stul.
  */
trait Tree[+T] {
  def isSymmetric: Boolean

  def isMirrorOf[V](t: Tree[V]): Boolean
}

case object End extends Tree[Nothing] {
  override def toString: String = "."

  override def isSymmetric = true

  override def isMirrorOf[V](t: Tree[V]): Boolean = t == End.this
}

case class Node[T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString: String = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"


  override def isSymmetric: Boolean = left.isMirrorOf(right)


  override def isMirrorOf[V](tree: Tree[V]): Boolean = tree match {
    case t: Node[T] => left.isMirrorOf(t.right) && right.isMirrorOf(t.left)
    case _ => false
  }

  def addNodeToLeft(newNode: Node[T]): Node[T] = {
    Node(value, newNode, this.right)
  }

  def addNodeToRight(newNode: Node[T]): Node[T] = {
    Node(value, this.left, newNode)
  }
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}
