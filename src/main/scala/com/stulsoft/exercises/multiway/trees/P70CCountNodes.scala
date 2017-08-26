/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.multiway.trees

/** P70C (*) Count the nodes of a multiway tree.
  * <p>
  * Write a method nodeCount which counts the nodes of a given multiway tree.
  *
  * Example:
  * {{{
  *   MTree('a', List(MTree('f'))).nodeCount
  *   Int = 2
  * }}}
  *
  * @author Yuriy Stul
  */
object P70CCountNodes extends App {

  test(MTree('a', List(MTree('f'))))
  test(MTree('a', List(MTree('f'), MTree('g'))))
  test(MTree('a, List(MTree('f), MTree('ff, List(MTree('gg))))))

  def test[T](mTree: MTree[T]): Unit = {
    println(s"$mTree --> ${mTree.nodeCount}")
  }
}
