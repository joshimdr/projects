package com.duchessfr.spark.core

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
  * Created by munish on 7/26/16.
  */
object WordCount1 {


  val pathToFile = "data/wordcount1.txt"

  def main(args: Array[String]) {


    val wordcount = doWordCount();

    wordcount.foreach(println)


  }


  def doWordCount(): RDD[(String, Int)] = {


    val spconf = new SparkConf().setMaster("local[*]").setAppName("Munish's app")

    val spcontext = new SparkContext(spconf)

    val countRDD = spcontext.textFile(pathToFile).flatMap(_.split(" ")).map(a => (a,1)).reduceByKey(_+_).filter(x => (x._1.startsWith("m")))

 //   val filteredRDD = countRDD.filter(x => (x._1.startsWith("m")))


    countRDD

  }





}
