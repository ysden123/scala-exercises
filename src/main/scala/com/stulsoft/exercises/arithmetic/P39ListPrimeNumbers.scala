package com.stulsoft.exercises.arithmetic

/** A list of prime numbers
  * <p>
  * Example:
  * {{{
  *     listPrimesinRange(7 to 31)
  *     List(7, 11, 13, 17, 19, 23, 29, 31)
  * }}}
  *
  * @author Yuriy Stul.
  */
object P39ListPrimeNumbers extends App {

  def test(start: Int, end: Int): Unit = {
    println(s"(1) ($start,$end) -> ${listPrimesInRange(start to end)}")
  }

  implicit def isPrime(i: Int): MyInt = new MyInt(i)

  def listPrimesInRange(r: Range): List[Int] = {
    r.filter { x => x.isPrime }.toList
  }

  class MyInt(val n: Int) {
    def isPrime: Boolean = {
      if (n <= 1)
        false
      else if (n == 2)
        true
      else
        !(2 until n).exists(x => n % x == 0)
    }
  }

  test(7, 31)
}
