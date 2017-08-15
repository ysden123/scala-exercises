/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercices.list

import scala.annotation.tailrec

/**
  * Eliminate consecutive duplicates of list elements.
  * <p>
  * If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
  *
  * Example:
  * {{{
  *   scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  *   res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
  * }}}
  *
  * @author Yuriy Stul
  */
object EliminateConsecutiveDuplicatedElements extends App {

  test(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  test(List('a, 'b))
  test(List(1, 2, 3, 3, 4, 5, 5, 6))
  test(List())

  def test[T](collection: List[T]): Unit = {
    println(s"(1) [$collection] => [${compress1(collection)}]")
    println(s"(2) [$collection] => [${compress2(collection)}]")
    println(s"(3) [$collection] => [${compress3(collection)}]")
  }

  /**
    * Standard recursive
    *
    * @param collection the collection
    * @tparam T collection elements type
    * @return cleared collection
    */
  def compress1[T](collection: List[T]): List[T] = collection match {
    case Nil => Nil
    case h :: t => h :: compress1(t.dropWhile(_ == h))
  }

  /**
    * Tail recursive
    *
    * @param collection the collection
    * @tparam T collection elements type
    * @return cleared collection
    */
  def compress2[T](collection: List[T]): List[T] = {
    @tailrec
    def compress(result: List[T], collection: List[T]): List[T] = collection match {
      case Nil => result.reverse
      case h :: t => compress(h :: result, t.dropWhile(_ == h))
    }

    compress(Nil, collection)
  }

  /**
    * With foldRight
    *
    * @param collection the collection
    * @tparam T collection elements type
    * @return cleared collection
    */
  def compress3[T](collection: List[T]): List[T] = {
    collection.foldRight(List[T]()) { (h, r) =>
      //      println(s"DEBUG h: [$h], r: [$r]")
      // Check whether element is duplicated
      if (r.isEmpty || r.head != h)
        h :: r // Add element
      else
        r // Skip duplicated element
    }
  }
}
