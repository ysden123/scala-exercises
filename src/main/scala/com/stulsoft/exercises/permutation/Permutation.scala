/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.permutation

/**
  * @see [[https://www.youtube.com/watch?v=_1YHHlX1zvc Permutations (using Scala]]
  * @author Yuriy Stul
  */
object Permutation extends App {

  test(List(1, 2, 3))
  //  test(List(1, 2, 3, 4))

  def test(input: List[Int]): Unit = {
    var permutations = permutations1(input)
    println(s"(1) input: $input, (${permutations.length}) permutations:")
    permutations.foreach(x => println(s"   $x"))

    permutations = permutations2(input)
    println(s"(2) input: $input, (${permutations.length}) permutations:")
    permutations.foreach(x => println(s"   $x"))
  }

  def permutations1(list: List[Int]): List[List[Int]] = list match {
    case Nil => List(Nil) // Empty input list
    case List(_) => List(list) // Input is list with only one element
    case _ => // Input is list with more than one elements
      (
        for (i <- list.indices.toList) yield {
          val (before, rest) = list.splitAt(i)
          val element = rest.head
          val subPermutations = permutations1(before ++ rest.tail)
          println(s"subPermutations: $subPermutations")
          val r = subPermutations.map(element :: _)
          println(s"r: $r")
          r
        }).flatten
  }

  def permutations2(list: List[Int]): List[List[Int]] = {
    def permutations(currentList: List[Int]): List[List[Int]] = currentList match {
      case Nil => List(Nil) // Empty input list
      case List(_) => List(currentList) // Input is list with only one element
      case x => // Input is list with more than one elements
        (
          for (i <- x.indices.toList) yield {
            val (before, rest) = x.splitAt(i)
            val element = rest.head
            val subPermutations = permutations(before ++ rest.tail)
            subPermutations.map(element :: _)
          }).flatten
    }

    permutations(list)
  }
}
