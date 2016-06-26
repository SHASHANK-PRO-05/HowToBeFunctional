package maths.fundamentals

import io.StdIn._;
import scala.collection.mutable.HashMap

object JimandtheJokes {
  var accu: HashMap[Long, Long] = new HashMap[Long, Long];
  def main(args: Array[String]): Unit = {
    var n = readInt();
    for (i <- 1 to n) {
      var temp = readLine().split(" ").map { x => x.toInt };
      if (checkCorrectness(temp(0), temp(1))) {
        convertBase(temp(0), temp(1));
      }
    }
    var ans: Long = 0L;
    accu.foreach((x) => ans += (x._2 * (x._2 - 1) / 2));
    println(ans);
  }
  def convertBase(month: Int, date: Int): Unit = {
    var temp = date.toString();
    var base10 = 0;
    for (i <- 0 to temp.length() - 1) {
      base10 += ((temp(i) + "").toInt * Math.pow(month, temp.length() - i - 1).toInt);
    }
    accu += ((base10, accu.getOrElse(base10, 0L) + 1L));
  }
  def checkCorrectness(month: Int, date: Int): Boolean = {
    var temp: String = date.toString();
    for (i <- 0 to temp.length() - 1) {
      //println((temp(i) + "").toInt + " " + month);
      if ((temp(i) + "").toInt >= month)
        return false
    }
    true;
  }
}