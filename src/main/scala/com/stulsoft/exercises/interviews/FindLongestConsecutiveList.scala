/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.interviews

/** Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
  * {{{
  *   For example,
  *
  * Given [100, 4, 200, 1, 3, 2],
  * The longest consecutive elements sequence is [1, 2, 3, 4].
  * Return its length: 4.
  * }}}
  *
  * @author Yuriy Stul
  */
object FindLongestConsecutiveList extends App {

  test(List(100, 4, 200, 1, 3, 2))
  test(List(3, 2, 1, 9, 8, 7, 6, 10))
  test(List(1))
  test(List())

  def test(list: List[Int]): Unit = {
    println(s"(1) $list -> ${findLongestConsecutiveList1(list)}")
  }

  def findLongestConsecutiveList1(list: List[Int]): Int = {
    val sortedList = list.sorted
    var length = 0
    var currentLength = if (list.isEmpty) 0 else 1
    for (i <- 1 until sortedList.length) {
      if (sortedList(i) - sortedList(i - 1) == 1) {
        currentLength += 1
      } else {
        if (currentLength > length) {
          length = currentLength
        }
        currentLength = 1
      }
    }
    if (currentLength > length) {
      length = currentLength
    }
    length
  }
}
