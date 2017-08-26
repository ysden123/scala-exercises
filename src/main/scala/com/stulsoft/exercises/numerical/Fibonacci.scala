/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.numerical

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/** Fibonacci number generator
  *
  * @author Yuriy Stul
  */
object Fibonacci extends App {
  test(2)
  test(3)
  test(4)
  test(5)
  test(6)

  /** Test runner
    */
  def test(n: Int): Unit = {
    var numbers = fibonacci1(n)
    println(s"(1) n = $n -> ${numbers.length} numbers: $numbers")
    numbers = fibonacci2(n)
    println(s"(2) n = $n -> ${numbers.length} numbers: $numbers")

    println(s"(one 1)  $n -> ${fibonacciOne1(n)}")
  }

  /** Generates Fibonacci's number with tail recursion
    *
    * @param n amount of numbers
    * @return list of Fibonacci's numbers
    */
  def fibonacci1(n: Int): List[Int] = {
    @tailrec
    def fibonacci(fn_2: Int, fn_1: Int, currentN: Int, numbers: List[Int]): List[Int] = {
      if (currentN >= n) {
        numbers
      } else {
        val newN = fn_2 + fn_1
        fibonacci(fn_1, newN, currentN + 1, numbers :+ newN)
      }
    }

    fibonacci(0, 1, 2, List(0, 1))
  }

  /** Generates Fibonacci's number with for loop
    *
    * @param n amount of numbers
    * @return list of Fibonacci's numbers
    */
  def fibonacci2(n: Int): List[Int] = {
    val list = ListBuffer.empty[Int]
    list += 0
    list += 1
    var n_2 = 0
    var n_1 = 1
    for (_ <- 2 until n) {
      val newN = n_2 + n_1
      list += newN
      n_2 = n_1
      n_1 = newN
    }
    list.toList
  }

  /** Calculates F(n)
    *
    * @param n the n
    * @return F(n)
    */
  def fibonacciOne1(n: Int): Int = {
    @tailrec
    def fibonacciOne(v_n_2: Int, v_n_1: Int, currentN: Int): Int = {
      if (currentN >= n)
        v_n_1
      else {
        val newVal = v_n_2 + v_n_1
        fibonacciOne(v_n_1, newVal, currentN + 1)
      }
    }

    fibonacciOne(0, 1, 2)
  }
}
