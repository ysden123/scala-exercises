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

    def canPlace(row: Int, column: Int): Boolean = {
      var result: Boolean = true
      // since we filling one column at a time
      // we will check if no queen is placed in that particular row
      for (i <- 0 until column if result) {
        if (solution(row)(i) == 1) {
          result = false
        }
      }

      // we are filling one column at a time,so we need to check the upper and
      // diagonal as well
      // check upper diagonal
      for ((i, j) <- getRowsColumnsForUpperDiagonal(row, column) if result) {
        if (solution(i)(j) == 1) {
          result = false
        }
      }

      // check lower diagonal
      for ((i, j) <- getRowsColumnsForLowerDiagonal(row, column) if result) {
        if (solution(i)(j) == 1) {
          result = false
        }
      }

      // if result is true that means we are safe to place Queen at row,column
      result
    }

    private def placeQueens(queen: Int): Boolean = {
      // will place the Queens one at a time, for column wise
      var result: Boolean = false
      if (queen == N)
        result = true //if we are here that means we have solved the problem

      for (row <- 0 until N if !result) {
        // check if queen can be placed row,col
        if (canPlace(row, queen)) {
          // place the queen
          solution(row)(queen) = 1
          // solve for next queen
          if (placeQueens(queen + 1))
            result = true
          else
            solution(row)(queen) = 0
        }
      }
      result
    }

    private def getRowsColumnsForUpperDiagonal(startRow: Int, startColumn: Int): Seq[(Int, Int)] = {
      def buildRowsColumns(startRow: Int, startColumn: Int, currentSeq: Seq[(Int, Int)]): Seq[(Int, Int)] = {
        if (startRow < 0 || startColumn < 0)
          currentSeq
        else
          buildRowsColumns(startRow - 1, startColumn - 1, currentSeq :+ (startRow, startColumn))
      }

      buildRowsColumns(startRow, startColumn, Nil)
    }

    private def getRowsColumnsForLowerDiagonal(startRow: Int, startColumn: Int): Seq[(Int, Int)] = {
      def buildRowsColumns(startRow: Int, startColumn: Int, currentSeq: Seq[(Int, Int)]): Seq[(Int, Int)] = {
        if (startRow >= N || startColumn < 0)
          currentSeq
        else
          buildRowsColumns(startRow + 1, startColumn - 1, currentSeq :+ (startRow, startColumn))
      }

      buildRowsColumns(startRow, startColumn, Nil)
    }
  }

  new NQueensBT(4).solve()
}
