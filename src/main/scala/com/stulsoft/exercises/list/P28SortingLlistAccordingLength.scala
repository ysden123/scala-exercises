package com.stulsoft.exercises.list

/** Sorting a list of lists according to length of sublists.
  * <p>
  * Example:
  * {{{lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))}}}
  * {{{List[List[Symbol]] = List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))}}}
  *
  * @author Yuriy Stul.
  */
object P28SortingLlistAccordingLength extends App {

  test(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))

  /** Test runner
    *
    * @param list the list
    * @tparam T the list elements type
    */
  def test[T](list: List[List[T]]): Unit = {
    println(s"(1) $list -> ${sort1(list)}")
  }

  /** Sorts lists by lengths of lists
    *
    * @param list list of lists
    * @tparam T list elements type
    * @return sorted list of lists
    */
  def sort1[T](list: List[List[T]]): List[List[T]] = {
    list.sortBy(x => x.length)
  }
}
