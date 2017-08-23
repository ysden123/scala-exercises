package com.stulsoft.exercises.arithmetic

/** Calculate Euler's totient function phi(m)
  *
  * @author Yuriy Stul.
  */
object P34CalculateEulerTotientFunction extends App {

  implicit def totient(n: Int): MyInt = new MyInt(n)

  def test(m: Int): Unit = {
    println(s"(1) $m.totient = ${m.totient}")
  }

  class MyInt(val n: Int) {
    def totient: Int = (1 to n).filter { i => isCoprime(i, n) }.foldLeft(0) { (a, _) => a + 1 }

    def isCoprime(n1: Int, n2: Int): Boolean = {
      P32DetermineGreatestCommonDivisor.gcd1(n1, n2) == 1
    }
  }

  test(10)
  test(100)

}
