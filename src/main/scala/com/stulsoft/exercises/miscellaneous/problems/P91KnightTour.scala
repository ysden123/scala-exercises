package com.stulsoft.exercises.miscellaneous.problems

/** Knight's tour.
  * <p>
  * How can a knight jump on an N×N chessboard in such a way that it visits every square exactly once?
  *
  * @author Yuriy Stul.
  */
object P91KnightTour extends App {

  case class KnightTour(n: Int) {
    /**
      * Builds list of squares that knight can jump from (x,y)
      *
      * @param x start row
      * @param y start column
      * @return list of squares that knight can jump from (x,y)
      */
    def jumps(x: Int, y: Int): Seq[(Int, Int)] = {
      val allJumps = Seq(
        (x + 1, y + 2), (x + 1, y - 2), (x + 2, y + 1), (x + 2, y - 1),
        (x - 1, y + 2), (x - 1, y - 2), (x - 2, y + 1), (x - 2, y - 1))

      allJumps.filter { t => t._1 >= 0 && t._1 < n && t._2 >= 0 && t._2 < n }
    }
  }

  println(KnightTour(8).jumps(1, 1))
  println(KnightTour(8).jumps(3, 3))
  println(KnightTour(8).jumps(4, 4))

}
