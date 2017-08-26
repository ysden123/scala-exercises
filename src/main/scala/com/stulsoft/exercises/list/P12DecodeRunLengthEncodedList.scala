/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.list

/**
  * Given a run-length code list generated as specified in problem [[P09PackConsecutiveDuplicates]], construct its uncompressed version.
  *
  * @author Yuriy Stul.
  */
object P12DecodeRunLengthEncodedList extends App {

  test(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))

  /**
    * Test runner
    *
    * @param collection the collection
    * @tparam T collection elements type
    */
  def test[T](collection: List[T]): Unit = {
    println(s"$collection -> ${P10RunLengthEncoding.runLengthEncode1(collection)} -> ${decode(P10RunLengthEncoding.runLengthEncode1(collection))}")
  }

  /**
    * Converts encoded collection List[(Int, T)] to decoded collection List[T]
    *
    * @param collection the collection
    * @tparam T collection elements type
    * @return the decoded collection
    */
  def decode[T](collection: List[(Int, T)]): List[T] = {
    collection.flatMap(t => List.fill(t._1)(t._2))
  }
}
