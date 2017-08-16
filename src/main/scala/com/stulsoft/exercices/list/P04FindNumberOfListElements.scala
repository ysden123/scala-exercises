/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercices.list

import scala.annotation.tailrec

/**
  * Finds length of collection
  *
  * @author Yuriy Stul
  */
object P04FindNumberOfListElements extends App {
  test(Seq(1, 2, 3))
  test(Seq())
  test("123".toList)

  /**
    * Test runner
    *
    * @param collection the collection
    * @tparam T collection elements type
    */
  def test[T](collection: Seq[T]): Unit = {
    println(s"(1) Length of collection [$collection] is ${findNumberOfListElements1(collection)}")
    println(s"(2) Length of collection [$collection] is ${findNumberOfListElements2(collection)}")
  }

  /**
    * Gets length using foldLeft
    *
    * @param collection the collection
    * @tparam T collection elements type
    * @return the collection length
    */
  def findNumberOfListElements1[T](collection: Seq[T]): Int = {
    collection.foldLeft(0) { (c, _) => c + 1 }
  }

  /**
    * Gets length using internal recursive function
    *
    * @param collection the collection
    * @tparam T collection elements type
    * @return the collection length
    */
  def findNumberOfListElements2[T](collection: Seq[T]): Int = {

    @tailrec
    def getLength(c: Int, collection: Seq[T]): Int = collection match {
      case Nil => c
      case _ => getLength(c + 1, collection.tail)
    }

    getLength(0, collection)

  }
}
