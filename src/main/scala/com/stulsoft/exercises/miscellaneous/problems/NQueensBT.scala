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

    def solve(): Unit = {
      if (placeQueens(0))
        printSolution()
      else
        println("No solution exists")
    }

    def printSolution(): Unit = {
      print(solution.map(_.mkString(", ")).mkString("\n"))
    }

    private def placeQueens(queen: Int): Boolean = {
      // will place the Queens one at a time, for column wise
      var result: Boolean = false
      if (queen == N)
        result = true //if we are here that means we have solved the problem
      else for (row <- 0 until N) {
        // check if queen can be placed row,col
        if (canPlace(row, queen)) {
          // place the queen
          solution(row)(queen) = 1
          // solve for next queen
          if (placeQueens(queen + 1))
            result = true
          else {
            solution(row)(queen) = 0
          }
        }
      }
      result
    }

    private def canPlace(row: Int, column: Int): Boolean = {
      var result: Boolean = true
      // since we filling one column at atime
      // we will check if no queen is placed in that particular row
      for (i <- 0 until column) {
        if (solution(row)(i) == 1) {
          result = false
        }
      }

      if (result) {
        // we are filling one column at a time,so we need to check the upper and
        // diagonal as well
        // check upper diagonal
        for (i <- row to 0 by -1;
             j <- column to 0 by -1) {
          if (solution(i)(j) == 1)
            result = false
        }
      }

      if (result) {
        // check lower diagonal
        for (i <- row until N;
             j <- column to 0 by -1) {
          if (solution(i)(j) == 1)
            result = false
        }
      }

      // if result is true that means we are safe to place Queen at row,column
      result
    }
  }

  new NQueensBT(4).solve()

}
