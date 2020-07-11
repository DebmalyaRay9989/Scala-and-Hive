package com.sparkTutorial.rdd.persist

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.storage.StorageLevel


object factorialDemo {
    Logger.getLogger("org").setLevel(Level.ERROR)
    
   def main(args: Array[String]) {
      for (i <- 1 to 5)
         println( "Factorial of " + i + ": = " + factorial(i) )
   }

   def factorial(n: Int): Int = {  
      if (n <= 1)
         return 1  
      else    
      return n * factorial(n - 1)
   }

}