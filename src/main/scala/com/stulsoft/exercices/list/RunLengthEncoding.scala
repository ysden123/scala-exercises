package com.stulsoft.exercices.list

/**
  * Run-length encoding of a list
  *
  * <p>
  * Use the result of problem packConsecutiveDuplicates to implement
  * the so-called run-length encoding data compression method.
  * Consecutive duplicates of elements are encoded as tuples (N, E)
  * where N is the number of duplicates of the element E.
  *
  * @author Yuriy Stul.
  */
object RunLengthEncoding extends App {

  test(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))

  /**
    * Test runner
    *
    * @param collection the collection
    * @tparam T collection elements type
    */
  def test[T](collection: List[T]): Unit = {
    println(s"(1) [$collection] => [${runLengthEncode1(collection)}]")
  }

  /**
    * Builds list of Tuples with length of duplicates for each collection element
    *
    * @param collection the collection
    * @tparam T collection elements type
    * @return the list of Tuples with length of duplicates for each collection element
    */
  def runLengthEncode1[T](collection: List[T]): List[(Int, T)] = {
    PackConsecutiveDuplicates.pack1(collection).map(element => (element.length, element.head))
  }
}
