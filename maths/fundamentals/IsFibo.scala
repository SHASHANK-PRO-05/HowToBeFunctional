package maths.fundamentals

import io.StdIn._;
import scala.collection.mutable.HashMap

object IsFibo {
  var mapy: HashMap[Long, Boolean] = new HashMap

  def main(args: Array[String]): Unit = {
    var t = readInt();
    mapy += (0L -> true)
    mapy += (1L -> true);
    pre(1, 0);
    while (t != 0) {
      if (mapy.contains(readLong())) {
        println("IsFibo");
      } else
        println("IsNotFibo");
      t = t - 1;
    }
  }
  def pre(a: Long, b: Long): Unit = {
    var temp = a + b;
    if (temp > 100000000001L) {
      return ;
    }
    mapy += (temp -> true);
    pre(temp, a);
  }
}