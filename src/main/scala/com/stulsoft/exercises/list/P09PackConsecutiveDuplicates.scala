/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.list

/**
  * Pack consecutive duplicates of list elements into sub-lists
  *
  * If a list contains repeated elements they should be placed in separate sub-lists.
  * <p>
  * Example:
  * {{{
  *  pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  *  List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  * }}}
  *
  * @author Yuriy Stul
  */
object P09PackConsecutiveDuplicates extends App {

  test(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))

  /**
    * Test runner
    *
    * @param collection the collection
    * @tparam T the collection elements type
    */
  def test[T](collection: List[T]): Unit = {
    println(s"(1) [$collection] => [${pack1(collection)}]")
    println(s"(2) [$collection] => [${pack2(collection)}]")
  }

  /**
    * Standard recursive using span
    *
    * @param collection the collection
    * @tparam T the collection elements type
    * @return list of packed duplicated elements
    */
  def pack1[T](collection: List[T]): List[List[T]] = {
    if (collection.isEmpty)
      List(List())
    else {
      val (packed, next) = collection span {
        _ == collection.head
      }
      if (next == Nil)
        List(packed)
      else
        packed :: pack1(next)
    }
  }

  /**
    * Standard recursive using span and match pattern
    *
    * @param collection the collection
    * @tparam T the collection elements type
    * @return list of packed duplicated elements
    */
  def pack2[T](collection: List[T]): List[List[T]] = collection match {
    case Nil => List(List())
    case _ =>
      val (packed, next) = collection span (_ == collection.head)
      next match {
        case Nil => List(packed)
        case _ => packed :: pack2(next)
      }
  }
}
