/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.list

/**
  * Create a list containing all integers within a given range
  * <p>
  * Example:
  * {{{range(4, 9)}}}
  * {{{List(4, 5, 6, 7, 8, 9)}}}
  *
  * @author Yuriy Stul.
  */
object P22CreateListContainingIntegersFromRange extends App {

  test(4, 9)

  /**
    * Test runner
    *
    * @param start first element
    * @param end   last element
    */
  def test(start: Int, end: Int): Unit = {
    println(s"(1) start=$start, end=$end, list: ${range1(start, end)}")
    println(s"(2) start=$start, end=$end, list: ${range2(start, end)}")
    println(s"(3) start=$start, end=$end, list: ${range3(start, end)}")
    println(s"(4) start=$start, end=$end, list: ${range4(start, end)}")
  }

  /**
    * Creates a list containing all integers within a given range
    *
    * @param start first element
    * @param end   last element
    * @return the list containing all integers within a given range
    */
  def range1(start: Int, end: Int): List[Int] = {
    (start to end).toList
  }

  /**
    * Creates a list containing all integers within a given range with collect
    *
    * @param start first element
    * @param end   last element
    * @return the list containing all integers within a given range
    */
  def range2(start: Int, end: Int): List[Int] = {
    val convert: PartialFunction[Int, Int] = {
      case x: Int => x
    }
    (start to end).collect(convert).toList
  }

  /**
    * Creates a list containing all integers within a given range with collect anonymous
    *
    * @param start first element
    * @param end   last element
    * @return the list containing all integers within a given range
    */
  def range3(start: Int, end: Int): List[Int] = {
    (start to end).collect({ case x: Int => x }).toList
  }

  /**
    * Creates a list containing all integers within a given range with recursion
    *
    * @param start first element
    * @param end   last element
    * @return the list containing all integers within a given range
    */
  def range4(start: Int, end: Int): List[Int] = {
    def range(currentIndex: Int, currentCount: Int, result: List[Int]): List[Int] = {
      if (currentCount == 0)
        result
      else
        range(currentIndex + 1, currentCount - 1, result :+ currentIndex)
    }

    range(start, end - start + 1, Nil)
  }
}
