/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.permutation

/**
  * @see [[https://gist.github.com/AhmedSoliman/ce17e5dd4927f4349696 Generate Permutations of String in Scala]]
  * @author Yuriy Stul
  */
object Permutation extends App {

  test(List(1, 2, 3))

  def test(input: List[Int]): Unit = {
    println(s"(1) input: $input, permutations:")
    permutations1(input).foreach(x => println(s"   $x"))
  }

  def permutations1(list: List[Int]): List[List[Int]] = list match {
    case Nil => List(Nil)
    case List(_) => List(list)
    case x =>
      println(x)
      (
        for (i <- list.indices.toList) yield {
          val (before, rest) = list.splitAt(i)
          val element = rest.head
          val subPermutations = permutations1(before ++ rest.tail)
          subPermutations.map(element :: _)
        }).flatten
  }
}
