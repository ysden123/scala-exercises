/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.exercises.list

/**
  * Flatten nested structure
  *
  * @author Yuriy Stul
  */
object P07FlattenNestedStructure extends App {
  test(List(List(1, 3, 5), 4, List(8, 7)))
  test(List(List(1, 3, 5), 4, List(8, 7, List(13, 15))))
  test(Seq(Seq(1, 3, 5), 4, Seq(8, 7, Seq(13, 15))))
  test(Seq(Seq(1, 3, 5), "abcd", Seq(8, 7, Seq(13, 15))))

  /**
    * Test runner
    *
    * @param collection the collection
    */
  def test(collection: Seq[Any]): Unit = {
    println(s"Source collection is $collection, flatten collection is ${flattenNestedStructure(collection)}")
  }

  /**
    * Flattens a collection
    *
    * @param collection the collection
    * @return flatten collection
    */
  def flattenNestedStructure(collection: Seq[Any]): Seq[Any] = collection flatMap {
    case aList: Seq[_] => flattenNestedStructure(aList)
    case anItem => List(anItem)
  }
}
