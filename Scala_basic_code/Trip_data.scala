

import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{AccumulableParam, AccumulatorParam, SparkConf, SparkContext}
import scala.collection.mutable
import java.util.Collections
import scala.collection.JavaConversions._


val dataset = sc.textFile("bigdatapgp/common_folder/assignment4/trip_dataset/trip_data.csv")
val header = dataset.first()


val eliminate = dataset.filter(line => line != header)
val split = eliminate.map(line => line.split(",")).map { x => (x(1),format.parse(x(3)),x(6)) }
val combine = split.map(x => (x._1.toInt+","+x._2+","+x._3)

val Durationlist = combine.map{x => x.split(',')}.map{x => (x._1.toDouble)}

//Max duration of a bike trip 

val max_duration = Durationlist.distinct.sortBy(x => x.toDouble, false, 1) print(max_duration.take(1).foreach(println))

val arrange = combine.reduceByKey(_+_).map(item => item.swap).sortByKey(false).collect.foreach(println)

// number of times zip_code is NULL using accumulators.

val blanklines = sc.AccumulatorV2(0, "Blank Lines")

sc.textFile("Some log lines", 4)
.foreach  { lines => 
        if (line.length() == 0 ) blanklines += 1

}

println(s"\tBlank Lines = ${blanklines.value}")


// find the number of rides for ’Subscriber’ 

class SubscriberAccumulator extends AccumulatorV2[String, java.util.Map[String, String]] {
    private val _map = Collections.synchronizedMap(new java.util.HashMap[String, String]())
    override def isZero: Boolean = _map.isEmpty
    override def copy(): AccumulatorV2[String, java.util.Map[String, String]] = {
      val newAcc = new SubscriberAccumulator()
      newAcc._map.putAll(_map)
      newAcc
    }
    override def reset(): Unit = _map.clear()
    override def add(v: String): Unit = {
      _map(v) = (if (_map.contains(v)) _map(v) else 0) + 1
    }
    override def merge(other: AccumulatorV2[String, java.util.Map[String, String]]): Unit = {
      other.value.foreach {
        case (key, count) =>
          _map(key) = (if (_map.contains(key)) _map(key) else 0) + count
      }

    }
    override def value: java.util.Map[String, String] = _map
  }





 def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Trip_Data").setMaster("local[4]")
    val sc = new SparkContext(conf)
     
     // find the number of rides for ’Subscriber’ 

     println("*** using a hash map accumulator")
    val SubscriberDetails = new SubscriberAccumulator
    sc.register(SubscriberDetails)
    SubscriberDetails.foreach(w => SubscriberDetails.add(w.charAt(9)))
    SubscriberDetails.value.foreach {
      case (initial, times) => println(times + " Trip data " + initial + "'")
    }

 }


