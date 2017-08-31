package com.stulsoft.exercises.miscellaneous.problems

/** English number words.
  * <p>
  * On financial documents, like checks, numbers must sometimes be written
  * in full words. Example: 175 must be written as one-seven-five. Write
  * a function fullWords(num: Int) to print (non-negative) integer
  * numbers in full words.
  *
  * @author Yuriy Stul.
  */
object P95EnglishNumberWords extends App {
  def test(n: Int): Unit = {
    println(s"$n --> ${numberToWords(n)}")
  }

  def numberToWords(n: Int): String = {
    numberToDigits(n)
      .map {
        case 0 => "zero"
        case 1 => "one"
        case 2 => "two"
        case 3 => "three"
        case 4 => "four"
        case 5 => "five"
        case 6 => "six"
        case 7 => "seven"
        case 8 => "eight"
        case 9 => "nine"
      }
      .mkString("-")
  }

  //  println(s"${123 % 10} ${123 - 123 % 10}")
  //  println(s"${120 % 100 / 10} ${120 - 120 % 100}")
  //  println(s"${100 % 1000 / 100} ${100 - 100 % 1000}")
  //
  //  println(numberToDigits(123))

  test(1)
  test(9)
  test(90)
  test(123)
  test(54321)

  private def numberToDigits(n: Int): Seq[Int] = {
    def getDigits(currentN: Int, currentDivider: Int, currentDigits: Seq[Int]): Seq[Int] = {
      if (currentN == 0)
        currentDigits
      else {
        val digit = (currentN % currentDivider) / (currentDivider / 10)
        getDigits(currentN - (currentN % currentDivider), currentDivider * 10, digit +: currentDigits)
      }
    }

    getDigits(n, 10, Nil)
  }
}
