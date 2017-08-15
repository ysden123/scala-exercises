package com.stulsoft.exercices.list

/**
  * Finds the last element of a collection
  *
  * @author Yuriy Stul.
  */
object FindLastElement extends App {
  println("==>FindLastElement.main")
  test1(Seq(1, 2, 3))
  test1("abcd".toList)
  test1(Nil)
  println("<==FindLastElement.main")

  /**
    * Test runner
    *
    * @param collection collection to handle
    * @tparam T specifies the type of collection elements
    */
  def test1[T](collection: Seq[T]): Unit = {
    println(s"""Last element of [$collection] is ${getLastElement(collection)} """)
  }

  /**
    * Returns a last element of a collection
    *
    * @param collection collection
    * @tparam T specifies the type of collection elements
    * @return the last element of a collection
    */
  def getLastElement[T](collection: Seq[T]): Option[T] = collection match {
    case col if col == Nil => None
    case col if col.length == 1 => Some(col.head)
    case _ => Some(collection.drop(collection.length - 1).head)
  }
}
