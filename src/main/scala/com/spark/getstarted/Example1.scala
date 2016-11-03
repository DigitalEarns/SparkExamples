package com.spark.getstarted

import scala.io.Source

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD

import com.spark.utils.Helper

/*
 * A getting started example with Spark
 */
object Example1  {

  // extending App will not work properly, need to use main function explicitly.
  def main (args: Array[String]){
    // local mode is used to run the job locally
    val conf = new SparkConf().setAppName("Example1").setMaster(("local"))
    val sc = new SparkContext(conf)

    // load the file and form RDD
    val trafficData: RDD[String] = sc.textFile(Helper.inputFile)

    // word count example
    val wc: RDD[(String, Int)] = trafficData
      .flatMap(_.split(" ")) // using a space as delimiter here
      .map(word => (word, 1))
      .reduceByKey((a, b) => a + b)

    // write the results to a file
    wc.saveAsTextFile(s"${Helper.outputLocation}")

    /*
        RDDs cannot be printed directly as they are spread across various executors in the cluster.
        To bring them to the driver, call the collect method and then print. It is not a wise idea
        to do this for larger set as memory exceptions could happen on driver.

    */
    wc.collect().foreach(println(_))

    println(s"Number of lines in the file = ${trafficData.count()}")

  }
}
