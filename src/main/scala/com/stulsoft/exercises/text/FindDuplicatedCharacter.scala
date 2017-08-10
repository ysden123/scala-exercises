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

  testG(Seq(1,2,3,4))
  testG(List(1,1,3,4))
  testG(List(1,2,2,4))
  testG(List("1","2","2","4"))
  testG(List("1","2","2",4))
  testG(List[Char]('1','2','2',55))
// Error: type mismatch  testG(List[Char]('1','2','2',"55"))

  println("<==FindDuplicatedCharacter.main")

  /**
    * Test runner
    *
    * @param text the text to check
    */
  def test(text: String): Unit = {
    println(s"Text [$text] contains duplicated characters: ${isDuplicated(text.toList)}")
  }

  def testG[T](input:Seq[T]):Unit={
    println(s"Input [$input] contains duplicated items: ${isDuplicatedG(input)}")
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

  @tailrec
  def isDuplicatedG[T](collection: Seq[T]): Boolean = {
    if (collection == Nil | collection.length == 1)
      false
    else {
      val head = collection.head
      val tail = collection.tail
      if (tail.contains(head))
        true
      else
        isDuplicatedG(tail)
    }
  }
}
