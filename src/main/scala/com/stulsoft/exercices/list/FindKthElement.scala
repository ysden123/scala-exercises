/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercices.list

/**
  * @author Yuriy Stul
  */
object FindKthElement extends App {
  println("==>FindKthElement.main")
  test(Seq(0, 1, 2, 3), 2)
  test(Nil, 2)
  test(Seq(0, 1, 2, 3), 5)
  println("<==FindKthElement.main")

  def test[T](collection: Seq[T], k: Int): Unit = {
    println(s"$k-th element of the collection $collection is ${getKthElement(collection, k)}")
  }

  def getKthElement[T](collection: Seq[T], k: Int): Option[T] = {
    if (k >= collection.length)
      None
    else if (k == 0)
      Some(collection.head)
    else
      Some(collection.drop(k).head)
  }
}
