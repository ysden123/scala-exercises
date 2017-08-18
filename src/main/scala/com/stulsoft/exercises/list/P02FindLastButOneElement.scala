/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.list

import scala.annotation.tailrec

/**
  * Find the last but one element of a list.
  * <p>
  * Example:
  * {{{List(1, 1, 2, 3, 5, 8)}}}
  * {{{Int 5}}}
  *
  * @author Yuriy Stul
  */
object P02FindLastButOneElement extends App {

  test(List(1, 2, 3, 4))

  def test[T](list: List[T]): Unit = {
    println(s"(1) $list -> ${find1(list)}")
    println(s"(2) $list -> ${find2(list)}")
  }

  def find1[T](list: List[T]): Option[T] = {
    if (list.isEmpty || list.length < 2)
      None
    else {
      Some(list.reverse.take(2).tail.head)
    }
  }

  def find2[T](list: List[T]): Option[T] = {
    @tailrec
    def find(ls: List[T]): Option[T] = ls match {
      case _ :: t if t.length == 2 => Some(t.head)
      case l => find(l.tail)
    }

    if (list.isEmpty || list.length < 2)
      None
    else
      find(list)
  }
}
