/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.binary.trees

/** Collect the nodes at a given level in a list.
  *
  * {{{
  *   A node of a binary tree is at level N if the path from the root to the node has length N-1.
  *   The root node is at level 1. Write a method atLevel to collect all nodes at a given level in a list.
  *
  *   Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2)
  *   List[Char] = List(b, c)
  * }}}
  *
  * @author Yuriy Stul
  */
object P62BCollectNodesLevelLlist extends App {

  test(2, Node('a', Node('b'), Node('c', Node('d'), Node('e'))))
  test(3, Node('a', Node('b'), Node('c', Node('d'), Node('e'))))
  test(3, Node('a, Node('b, Node('d), Node('e)), Node('c, Node('g), Node('h))))

  def test[T](l: Int, node: Node[T]) {
    println(s"l=$l, $node --> ${node.atLevel(l)}")
  }
}
