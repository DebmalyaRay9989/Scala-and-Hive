//package com.sparkTutorial.rdd.persist

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.storage.StorageLevel

object FizzBuzz {

  def main(args: Array[String]) {
    Logger.getLogger("org").setLevel(Level.ERROR)
    
   // val conf = new SparkConf().setAppName("reduce").setMaster("local[*]")
  //  val sc = new SparkContext(conf)

 //   val inputIntegers = List(1, 2, 3, 4, 5)
 //   val integerRdd = sc.parallelize(inputIntegers)
        val n = 100; 
  
        // loop for 100 times 
        for (i <- 1 to 100)                                  
        { 
            if ((i%5==0) && (i%3==0))    
            {                                           
                println("Fizz"+","+"Buzz"+" "+i)  
            }
            // number divisible by 5, print 'Buzz'  
            // in place of the number 
            else if (i%5==0) 
            {     
                println("Buzz"+" "+i)
            }
  
            // number divisible by 3, print 'Fizz'  
            // in place of the number 
            else if (i%3==0) 
            {    
                println("Fizz"+" "+i) 
            } 
  
            // number divisible by 15(divisible by 
            // both 3 & 5), print 'FizzBuzz' in  
            // place of the number 
                  
            else // print the numbers 
            {
                println(i+" ")   
            }                     
        } 

}

}


