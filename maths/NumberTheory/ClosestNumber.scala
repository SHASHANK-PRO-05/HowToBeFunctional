package maths.NumberTheory

import io.StdIn._;
object ClosestNumber {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var abx = readLine().split(" ").map(_.toLong);
      if (abx(1) < 0L && (abx(0) != 1L && abx(2) != 1L)) {
        println(0);
      } else if ((abx(0) == 1L && abx(2) == 1L)) {
        println(1);
      } else {
        var temp: Long = Math.pow(abx(0), abx(1)).toLong;
        var a1 = (temp / abx(2)).toLong;
        if (Math.abs(a1 * abx(2) - temp) < Math.abs((a1 + 1) * abx(2) - temp)) {
          println((a1 * abx(2)).toLong);
        } else {
          println(((a1 + 1) * abx(2)).toLong);
        }
      }
      t = t - 1;
    }
  }

}