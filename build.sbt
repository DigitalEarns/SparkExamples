name := "SparkExamples"

scalaVersion := "2.11.3"

val sparkVersion = "2.1.0"

parallelExecution in ThisBuild := false

libraryDependencies ++= Seq (
  "org.apache.spark"  %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion,
  "org.apache.hadoop" %  "hadoop-client" % "2.3.0",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)
