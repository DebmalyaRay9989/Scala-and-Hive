/* SimpleApp.scala */
// Given an input text file- macbeth.txt present at the location: hdfs:///bigdatapgp/common_folder/assignment4/text_dataset/macbeth.txt

//val rddFromFile = spark.sparkContext.textFile("hdfs://nn1home:8020/text01.txt")
//val rddWhole = spark.sparkContext.wholeTextFiles("hdfs://nn1home:8020/text01.txt")    nameservice1


import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf


object SimpleApp {
  def main(args: Array[String]) {

    val logFile = "hdfs://nameservice1/bigdatapgp/common_folder/assignment4/text_dataset/macbeth.txt" // Should be some file on your system
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
	//val words = logData.flatMap(word => word.split(",")
	//val wCount = words.map(words => (words,1)) 
     val wordCounts = logData.flatMap(line => line.split(",")).map(word => (word, 1)).reduceByKey((a, b) => a + b)	
    val numAs = logData.filter(line => line.contains("a")).count()
    val numEs = logData.filter(line => line.contains("e")).count()
	val numIs = logData.filter(line => line.contains("i")).count()
	val numOs = logData.filter(line => line.contains("o")).count()
	val numUs = logData.filter(line => line.contains("u")).count()
	//val result = wCount.reduceByKey((x,y) => x+y)
    println("Lines with a: %s, e: %s, i: %s, o: %s,  u: %s".format(numAs, numEs, numIs, numOs, numUs))
 	wordCounts.collect().foreach(println)

  }
}


