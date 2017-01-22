package com.spark.learning.test.helper

import org.apache.spark.{SparkContext, SparkConf}
import org.scalatest.{ FlatSpec, Matchers }

trait SparkTest extends FlatSpec with Matchers {
  lazy val sparkConf = new SparkConf()
    .setAppName("Spark-Learning-Test")
    .setMaster("local")
  lazy val sc = new SparkContext(sparkConf)
}
