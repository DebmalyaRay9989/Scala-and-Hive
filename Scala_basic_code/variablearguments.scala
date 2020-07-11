package com.sparkTutorial.rdd.persist

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.storage.StorageLevel



object variableArgument {
    def main(args: Array[String]) {
       printAll("Scala", "is", "great")
    }

    def printAll(strings: String*) {
        var i : Int = 0;

      for( value <- strings ){
         println(value);
         i = i + 1;
      }
    }
}