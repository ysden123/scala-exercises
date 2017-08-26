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

  test2()

  def test2(): Unit = {
    val n1 = Node('a')
    val n2 = n1.addNodeToLeft(Node('l', End, End))
    val n3 = n2.addNodeToRight(Node('r', End, End))
    println(s"n1: $n1")
    println(s"n2: $n2")
    println(s"n3: $n3")
  }

  def test3(): Unit = {
    val n1 = Node('a, Node('b), Node('c, Node('d)))
    // Error:   n1.isMirrorOf(List("vnbvbnv"))
    n1.isMirrorOf(Node(List("vnbvbnv")))
  }
}
