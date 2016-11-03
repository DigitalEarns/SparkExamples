package com.spark.utils

object Helper {
  val inputFile = getClass.getResource("/traffic.csv").getPath
  val outputLocation = "/tmp/spark/output"
}
