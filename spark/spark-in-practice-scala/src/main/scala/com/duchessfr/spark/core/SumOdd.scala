package com.duchessfr.spark.core

/**
  * Created by munish on 9/7/16.
  */

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


  object SumOdd{

    val pathToFile = "data/numbers.csv"


    def main(args: Array[String]){

      val sconf = new SparkConf().setAppName("MunishSum").setMaster("local[*]")
      val scontext = new SparkContext(sconf)

     // val numbers = // scontext.textFile(pathToFile).flatMap(_.split(",").filter(isOdd(_)))

      val numbers = scontext.textFile(pathToFile).flatMap(_.split(","))
      println("******************")
      print(numbers)


  //        .reduce((x, y) => x + y)
      var oddSum = 0
      var count = 0

      println("******************")
      print(numbers)




//      for(num <- numbers.collect()){
//        if(isOdd(num.toInt)){
//          oddSum = oddSum + num.toInt;
//          count = count+1;
//        }
//      }

     // println(oddSum/count)
    }

    def isEven(number: Int) = number%2 ==0
    def isOdd(number: Int) = !isEven(number)

  }


