package com.stulsoft.exercises.logic.and.codes

/**
  * @author Yuriy Stul.
  */
object P47TruthTablesLogicalExpressions2 extends App {

  implicit class MyLogic(a: Boolean) {
    def and(b: Boolean): Boolean = a & b

    def or(b: Boolean): Boolean = a | b

    def not: Boolean = !a
  }

  def table2(t: (Boolean, Boolean)): Boolean = t._1 and (t._1 or t._2.not)

  Seq((true, true), (true, false), (false, true), (false, false))
    .foreach(t => println(s"${t._1},${t._2} -> ${table2(t)}"))
}
