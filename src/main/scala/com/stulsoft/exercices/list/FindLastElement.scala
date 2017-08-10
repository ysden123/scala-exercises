package com.stulsoft.exercices.list

import scala.annotation.tailrec

/**
  * @author Yuriy Stul.
  */
object FindLastElement extends App {
  println("==>FindLastElement.main")
  test1(Seq(1, 2, 3))
  test1(Seq("abcd"))
  test1(Seq("abcd".toList))
  println("<==FindLastElement.main")

  def test1[T](collection: Seq[T]): Unit = {
    println(s"""Last element of [$collection] is ${getLastElement(collection)} """)
  }

  @tailrec
  def getLastElement[T](collection: Seq[T]): Option[T] = {
    if (collection == Nil)
      None
    else if (collection.length == 1)
      Some(collection.head)
    else
      getLastElement(collection.tail)
  }
}
