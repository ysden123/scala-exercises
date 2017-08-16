/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercices.list

/**
  * Duplicates each element of collection
  *
  * @author Yuriy Stul
  */
object P14DuplicateElements extends App {
  test(List('a, 'b, 'c))

  /**
    * Test runner
    *
    * @param collection the collection
    * @tparam T collection elements type
    */
  def test[T](collection: List[T]): Unit = {
    println(s"(1) $collection -> ${duplicate1(collection)}")
    println(s"(2) $collection -> ${duplicate2(collection)}")
  }

  /**
    * Duplicates each element of collection
    *
    * @param collection the colllection
    * @tparam T collection elements type
    * @return the collection with duplicated elements
    */
  def duplicate1[T](collection: List[T]): List[T] = {
    collection.flatMap(e => List(e, e))
  }

  /**
    * Duplicates each element of collection
    *
    * @param collection the colllection
    * @tparam T collection elements type
    * @return the collection with duplicated elements
    */
  def duplicate2[T](collection: List[T]): List[T] = {
    collection.flatMap(e => List.fill(2)(e))
  }
}
