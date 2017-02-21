package com.duchessfr.spark.core


import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by munish on 7/28/16.
  */
object JoinTwoTabs {



  val pathToUser1 = "data/users1.csv"

  val pathToUser2 = "data/users2.csv"

  val pathToCities = "data/cities.csv"

  case class User1(id:String, fname: String, lname: String, city:String)

  case class City(city: String, longi: String, lat:String)


  def main(args: Array[String]): Unit = {


    val sconf = new SparkConf().setMaster("local[*]").setAppName("Munish Two Table Join")

    val scontext = new SparkContext(sconf)



    val sqlContext = new org.apache.spark.sql.SQLContext(scontext)

    import sqlContext.implicits._



    val rdduser = scontext.textFile(pathToUser1).map(s=>s.trim.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1))

    val rddUserDF = rdduser.map(p=>User1(p(0),p(1),p(2),p(3)))

    //val rddcities = scontext.textFile(pathToCities).map(s=>s.trim.split(","))

    val rddcities = scontext.textFile(pathToCities).map(s => s.trim.split(","))

    val rddcitiesDF = rddcities.map(p=>City(p(0).toString,p(1).toString,p(2).toString))



    rdduser.foreach(s => print(s))

    rddcitiesDF.foreach(s => print(s))

    rddUserDF.foreach(print)


    //val df = sqlContext.read.load(pathToUser2, format='com.databricks.spark.csv',  header='true', inferSchema='true')

    val df = sqlContext.read
      .format("com.databricks.spark.csv")
      .option("header", "true") // Use first line of all files as header
      .option("inferSchema", "true") // Automatically infer data types
      .load(pathToUser2)
    df.show()


  }





}
