package com.stulsoft.exercises.arithmetic

/** Determine whether a given integer number is prime.
  * <p>
  * Example:
  * {{{7.isPrime}}}
  * {{{true}}}
  *
  * @author Yuriy Stul.
  */
object P31DetermineWhetherPrime extends App {

  test(1)
  test(2)
  test(3)
  test(4)
  test(5)
  test(6)

  implicit def isPrime(i: Int): MyInt = new MyInt(i)

  /** Test runner
    */
  def test(n: Int): Unit = {
    println(s"(1) $n is prime: ${isPrime1(n)}")
    println(s"(2) $n is prime: ${n.isPrime}")
  }

  /** Checks whether n is prime or not
    *
    * @param n the n
    * @return true, if n is prime; false otherwise
    */
  def isPrime1(n: Int): Boolean = {
    if (n <= 1)
      false
    else if (n == 2)
      true
    else
      !(2 until n).exists(x => n % x == 0)
  }

  class MyInt(val i: Int) {
    def isPrime: Boolean = isPrime1(i)
  }

}
