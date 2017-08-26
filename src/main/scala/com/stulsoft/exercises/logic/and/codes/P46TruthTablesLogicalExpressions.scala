package com.stulsoft.exercises.logic.and.codes

/** Truth tables for logical expressions
  * <p>
  * Define functions and, or, nand, nor, xor, impl, and equ (for logical equivalence)
  * which return true or false according to the result of their respective operations;
  *   e.g. and(A, B) is true if and only if both A and B are true.
  * <p>
  * Examples:
  * {{{
  *       and(true, true)
  *       Boolean = true
  *
  *       xor(true, true)
  *       Boolean = true
  *
  *       table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
  * }}}
  *
  * @author Yuriy Stul.
  */
object P46TruthTablesLogicalExpressions extends App {

  def test1(b1: Boolean, b2: Boolean): Unit = {
    println(s"$b1 and $b2 is ${and(b1, b2)}")
    println(s"$b1 or $b2 is ${or(b1, b2)}")
    println(s"$b1 nand $b2 is ${nand(b1, b2)}")
    println(s"$b1 nor $b2 is ${nor(b1, b2)}")
    println(s"$b1 xor $b2 is ${xor(b1, b2)}")
    println(s"$b1 equ $b2 is ${equ(b1, b2)}")
  }

  def and(b: Boolean, that: Boolean): Boolean = b & that

  def or(b: Boolean, that: Boolean): Boolean = b | that

  def nand(b: Boolean, that: Boolean): Boolean = !and(b, that)

  def nor(b: Boolean, that: Boolean): Boolean = !or(b, that)

  def xor(b: Boolean, that: Boolean): Boolean = b ^ that

  def equ(b: Boolean, that: Boolean): Boolean = b == that

  def test2(t: (Boolean, Boolean)): Unit = {
    println(s"(t) ${t._1}, ${t._2} --> ${table2(t)}")
  }

  def table2(t: (Boolean, Boolean)): Boolean = and(t._1, or(t._1, t._2))

  Seq((true, true), (true, false), (false, true), (false, false))
    .foreach { x => test1(x._1, x._2) }

  Seq((true, true), (true, false), (false, true), (false, false))
    .foreach { x => test2(x._1, x._2) }

}
