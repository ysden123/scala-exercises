/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercices.list

import scala.collection.immutable.VectorBuilder

/** Reverses a list
  *
  * @author Yuriy Stul
  */
object ReverseList extends App {
  println("==>ReverseList.main")
  test(List(1, 2, 3, 4))
  println("<==ReverseList.main")

  /**
    * Test runner
    *
    * @param list the list to reverse
    * @tparam T type of list elements
    */
  def test[T](list: List[T]): Unit = {
    println(s"Reverese of [$list] id [${reverseList(list)}]")
  }

  /**
    * Reverses a list
    *
    * @param list the list
    * @tparam T type of list elements
    * @return the reversed list
    */
  def reverseList[T](list: List[T]): List[T] = {
    val result = new VectorBuilder[T]
    for (i <- list.indices)
      result += list(list.length - 1 - i)
    result.result.toList
  }
}
