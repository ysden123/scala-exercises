/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercices.list

import scala.collection.immutable.VectorBuilder

/**
  * Reverses a list
  *
  * @author Yuriy Stul
  */
object ReverseList extends App {
  println("==>ReverseList.main")
  test(List(1, 2, 3, 4))
  test(List())
  test(List("a"))
  println("<==ReverseList.main")

  /**
    * Test runner
    *
    * @param list the list to reverse
    * @tparam T type of list elements
    */
  def test[T](list: List[T]): Unit = {
    println(s"(1) Reverse of [$list] id [${reverseList1(list)}]")
    println(s"(2) Reverse of [$list] id [${reverseList2(list)}]")
    println(s"(3) Reverse of [$list] id [${reverseList3(list)}]")
  }

  /**
    * Reverses a list
    *
    * @param list the list
    * @tparam T type of list elements
    * @return the reversed list
    */
  def reverseList1[T](list: List[T]): List[T] = {
    val result = new VectorBuilder[T]
    for (i <- list.indices)
      result += list(list.length - 1 - i)
    result.result.toList
  }

  /**
    * Reverses a list using recursion
    *
    * @param list the list
    * @tparam T type of list elements
    * @return the reversed list
    */
  def reverseList2[T](list: List[T]): List[T] = {
    def reverseList(result: List[T], currentList: List[T]): List[T] = currentList match {
      case Nil => result
      case h :: tail => reverseList(h :: result, tail)
    }

    reverseList(Nil, list)
  }

  /**
    * Reverses a list using foldLeft
    *
    * @param list the list
    * @tparam T type of list elements
    * @return the reversed list
    */
  def reverseList3[T](list: List[T]): List[T] = {
    list.foldLeft(List[T]()) { (result, head) => head :: result }
  }
}
