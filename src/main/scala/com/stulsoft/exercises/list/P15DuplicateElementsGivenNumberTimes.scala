/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.list

/**
  * Duplicate the elements of a list a given number of times
  * <p>
  * Example:
  * {{{(3, List('a, 'b, 'c, 'c, 'd))}}}
  * {{{List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)}}}
  *
  * @author Yuriy Stul
  */
object P15DuplicateElementsGivenNumberTimes extends App {

  test(3, List('a, 'b, 'c, 'c, 'd))

  /**
    * Test runner
    *
    * @param n    number of times
    * @param list the list
    * @tparam T list items type
    */
  def test[T](n: Int, list: List[T]): Unit = {
    println(s"(1) n=$n, $list -> ${duplicate1(n, list)}")
  }

  /**
    * Duplicates elements
    *
    * @param n    number of times
    * @param list the list
    * @tparam T list items type
    * @return list with duplicates
    */
  def duplicate1[T](n: Int, list: List[T]): List[T] = {
    list.flatMap(i => List.fill(n)(i))
  }
}
