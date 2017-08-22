package com.stulsoft.exercises.list

/**
  * @author Yuriy Stul.
  */
object P26GenerateCombinations extends App {

  test(3, List(1, 2, 3, 4, 5))

  def test[A](n: Int, ls: List[A]): Unit = {
    val r1 = combinations1(n, ls)
    println(s"(1) $n from $ls -> ${r1.length}s $r1")
  }

  /** Builds combinations
    *
    * @param n  number of elements in combinations
    * @param ls the list
    * @tparam A the list items type
    * @return list of combinations
    */
  def combinations1[A](n: Int, ls: List[A]): List[List[A]] = {
    /** flatMapSublists is like list.flatMap, but instead of passing each element
      * to the function, it passes successive sublists of L.
      */
    def flatMapSublists[A, B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
      ls match {
        case Nil => Nil
        case sublist@(_ :: tail) => f(sublist) ::: flatMapSublists(tail)(f) // There are two patterns
      }

    if (n == 0) List(Nil)
    else flatMapSublists(ls) { sl =>
      combinations1(n - 1, sl.tail) map {
        sl.head :: _
      }
    }
  }
}
