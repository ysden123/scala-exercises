/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.permutation

/**
  * @author Yuriy Stul
  */
object Permutation extends App {

  test("123")
  //  test(List(1, 2, 3))

  def test(input: String): Unit = {
    println(s"(1) input: $input, permutations:")
    permutations1(input).foreach(x => println(s"   $x"))
  }

  def permutations1(s: String): List[String] = {
    def merge(ins: String, c: Char): Seq[String] =
      for (i <- 0 to ins.length) yield
        ins.substring(0, i) + c + ins.substring(i, ins.length)

    if (s.length() == 1)
      List(s)
    else
      permutations1(s.substring(0, s.length - 1)).flatMap { p =>
        merge(p, s.charAt(s.length - 1))
      }
  }
}
