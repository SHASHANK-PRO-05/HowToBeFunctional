package maths.NumberTheory

import io.StdIn._;
object JohnandGCDlist {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var n = readInt();
      var array = readLine().split(" ").map(_.toLong);
      array = array :+ 1L;
      print(array(0) + " ");
      for (i <- 1 to n) {
        print((array(i) * array(i - 1)) / gcdCal(array(i), array(i - 1)) + " ");
      }
      println();
      t = t - 1;
    }
  }
  def gcdCal(a: Long, b: Long): Long = {
    if (b == 0L) a else gcdCal(b, a % b);
  }
}