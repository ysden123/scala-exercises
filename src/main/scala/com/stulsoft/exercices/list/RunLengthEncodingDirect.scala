/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercices.list

/**
  * Run-length encoding of a list
  * <p>
  * Implement the so-called run-length encoding data compression method directly.
  * Converts
  * {{{List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)}}}
  * into
  * {{{List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))}}}
  *
  * @author Yuriy Stul
  */
object RunLengthEncodingDirect extends App {

  test(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))

  /**
    * Test runner
    *
    * @param collection the collection
    * @tparam T collection elements type
    */
  def test[T](collection: List[T]): Unit = {
    println(s"(1) $collection -> ${encode1(collection)}")
    println(s"(2) $collection -> ${encode2(collection)}")
  }

  /**
    * Run-length encoder
    *
    * @param collection the collection
    * @tparam T collection elements type
    * @return run-length encoded collection
    */
  def encode1[T](collection: List[T]): List[(Int, T)] = {
    if (collection == Nil)
      Nil
    else {
      val (packed, next) = collection span (_ == collection.head)
      (packed.length, packed.head) :: encode1(next)
    }
  }

  /**
    * Run-length encoder
    *
    * @param collection the collection
    * @tparam T collection elements type
    * @return run-length encoded collection
    */
  def encode2[T](collection: List[T]): List[(Int, T)] = collection match {
    case Nil => Nil
    case _ =>
      val (packed, next) = collection span (_ == collection.head)
      (packed.length, packed.head) :: encode1(next)
  }
}
