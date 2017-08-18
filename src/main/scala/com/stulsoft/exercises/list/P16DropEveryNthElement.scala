/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.list

import scala.annotation.tailrec

/**
  * Drops N-th element
  *
  * @author Yuriy Stul
  */
object P16DropEveryNthElement extends App {

  test(3, List(1, 2, 3, 4, 5, 6, 7))

  /**
    * Test runner
    *
    * @param n          N-th element to drop
    * @param collection the collection
    * @tparam T collection elements type
    */
  def test[T](n: Int, collection: List[T]): Unit = {
    println(s"(1) n = $n, $collection -> ${drop1(n, collection)}")
    println(s"(2) n = $n, $collection -> ${drop2(n, collection)}")
    println(s"(3) n = $n, $collection -> ${drop3(n, collection)}")
  }

  /**
    * Drop with counter
    *
    * @param n          N-th element to drop
    * @param collection the collection
    * @tparam T collection elements type
    * @return collection with dropped n-th elements
    */
  def drop1[T](n: Int, collection: List[T]): List[T] = {
    var counter = 0
    collection.filter(_ => {
      counter += 1
      if (counter == n) {
        counter = 0
        false
      }
      else
        true
    })
  }

  /**
    * Drop with tail recursive
    *
    * @param n          N-th element to drop
    * @param collection the collection
    * @tparam T collection elements type
    * @return collection with dropped n-th elements
    */
  def drop2[T](n: Int, collection: List[T]): List[T] = {
    @tailrec
    def getFirst(previous: List[T], next: List[T]): List[T] = {
      if (next.isEmpty)
        previous
      else
        getFirst(previous ++ next.take(n - 1), next.drop(n))
    }

    getFirst(Nil, collection)
  }

  /**
    * Drop with zipWithIndex
    *
    * @param n          N-th element to drop
    * @param collection the collection
    * @tparam T collection elements type
    * @return collection with dropped n-th elements
    */
  def drop3[T](n: Int, collection: List[T]): List[T] = {
    collection.zipWithIndex.filter(i => (i._2 + 1) % n != 0).map(i => i._1)
  }
}
