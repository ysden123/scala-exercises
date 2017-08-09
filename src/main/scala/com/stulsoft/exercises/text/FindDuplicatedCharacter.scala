/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.text

import scala.annotation.tailrec

/** Determines whether a text contains duplicated characters.
  *
  * @author Yuriy Stul
  */
object FindDuplicatedCharacter extends App {
  println("==>FindDuplicatedCharacter.main")
  test("abcd")
  test("abad")
  test("aabc")
  test("abcb")
  test("aBcb")
  test("aBcB")

  println("<==FindDuplicatedCharacter.main")

  /**
    * Test runner
    *
    * @param text
    */
  def test(text: String): Unit = {
    println(s"Text [$text] contains duplicated characters: ${isDuplicated(text.toList)}")
  }

  /**
    * Checks whether a text contains duplicated characters
    *
    * @param text input
    * @return true, if a text contains duplicated characters; otherwise - false
    */
  @tailrec
  def isDuplicated(text: Seq[Char]): Boolean = {
    if (text == Nil || text.length == 1)
      false
    else {
      val head = text.head
      val tail = text.tail
      if (tail.contains(head))
        true
      else
        isDuplicated(tail)
    }
  }
}
