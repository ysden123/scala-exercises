package com.stulsoft.exercises.binary.trees

/**
  * @author Yuriy Stul.
  */
sealed trait Tree[+T] {
  def isSymmetric: Boolean

  def isMirrorOf[V](t: Tree[V]): Boolean

  def leafCount: Int

  def leafList: List[Tree[T]]

  def leafList2: List[T]

  def internalList: List[T]

  def atLevel(l: Int): List[T]
}

case object End extends Tree[Nothing] {
  override def toString: String = "."

  override def isSymmetric = true

  override def isMirrorOf[V](t: Tree[V]): Boolean = t == End.this

  override def leafCount = 0

  override def leafList: List[Tree[Nothing]] = Nil

  override def leafList2: List[Nothing] = Nil

  override def internalList: List[Nothing] = Nil

  override def atLevel(l: Int): List[Nothing] = Nil
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

  override def leafCount: Int = (left, right) match {
    case (End, End) => 1
    case _ => left.leafCount + right.leafCount
  }

  override def leafList: List[Tree[T]] = (left, right) match {
    case (End, End) => List(this)
    case _ => left.leafList ::: right.leafList
  }

  override def leafList2: List[T] = (left, right) match {
    case (End, End) =>
      List(value)
    case _ =>
      left.leafList2 ::: right.leafList2
  }

  override def internalList: List[T] = (left, right) match {
    case (End, End) => Nil
    case _ => value :: left.internalList ::: right.internalList
  }

  override def atLevel(l: Int): List[T] = l match {
    case n if n < 1 => Nil
    case 1 => List(value)
    case n => left.atLevel(n - 1) ::: right.atLevel(n - 1)
  }
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}
