/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercices.list

/**
  * Extract a slice from a list
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

  /**
    * Test runner
    *
    * @param from 1st element
    * @param to   last element
    * @param ls   list
    * @tparam T list elements type
    */
  def test[T](from: Int, to: Int, ls: List[T]): Unit = {
    println(s"(1) from $from, to $to: $ls --> ${extract1(from, to, ls)}")
    println(s"(2) from $from, to $to: $ls --> ${extract2(from, to, ls)}")
    println(s"(3) from $from, to $to: $ls --> ${extract3(from, to, ls)}")
  }

  /**
    * Extract with lice function
    *
    * @param from 1st element
    * @param to   last element
    * @param ls   list
    * @tparam T list elements type
    * @return the slice
    */
  def extract1[T](from: Int, to: Int, ls: List[T]): List[T] = {
    ls.slice(from, to)
  }

  /**
    * Extract recursive
    *
    * @param from 1st element
    * @param to   last element
    * @param ls   list
    * @tparam T list elements type
    * @return the slice
    */
  def extract2[T](from: Int, to: Int, ls: List[T]): List[T] = {
    ls.zipWithIndex
      .filter(t => t._2 >= from && t._2 <= to - 1)
      .map(t => t._1)
  }

  /**
    * Extract recursive with match pattern
    *
    * @param from 1st element
    * @param to   last element
    * @param ls   list
    * @tparam T list elements type
    * @return the slice
    */
  def extract3[T](from: Int, to: Int, ls: List[T]): List[T] = {
    def extract(result: List[T], from: Int, to: Int, next: List[T]): List[T] = (result, from, to, next) match {
      case (_, _, _, Nil) => result
      case (Nil, f, t, n) if f > 0 => extract(Nil, f - 1, t, n.tail)
      case (r, 0, t, n) if t > 0 => extract(r :+ n.head, 0, t - 1, n.tail)
      case (r, 0, 0, _) => r
    }

    extract(Nil, from, to - from, ls)
  }
}
