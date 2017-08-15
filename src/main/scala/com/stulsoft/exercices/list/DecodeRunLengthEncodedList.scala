package com.stulsoft.exercices.list

/**
  * Given a run-length code list generated as specified in problem [[PackConsecutiveDuplicates]], construct its uncompressed version.
  *
  * @author Yuriy Stul.
  */
object DecodeRunLengthEncodedList extends App {

  test(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))

  /**
    * Test runner
    *
    * @param collection the collection
    * @tparam T collection elements type
    */
  def test[T](collection: List[T]): Unit = {
    println(s"$collection -> ${RunLengthEncoding.runLengthEncode1(collection)} -> ${decode(RunLengthEncoding.runLengthEncode1(collection))}")
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
