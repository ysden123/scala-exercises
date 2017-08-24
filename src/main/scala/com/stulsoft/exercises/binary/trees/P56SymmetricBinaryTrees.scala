package com.stulsoft.exercises.binary.trees

/** Symmetric binary trees.
  * {{{
  * Let us call a binary tree symmetric if you can draw a vertical line through
  * the root node and then the right subtree is the mirror image of
  * the left subtree. Add an isSymmetric method to the Tree class to check whether
  * a given binary tree is symmetric. Hint: Write an isMirrorOf method first
  * to check whether one tree is the mirror image of another. We are only
  * interested in the structure, not in the contents of the nodes.
  *
  * Node('a', Node('b'), Node('c')).isSymmetric
  * res0: Boolean = true
  * }}}
  *
  * @author Yuriy Stul.
  */
object P56SymmetricBinaryTrees extends App {

  test(Node('x'))
  test(Node('x', Node('y')))
  test(Node('x', Node('y'), Node('y')))
  test(Node('x', Node('y'), End))

  def test[T](node: Node[T]): Unit = {
    println(s"$node is symmetric: ${node.isSymmetric}")
  }
}
