/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.miscellaneous.problems

/**
  * @author Yuriy Stul
  */
object NQueensBT extends App {

  class NQueensBT(val N: Int) {
    private val solution = Array.ofDim[Int](N, N)

    def printSolution(): Unit = {
      print(solution.map(_.mkString(", ")).mkString("\n"))
    }
  }

}
