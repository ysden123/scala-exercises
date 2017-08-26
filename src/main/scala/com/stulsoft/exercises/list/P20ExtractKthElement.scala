/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.list

import scala.annotation.tailrec

/**
  * Remove the Kth element from a list
  * <p>
  * Example:
  * {{{removeAt(1, List('a, 'b, 'c, 'd))}}}
  * {{{(List[Symbol], Symbol) = (List('a, 'c, 'd),'b)}}}
  *
  * @author Yuriy Stul.
  */
object P20ExtractKthElement extends App {

  test(List(0, 1, 2, 3, 4, 5), 3)

  /**
    * Test runner
    *
    * @param list the list
    * @param k    k-th element to extract
    * @tparam T list elements type
    */
  def test[T](list: List[T], k: Int): Unit = {
    println(s"(1) k=$k, $list -> ${extract1(list, k)}")
    println(s"(2) k=$k, $list -> ${extract2(list, k)}")
  }

  /**
    * Extract k-th element
    *
    * @param list the list
    * @param k    k-th element to extract
    * @tparam T list elements type
    * @return tuple with list and k-th element
    */
  def extract1[T](list: List[T], k: Int): Option[(List[T], T)] = {
    if (list.isEmpty || k >= list.length)
      None
    else {
      val splitted = list.splitAt(k)
      Some((splitted._1 ::: splitted._2.tail, splitted._2.head))
    }
  }

  /**
    * Extract k-th element with recursion
    *
    * @param list the list
    * @param k    k-th element to extract
    * @tparam T list elements type
    * @return tuple with list and k-th element
    */
  def extract2[T](list: List[T], k: Int): Option[(List[T], T)] = {
    @tailrec
    def extract(currentK: Int, prefix: List[T], rest: List[T]): Option[(List[T], T)] = (currentK, rest) match {
      case (_, Nil) => None
      case (0, head :: tail) => Some((prefix ::: tail, head))
      case (curK, head :: tail) => extract(curK - 1, prefix :+ head, tail)
    }

    if (list.isEmpty || k >= list.length)
      None
    else
      extract(k, Nil, list)
  }
}
