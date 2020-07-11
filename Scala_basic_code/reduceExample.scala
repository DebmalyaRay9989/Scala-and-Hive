// package com.sparkbyexamples.spark.rdd.functions

//Question 13

import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object reduceExample extends SimpleApp {

  val spark = SparkSession.builder().appName("SparkByExamples.com").master("local[3]").getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")
  
   val logFile = "hdfs://nameservice1/bigdatapgp/common_folder/assignment4/text_dataset/macbeth.txt"
      val conf = new SparkConf().setAppName("Simple Application")
      val sc = new SparkContext(conf) 
      val logData = sc.textFile(logFile, 2).cache()
      val linesWithKing = logData.filter(line => line.contains("King")).count()
      val NumberofL = sc.textFile(logFile).filter(line => line.count())

	  val listRdd = logData.flatMap(line => line.split(",")).map(word => (word, 1))
    //  val listRdd = spark.sparkContext.parallelize(List(1,2,3,4,5,3,2))
    

  println("output sum using binary : "+listRdd.reduce(_ min _))
  println("output min using binary : "+listRdd.reduce(_ max _))
  println("output max using binary : "+listRdd.reduce(_ + _))
  println("lines containing the word King : "+linesWithKing)


  // Alternatively you can write
  println("output min : "+listRdd.reduce( (a,b) => a min b))
  println("output max : "+listRdd.reduce( (a,b) => a max b))
  println("output sum : "+listRdd.reduce( (a,b) => a + b))


}

