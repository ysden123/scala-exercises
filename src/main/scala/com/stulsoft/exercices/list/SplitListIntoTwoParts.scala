package com.stulsoft.exercices.list

import scala.annotation.tailrec

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
    println(s"(1) n=$n, $ls -> ${split1(n, ls)}")
    println(s"(2) n=$n, $ls -> ${split2(n, ls)}")
  }

  /**
    * Splits a list on two parts
    *
    * @param n  number of 1st part
    * @param ls list
    * @tparam T list elements type
    * @return Tuple of two lists
    */
  def split1[T](n: Int, ls: List[T]): (List[T],List[T]) = {
    (ls.take(n), ls.drop(n))
  }

  /**
    * Splits a list on two parts using recursive
    *
    * @param n  number of 1st part
    * @param ls list
    * @tparam T list elements type
    * @return list of two lists
    */
  def split2[T](n: Int, ls: List[T]): (List[T],List[T]) = {
    @tailrec
    def split(result: (List[T], List[T]), next: List[T]): (List[T], List[T]) = {
      if (next == Nil)
        result
      else if (result._1.length == n){
        (result._1, next)
      } else {
        split((result._1 :+ next.head, List()), next.tail)
      }
    }

    split((List[T](), List[T]()), ls)
  }
}
