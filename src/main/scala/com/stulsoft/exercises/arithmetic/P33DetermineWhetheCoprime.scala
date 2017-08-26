package com.stulsoft.exercises.arithmetic

/** Determine whether two positive integer numbers are coprime
  *
  * @author Yuriy Stul.
  */
object P33DetermineWhetheCoprime extends App {

  def test(n1: Int, n2: Int): Unit = {
    println(s"$n1 and $n2 are coprime: ${n1.isCoprime(n2)}")
  }

  implicit def isCoprime(n1: Int): MyInt = new MyInt(n1)

  class MyInt(val n1: Int) {
    def isCoprime(n2: Int): Boolean = {
      P32DetermineGreatestCommonDivisor.gcd1(n1, n2) == 1
    }
  }

  test(1, 2)
  test(13, 17)
  test(9, 18)
}
