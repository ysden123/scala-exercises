package com.stulsoft.exercices.list

import scala.annotation.tailrec
import scala.util.Random

/**
  * Extract a given number of randomly selected elements from a list.
  * <p>
  * Example:
  * {{{randomSelect(3, List('a, 'b, 'c, 'd, 'e 'f, 'g, 'h))}}}
  * {{{List('e, 'd, 'a)}}}
  *
  * @author Yuriy Stul.
  */
object P23ExtractGivenRandomElements extends App {
  test(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h))

  /**
    * Test runner
    *
    * @param n    number of elements
    * @param list list
    * @tparam T list items type
    */
  def test[T](n: Int, list: List[T]): Unit = {
    println(s"(1) n=$n, $list -> ${randomSelect1(n, list)}")
  }

  /**
    * Extracts a given number of randomly selected elements from a list.
    *
    * @param n    number of elements
    * @param list list
    * @tparam T list items type
    * @return extracted elements
    */
  def randomSelect1[T](n: Int, list: List[T]): List[T] = {
    @tailrec
    def randomSelect(currentN: Int, currentResult: List[T], currentList: List[T]): List[T] = currentN match {
      case 0 => currentResult
      case k =>
        val randomIndex = Random.nextInt(currentList.length)
        randomSelect(k - 1, currentResult :+ currentList(randomIndex), remove(randomIndex, currentList))
    }

    randomSelect(n, Nil, list)
  }

  /**
    * Removes n-th element
    *
    * @param n    element index
    * @param list list
    * @tparam T list items type
    * @return list without n-th element
    */
  def remove[T](n: Int, list: List[T]): List[T] = {
    val s = list.splitAt(n)
    s._1 ::: s._2.tail
  }
}
