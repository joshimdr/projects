name := "Spark-HandsOn"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.5.2"

libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "1.5.2"

libraryDependencies += "org.apache.spark" % "spark-mllib_2.11" % "1.5.2"

libraryDependencies += "org.apache.spark" % "spark-streaming_2.11" % "1.5.2"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.4"

libraryDependencies += "com.google.code.gson" % "gson" % "2.3.1"

libraryDependencies += "org.apache.spark" % "spark-streaming-twitter_2.11" % "1.5.2"

libraryDependencies += "org.twitter4j" % "twitter4j-core" % "3.0.3"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.2.4" % "test"

libraryDependencies += "com.databricks" % "spark-csv_2.11" % "1.2.0"

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"
