/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.binary.trees

/**
  * @author Yuriy Stul
  */
object P61ACollectLeavesInList extends App {
  test(Node(1, Node(2), Node(3)))
  test(Node(1, Node(2)))
  test(Node('a', Node('b'), Node('c', Node('d'), Node('e'))))

  def test[T](node: Node[T]): Unit = {
    println(s"$node -> ${node.leafList}")
  }

}
