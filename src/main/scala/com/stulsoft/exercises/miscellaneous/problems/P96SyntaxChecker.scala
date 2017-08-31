package com.stulsoft.exercises.miscellaneous.problems

/** P96 (**) Syntax checker
  * <p>
  * May start with letter and may contain '-', letters, or digits
  *
  * @author Yuriy Stul.
  */
object P96SyntaxChecker extends App {
  test("t")
  test("ttt")
  test("1ttt")
  test("t-tt-456bnvbnv")
  test("")

  def test(s: String): Unit = {
    println(s"$s is identifier: ${isIdentifier(s)}")
  }

  def isIdentifier(s: String): Boolean = {
    if (s.isEmpty || !s.head.isLetter)
      false
    else {
      def check(symbols: Seq[Char]): Boolean = {
        if (symbols == Nil)
          true
        else {
          val symbol = symbols.head
          if (symbol.isLetterOrDigit || symbol == '-')
            check(symbols.tail)
          else
            false
        }
      }

      check(s.tail)
    }
  }
}
