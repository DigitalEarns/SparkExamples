package com.spark.learning.getstarted

import org.apache.spark.rdd.RDD

import com.spark.learning.util.SparkSetup

/*
 * A getting started example with Spark
 */
object Example1RDD extends SparkSetup {

  def wordCount(input: RDD[String]) = input
    .flatMap(_.split(" "))
    .map(word => (word, 1))
    .reduceByKey((a, b) => a + b)

  // extending App will not work properly, need to use main function explicitly.
  def main (args: Array[String]){

    // load the file and form RDD
    val trafficData: RDD[String] = sc.textFile(args(0))

    // word count example
    val wc: RDD[(String, Int)] = wordCount(trafficData)

    /*
        RDDs cannot be printed directly as they are spread across various executors in the cluster.
        To bring them to the driver, call the collect method and then print. It is not a wise idea
        to do this for larger set as memory exceptions could happen on driver.
    */
    wc.collect().foreach(println(_))
    println(s"Number of lines in the file = ${trafficData.count()}")
  }
}
