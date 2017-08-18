/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.list

import scala.annotation.tailrec

/**
  * Rotate a list N places to the left
  * <p>
  * Examples:
  * {{{rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))}}}
  * {{{List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)}}}
  *
  * {{{rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))}}}
  * {{{List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)}}}
  *
  * @author Yuriy Stul.
  */
object P19RotateListNPlacesLeft extends App {
  test(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  test(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  test(9, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

  /**
    * Test runner
    *
    * @param n    where to rotate
    * @param list the list
    * @tparam T list items type
    */
  def test[T](n: Int, list: List[T]): Unit = {
    println(s"(1) $list with n=$n -> ${rotate1(n, list)}")
  }

  /**
    * Rotates
    *
    * @param n    where to rotate
    * @param list the list
    * @tparam T list items type
    * @return rotated list
    */
  def rotate1[T](n: Int, list: List[T]): List[T] = {

    /**
      * Rotates recursively
      *
      * @param skip   how to skip from the beginning
      * @param suffix elements from the beginning, will be added at the end
      * @param rest   the rest of the source list
      * @return rotated list
      */
    @tailrec
    def rotate(skip: Int, suffix: List[T], rest: List[T]): List[T] = (skip, rest) match {
      case (_, Nil) => rest ::: suffix
      case (0, _) => rest ::: suffix
      case (_, _) => rotate(skip - 1, suffix :+ rest.head, rest.tail)
    }

    if (n > 0)
      rotate(n, Nil, list)
    else
      rotate(list.length + n, Nil, list)
  }
}
