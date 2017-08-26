/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.list

/**
  * Defines a k-th element of a collection
  *
  * @author Yuriy Stul
  */
object P03FindKthElement extends App {
  println("==>FindKthElement.main")
  test(Seq(0, 1, 2, 3), 0)
  test(Seq(0, 1, 2, 3), 2)
  test(Nil, 2)
  test(Seq(0, 1, 2, 3), 5)
  println("<==FindKthElement.main")

  def test[T](collection: Seq[T], k: Int): Unit = {
    println(s"$k-th element of the collection $collection is ${getKthElement(collection, k)}")
  }

  /**
    * Returns a k-th element of a collection
    *
    * @param collection the collection
    * @param k          element number
    * @tparam T specifies the collection elements type
    * @return the k-th element of the collection
    */
  def getKthElement[T](collection: Seq[T], k: Int): Option[T] = (collection, k) match {
    case (col, n) if n >= col.length => None
    case (col, n) if n == 0 => Some(col.head)
    case (col, n) => Some(col.drop(n).head)
  }
}
