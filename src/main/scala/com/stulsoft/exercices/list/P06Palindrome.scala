/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercices.list

/**
  * Checks whether list is palindrome
  *
  * @author Yuriy Stul
  */
object P06Palindrome extends App {
  println("==>Palindrome.main")
  test(List(1, 2, 3))
  test(List(1, 2, 2, 1))
  test(List(1, 2, 2))
  test(List())
  test(List(1))
  println("<==Palindrome.main")

  /**
    * Test runner
    *
    * @param list list to check
    * @tparam T list elements type
    */
  def test[T](list: List[T]): Unit = {
    println(s"List [$list] is palindrome: ${whetherPalindrome(list)}")
  }

  /**
    * Checks whether a list is palindrome
    *
    * @param list list to check
    * @tparam T list elements type
    * @return true, if list is palindrome; otherwise - false
    */
  def whetherPalindrome[T](list: List[T]): Boolean = list == list.reverse
}
