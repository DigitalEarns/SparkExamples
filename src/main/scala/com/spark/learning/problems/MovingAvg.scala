package com.spark.learning.problems

import org.apache.spark.rdd.RDD

import com.spark.learning.util.SparkSetup

object MovingAvgUtil {
  def getMovAvg(input: RDD[Int], window: Int = 3): RDD[(Long, Int)] = {
    val zipped: RDD[(Long, Int)] = input.zipWithIndex().map(p => p._2 -> p._1)
    val indexed = zipped.flatMap{ t =>
      val keys = (for (i <- t._1 to (t._1 - (window - 1)) by -1) yield i).toList
      keys.flatMap(k => Map(k -> t._2))
    }.groupByKey()

    println(indexed.collect())
    val result =
      indexed
        .filter(_._1 >= 0)
        .map(t => t._1 -> t._2.sum)
        .map(t => t._1 -> t._2 / 3)

    result.sortByKey()
  }
}

object MovingAvg extends SparkSetup {



  def main (args: Array[String]) {
    val inputPath = args(0)
    val window = args(1).toInt

    val input = sc.textFile(inputPath).map(_.toInt)
    MovingAvgUtil.getMovAvg(input, window).collect().map(println)
  }
}