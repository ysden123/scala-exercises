package com.stulsoft.exercices.list

/** Rotate a list N places to the left
  * <p>
  * Examples:
  * {{{rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))}}}
  * {{{List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)}}}
  *
  * {{{rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))}}}
  * {{{List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)}}}
  *
  * @author Yuriy Stul.
  */
object RotateListNPlacesLeft extends App {
  test(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

  def test[T](n: Int, list: List[T]): Unit = {
    println(s"(1) $list with n=$n -> ${rotate1(n, list)}")
  }

  def rotate1[T](n: Int, list: List[T]): List[T] = {
    def rotate(curN: Int, curR: List[T], curSuffix:List[T], next: List[T]): List[T] = (curN, next) match {
      case (_, Nil) =>
        curR ++ curSuffix
      case (0, ls) =>
        curR ++ ls
      case (cn, h :: t) =>
        rotate(cn - 1, curR :+ h, Nill, t)
    }

    rotate(n, Nil, Nill, list)
  }
}
