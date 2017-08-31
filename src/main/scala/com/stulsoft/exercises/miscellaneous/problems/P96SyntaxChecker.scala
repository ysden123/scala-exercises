package com.stulsoft.exercises.miscellaneous.problems

/** P96 (**) Syntax checker
  * <p>
  * May start with letter and may contain '-', letters, or digits
  *
  * @author Yuriy Stul.
  */
object P96SyntaxChecker extends App {
  test("t")
  test("abc")
  test("1ttt")
  test("t-tt-456bnvbnv")
  test("")
  test("-123")

  def test(s: String): Unit = {
    println(s"$s is identifier: ${isIdentifier(s)}")
  }

  def isIdentifier(s: String): Boolean = {
    if (s.isEmpty || !s.head.isLetter)
      false
    else {
      def check(symbols: Seq[Char]): Boolean = symbols match {
        case Nil => true
        case head :: tail =>
          if (!head.isLetterOrDigit && head != '-')
            false
          else
            check(tail)
      }

      check(s.tail.toList)
    }
  }
}
