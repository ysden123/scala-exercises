/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercices.list

/** Extract a slice from a list
  * <p>
  * Given two indices, I and K, the slice is the list containing the elements from and including the Ith element
  * up to but not including the Kth element of the original list. Start counting the elements with 0.
  * <p>
  * Example:
  * {{{slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))}}}
  * result:
  * {{{List[Symbol] = List('d, 'e, 'f, 'g)}}}
  *
  * @author Yuriy Stul
  */
object ExtractSlice extends App {

  test(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

  def test[T](from: Int, to: Int, ls: List[T]): Unit = {
    println(s"(1) from $from, to $to: $ls --> ${extract1(from, to, ls)}")
  }

  def extract1[T](from: Int, to: Int, ls: List[T]): List[T] = {
    ls.slice(from, to)
  }
}
