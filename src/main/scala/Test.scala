import org.apache.spark.{SparkConf, SparkContext}

object Test {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[2]").setAppName("Test").set("executor-memory", "1g")
    val sc = new SparkContext(conf);

    val rdd = sc.textFile("/Users/wangguangzhi/Documents/zhaopin/doc/推荐/投后/0421-三排对二排提权实验/mismatch.csv")

    println(rdd.count)

  }

}
