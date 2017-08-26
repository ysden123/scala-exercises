/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.binary.trees

/** Collect the internal nodes of a binary tree in a list.
  *
  * {{{
  *   An internal node of a binary tree has either one or two non-empty successors.
  *   Write a method internalList to collect them in a list.
  *
  *   Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList
  *   List[Char] = List(a, c)
  * }}}
  *
  * @author Yuriy Stul
  */
object P62CollectInternalNodesList extends App {

  test(Node('a', Node('b'), End))
  test(Node('a', Node('b'), Node('c', Node('d'), Node('e'))))

  def test[T](node: Node[T]): Unit = {
    println(s"$node -> ${node.internalList}")
  }
}
