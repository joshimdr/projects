package com.duchessfr.spark.core

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by munish on 7/26/16.
  */
object JoinTwoFilesOnColumn {



  val pathCoords="data/coords.csv"

  val pathUsers="data/users.csv"

  case class Coords( city : String,long: String, lat: String)
  case class Users(id : String, firstName : String,lastName: String,city: String)


  def main(args: Array[String]) {

     val sconf = new SparkConf().setAppName("MunishJoin").setMaster("local[*]")

      val sc = new SparkContext(sconf)

      val sqlContext = new org.apache.spark.sql.SQLContext(sc)

      import sqlContext.implicits._



      val allCoords = sc.textFile(pathCoords).map(s => s.trim.split(","))



      val coordsRDD = allCoords.map(p => Coords(p(0).toString,p(1).toString,p(2).toString))

      coordsRDD.foreach(a => println(a))





      //.map(line => line.replaceAll("\".*,.*\"", ";")) // split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        val userRDD = sc.textFile(pathUsers).map(_.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1).map(_.trim))


        val userRDD2 = userRDD.map(p=> Users(p(0).toString,p(1).toString,p(2).toString,p(3).toString))

        val userDF = userRDD2.toDF("id","firstname","lastname","city")


          val coordsDF = coordsRDD.toDF()

          userDF.show()
          coordsDF.show()

          // val new_ddf = userDF.join(coordsDF, (userDF.city==coordsDF.city))

           // userDF.join(coordsDF, userDF.city==coordsDF.city)

          val new_ddf = userDF.join(coordsDF, "city")

            new_ddf.show()

         // new_ddf.collect().foreach(a => println(a(0), a(1) , a(2) , a(3)) )

        //usersRDD.first().foreach(println)


  }



}
