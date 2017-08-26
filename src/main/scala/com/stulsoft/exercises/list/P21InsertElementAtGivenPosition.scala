/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.list

import scala.annotation.tailrec

/**
  * Insert an element at a given position into a list.
  * <p>
  * Example
  * {{{insertAt('new, 1, List('a, 'b, 'c, 'd))}}}
  * {{{List('a, 'new, 'b, 'c, 'd)}}}
  *
  * @author Yuriy Stul
  */
object P21InsertElementAtGivenPosition extends App {

  test(1, List('a, 'b, 'c, 'd), 'new)

  /**
    * Test runner
    *
    * @param position position
    * @param list     list
    * @param element  element
    * @tparam T list elements type
    */
  def test[T](position: Int, list: List[T], element: T): Unit = {
    println(s"(1) position=$position, e: $element, $list -> ${insert1(position, list, element)} ")
    println(s"(2) position=$position, e: $element, $list -> ${insert1(position, list, element)} ")
  }

  /**
    * Inserts element
    *
    * @param position position
    * @param list     list
    * @param element  element
    * @tparam T list elements type
    * @return result list
    */
  def insert1[T](position: Int, list: List[T], element: T): List[T] = {
    val s = list splitAt position
    (s._1 :+ element) ::: s._2
  }

  /**
    * Inserts element with recursion
    *
    * @param position position
    * @param list     list
    * @param element  element
    * @tparam T list elements type
    * @return result list
    */
  def insert2[T](position: Int, list: List[T], element: T): List[T] = {
    @tailrec
    def insert(curPos: Int, left: List[T], rest: List[T]): List[T] = (curPos, rest) match {
      case (_, Nil) => left :+ element
      case (0, ls) => (left :+ element) ::: ls
      case (n, h :: t) => insert(n - 1, left :+ h, t)
    }

    insert(position, Nil, list)
  }
}
