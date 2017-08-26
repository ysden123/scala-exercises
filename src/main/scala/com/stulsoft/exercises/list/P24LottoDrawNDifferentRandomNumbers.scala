/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.list

import scala.util.Random

/**
  * Lotto: Draw N different random numbers from the set 1..M.
  * <p>
  * Example:
  * {{{lotto(6, 49)}}}
  * {{{List(23, 1, 17, 33, 21, 37)}}}
  *
  * @author Yuriy Stul.
  */
object P24LottoDrawNDifferentRandomNumbers extends App {

  test(6, 49)

  /**
    * Test runer
    *
    * @param number number of elements
    * @param from   max value of number
    */
  def test(number: Int, from: Int): Unit = {
    println(s"(1) number=$number, from=$from -> ${lotto(number, from)}")
  }

  /**
    * Draw N different random numbers from the set 1..M.
    *
    * @param number number of elements
    * @param from   max value of number
    * @return generated elements
    */
  def lotto(number: Int, from: Int): List[Int] = {
    def draw(currentNumber: Int, currentResult: List[Int], list: List[Int]): List[Int] = currentNumber match {
      case 0 => currentResult
      case _ =>
        val index = Random.nextInt(list.length)
        draw(currentNumber - 1, currentResult :+ list(index), remove(index, list))
    }

    draw(number, Nil, (1 to from).toList)
  }

  /**
    * Removes n-th element
    *
    * @param n    element index
    * @param list list
    * @return list without n-th element
    */
  def remove(n: Int, list: List[Int]): List[Int] = {
    val s = list.splitAt(n)
    s._1 ::: s._2.tail
  }
}
