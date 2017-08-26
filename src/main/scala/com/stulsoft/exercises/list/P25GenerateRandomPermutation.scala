/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.list

/**
  * Generate a random permutation of the elements of a list
  *
  * @author Yuriy Stul.
  */
object P25GenerateRandomPermutation extends App {

  test(List(1, 2, 3, 4, 5, 6))

  /**
    * Test runner
    *
    * @param ls the list
    * @tparam T list elements type
    */
  def test[T](ls: List[T]) {
    println(s"(1) $ls -> ${generate1(ls)}")
  }

  /**
    * Generate a random permutation of the elements of a list
    *
    * @param ls the list
    * @tparam T list elements type
    * @return result
    */
  def generate1[T](ls: List[T]): List[T] = {
    P23ExtractGivenRandomElements.randomSelect1(ls.length, ls)
  }
}
