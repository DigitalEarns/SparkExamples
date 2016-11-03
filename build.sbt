name := "SparkExamples"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq (
  "org.apache.spark"  %% "spark-core"    % "2.0.1",
  "org.apache.hadoop" %  "hadoop-client" % "2.3.0"
)
