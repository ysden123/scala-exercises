/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.multiway.trees

/**
  * @author Yuriy Stul
  */
object MTreeTest extends App {
  println(MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e'))))))
}
