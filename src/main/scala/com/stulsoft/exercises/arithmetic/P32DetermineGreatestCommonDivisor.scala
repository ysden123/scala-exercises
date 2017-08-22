package com.stulsoft.exercises.arithmetic

import scala.annotation.tailrec

/** Determine the greatest common divisor of two positive integer numbers.
  *
  * [[https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm]]
  *
  * @author Yuriy Stul.
  */
object P32DetermineGreatestCommonDivisor extends App {

  test(4, 2)
  test(2, 4)
  test(270, 192)
  test(192, 270)
  test(21, 14)

  /** Test runner
    *
    * @param n1 1st number
    * @param n2 2nd number
    */
  def test(n1: Int, n2: Int): Unit = {
    println(s"(1) GCD($n1,$n2) = ${gcd1(n1, n2)}")
  }

  /** Determinates the greatest common divisor of two positive integer numbers.
    *
    * @param n1 1st number
    * @param n2 2nd number
    * @return the greatest common divisor
    */
  @tailrec
  def gcd1(n1: Int, n2: Int): Int = {
    if (n1 == 0)
      n2
    else if (n2 == 0)
      n1
    else
      gcd1(n2, n1 % n2)
  }
}
