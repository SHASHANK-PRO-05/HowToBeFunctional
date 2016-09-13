package maths.NumberTheory

import io.StdIn._;
object DancinginPairs {
  def main(args: Array[String]): Unit = {
    
    var t = readInt();
    while (t != 0) {
      var sqrtNum = floorSqrt(readLong()).toLong;
      if (sqrtNum % 2L == 1) {
        println("odd");
      } else {
        println("even");
      }
      t = t - 1;
    }
  }
  def floorSqrt(a: Long): Long = {
    var ans = 1L;
    var start = 1L;
    var end = 1000000000L;

    while (end - start >= 2) {
      var mid = (start + end) / 2;

      if (mid * mid > a) {
        end = mid;
      } else {
        ans = mid;
        start = mid;
      }
    }
    ans;
  }
}