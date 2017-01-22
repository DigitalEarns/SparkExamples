package com.problems

import org.apache.spark.rdd.RDD
import org.scalatest.{FlatSpec, Matchers}

import com.spark.learning.test.helper.SparkTest
import com.spark.learning.problems.MovingAvgUtil

class MovingAvgSpec extends SparkTest {

  def avg(x: Iterable[Int]): Int = x.sum / x.size

  val input1: RDD[Int] = sc.parallelize(Array(10,20,30,40,50,60,70,80,90,100,110,220,130))


  "Moving Avg" should "find the right output" in {
    MovingAvgUtil.getMovAvg(input1, 3).collect() shouldBe
      Array(
        (0,20),
        (1,30),
        (2,40),
        (3,50),
        (4,60),
        (5,70),
        (6,80),
        (7,90),
        (8,100),
        (9,143),
        (10,153),
        (11,116),
        (12,43))
  }
}
