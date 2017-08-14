package com.stulsoft.exercices.list

/** Split a list into two parts.
  *
  * @author Yuriy Stul.
  */
object SplitListIntoTwoParts extends App {

  test(3, List(1, 2, 3, 4, 5, 6))
  test(4, List(1, 2, 3, 4, 5, 6))
  test(14, List(1, 2, 3, 4, 5, 6))

  /**
    * Test runner
    *
    * @param n  number of 1st part
    * @param ls list
    * @tparam T list elements type
    */
  def test[T](n: Int, ls: List[T]): Unit = {
    println(s"n=$n, $ls -> ${split(n, ls)}")
  }

  /**
    * Splits a list on two parts
    *
    * @param n  number of 1st part
    * @param ls list
    * @tparam T list elements type
    * @return list of two lists
    */
  def split[T](n: Int, ls: List[T]): List[List[T]] = {
    List(ls.take(n), ls.drop(n))
  }
}
