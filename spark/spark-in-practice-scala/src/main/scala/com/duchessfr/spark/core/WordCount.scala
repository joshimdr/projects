package com.duchessfr.spark.core


import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by munish on 7/25/16.
  */
object WordCount {

  val pathToFile = "data/wordcount.txt"

  def main(args: Array[String]) {



//    val wordRDD = loadWordsFromFile()
//
//    wordRDD.foreach(a => println(a))

      val wordCount  = getWordCount

      wordCount.foreach(a=> println(a))


  }


  def loadWordsFromFile(): RDD[String] = {

    val sconf = new SparkConf().setAppName("munishWCount").setMaster("local[*]")

    val scontext = new SparkContext(sconf)

    val wordRdd = scontext.textFile(pathToFile).flatMap(_.split(" "))



    wordRdd

  }



  def getWordCount: RDD[(String, Int)] = {


    val wordRDD = loadWordsFromFile()


    val wordCount = wordRDD.map(a => (a,1)).reduceByKey(_+_)

    wordCount;

  }






}
