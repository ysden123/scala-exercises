/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.multiway.trees

/** Multiway Trees
  *
  * @see [[http://aperiodic.net/phil/scala/s-99/ Multiway Trees]]
  * @author Yuriy Stul
  */
case class MTree[+T](value: T, children: List[MTree[T]]) {
  def this(value: T) = this(value, List())

  override def toString: String = "M(" + value.toString + " {" + children.map(_.toString).mkString(",") + "})"

  def nodeCount: Int = {
    children match {
      case Nil => 1
      case x => x.map { c => c.nodeCount }.foldLeft(1) { (a, n) => a + n }
    }
  }
}

object MTree {
  def apply[T](value: T) = new MTree(value, List())

  def apply[T](value: T, children: List[MTree[T]]) = new MTree(value, children)
}
