package com.stulsoft.exercises.binary.trees

/** Construct completely balanced binary trees.
  * Example:
  * {{{
  *   cBalanced(3, "x")
  *
  *       N
  *       /\
  *      / \
  *     N   N
  *    /\  /\
  *   / \  /\
  *  N  N N  N
  *  .........
  * }}}
  *
  * @author Yuriy Stul.
  */
object P55ConstructCompletelyBalancedTrees extends App {

  test(1, "x")
  test(2, "x")
  test(3, "x")

  def test[T](n: Int, x: T): Unit = {
    println(s"n=$n --> ${cBalanced(n, x)}")
  }

  def cBalanced[T](n: Int, value: T): Node[T] = {
    if (n == 1)
      Node(value, End, End)
    else
      Node(value, cBalanced(n - 1, value), cBalanced(n - 1, value))
  }
}
