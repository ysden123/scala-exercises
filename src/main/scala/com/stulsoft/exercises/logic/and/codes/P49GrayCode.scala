package com.stulsoft.exercises.logic.and.codes

/** Gray code
  * {{{
  * An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example,
  * n = 1: C(1) = ("0", "1").
  * n = 2: C(2) = ("00", "01", "11", "10").
  * n = 3: C(3) = ("000", "001", "011", "010", "110", "111", "101", "100").
  * Find out the construction rules and write a function to generate Gray codes.
  *
  * gray(3)
  * List[String] = List(000, 001, 011, 010, 110, 111, 101, 100)
  * }}}
  *
  * @see [[https://ru.wikipedia.org/wiki/%D0%9A%D0%BE%D0%B4_%D0%93%D1%80%D0%B5%D1%8F Gray Code]]
  * @author Yuriy Stul.
  */
object P49GrayCode extends App {
  //  test(1)
  test(2)
  //  test(3)

  def test(n: Int): Unit = {
    println(s"(1) $n -> ${gray(n)}")
  }

  def gray(n: Int): List[String] =
    if (n == 0) List("")
    else {
      val lower = gray(n - 1)
      (lower map {
        "0" + _
      }) ::: (lower.reverse map {
        "1" + _
      })
    }
}
