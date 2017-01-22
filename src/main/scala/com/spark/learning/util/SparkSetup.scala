package com.spark.learning.util

import org.apache.spark.{SparkContext, SparkConf}

trait SparkSetup {
  lazy val sparkConf = new SparkConf().setAppName("Spark-Learning")
  lazy val sc = new SparkContext(sparkConf)
}