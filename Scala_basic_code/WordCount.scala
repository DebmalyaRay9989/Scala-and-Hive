/**
 * Illustrates flatMap + countByValue for wordcount.
 */
// package com.oreilly.learningsparkexamples.mini.scala

import org.apache.spark._
import org.apache.spark.SparkContext._

object WordCount {
    def main(args: Array[String]) {
      val inputFile = args(0)
     // val outputFile = args(1)
      val conf = new SparkConf().setAppName("wordCount")
      // Create a Scala Spark Context.
      val sc = new SparkContext(conf)
      // Load our input data.
      val input =  sc.textFile(inputFile)
      // Split up into words.
      val words = input.flatMap(line => line.split(" "))

      val wordsRDD = words.map(_.toLowerCase).filter(Seq("a", "e","i","o","u").contains(_))
          
      wordsRDD.collect


}

}






