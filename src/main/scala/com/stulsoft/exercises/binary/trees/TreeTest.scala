package com.stulsoft.exercises.binary.trees

/** Test for Tree
  *
  * @author Yuriy Stul.
  */
object TreeTest extends App {
  println(Node('a',
    Node('b', Node('d'), Node('e')),
    Node('c', End, Node('f', Node('g'), End))
  ))

  def test2(): Unit = {
    val n1 = Node('a')
    val n2 = n1.addNodeToLeft(Node('l', End, End))
    val n3 = n2.addNodeToRight(Node('r', End, End))
    println(s"n1: $n1")
    println(s"n2: $n2")
    println(s"n3: $n3")
  }

  test2()

  https://www.google.co.il/search?q=scala+covariant+type+T+occurs+in+contravariant+position+in+type+T+of+value&rlz=1C1GGRV_enIL748IL748&oq=scala+covariant+type+T+occurs+in+contravariant+position+in+type+T+of+value&aqs=chrome..69i57.2856j0j7&sourceid=chrome&ie=UTF-8
  trait TT[+T]{
    def f[U :> T](a:U) = ???
  }
  class TTT[T] extends TT[T]{
    override def f(a: Any): Nothing = super.f(a)
  }

  val ttt = new TTT[String]
  ttt.f(123)
}
