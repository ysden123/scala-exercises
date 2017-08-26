/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.binary.trees

/** Count the leaves of a binary tree.
  *
  * @author Yuriy Stul
  */
object P61CountLeaves extends App {

  test(Node(1, Node(2), Node(3)))
  test(Node(1, Node(2)))

  def test(node: Node[Any]): Unit = {
    println(s"$node -> ${node.leafList}")
  }
}
