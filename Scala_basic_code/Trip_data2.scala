

import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{AccumulableParam, AccumulatorParam, SparkConf, SparkContext}
import scala.collection.mutable
import java.util.Collections
import scala.collection.JavaConversions._
import java.util.*;
import java.io.*;


val dataset = sc.textFile("bigdatapgp/common_folder/assignment4/trip_dataset/trip_data.csv")
val header = dataset.first()


val eliminate = dataset.filter(line => line != header)
val split = eliminate.map(line => line.split(",")).map { x => (x(3),format.parse(x(9)),x(8)) }
//•	Read the Station dataset and create an RDD. Now print the number of bike stations in each city.

val combine = split.map(x => (x._3+","+x._9+","+x._8.toInt)

val Durationlist = combine.map{x => x.split(',')}.map{x => (x._1.toInt)}

//Max duration of a bike trip 

val max_duration = Durationlist.distinct.sortBy(x => x.toDouble, false, 1) print(max_duration.take(1).foreach(println))

val arrange = combine.reduceByKey(_+_).map(item => item.swap).sortByKey(false).collect.foreach(println)



//	Find the city with max number of bike rides.

object Demo {
  
      val dataset = sc.textFile("bigdatapgp/common_folder/assignment4/trip_dataset/station_data.csv")
      val it = Iterator(x._5+","+x._4)
      
      while (it.hasNext){
         println(it.next())
      
   }

    while (it.hasNext){
         val splitvalue = it.split(",");
         if(it[0].equalto("San Jose")) {
             println(it[1].next())
         }
      
   }
}



 def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Trip_Data2").setMaster("local[4]")
    val sc = new SparkContext(conf)

  

 }