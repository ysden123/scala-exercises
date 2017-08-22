package com.stulsoft.exercises.arithmetic

/** Determine the greatest common divisor of two positive integer numbers.
  *
  * [[https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm]]
  * @author Yuriy Stul.
  */
object P32DetermineGreatestCommonDivisor extends App {

  def gcd1(n1:Int,n2:Int):Int = {
   if (n1 == 0) n2
   else if (n2 == 0) n1
  }
}
