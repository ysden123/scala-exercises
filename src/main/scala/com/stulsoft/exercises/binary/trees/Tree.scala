package com.stulsoft.exercises.binary.trees

/**
  * @author Yuriy Stul.
  */
trait Tree[+T]

case object End extends Tree[Nothing] {
  override def toString: String = "."
}

case class Node[T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString: String = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"

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
