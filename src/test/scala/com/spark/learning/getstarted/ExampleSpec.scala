package com.spark.getstarted


import org.scalatest.{Matchers, FlatSpec}

import com.spark.learning.getstarted.Example1RDD

import com.spark.learning.test.helper._


class Example1Spec extends SparkTest {

  val inputString = Array("This is first line", "This is second line")
  val inputRdd = sc.parallelize(inputString)

  try {
    "Example1" should "run correctly all methods" in {
      Example1RDD.wordCount(inputRdd).collect() shouldBe
        Array(("is",2), ("second",1), ("line",2), ("This",2), ("first",1))

    }

  } catch {
    case e: Exception => throw new Exception(e)
  } finally {
    println("Will stop the context")
  }
}