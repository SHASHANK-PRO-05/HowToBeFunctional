package maths.NumberTheory

import io.StdIn._;
import java.io.PrintWriter

object SalaryBlues {
  def main(args: Array[String]): Unit = {
    
    var sizes = readLine().split(" ").map(_.toLong);
    var inputArray = readLine().split(" ").map(_.toLong);
    var min = inputArray.min;
    var actualGCD = 0L;
    for (i <- 0L to (sizes(0) - 1L)) {
      actualGCD = gcd(actualGCD, inputArray(i.toInt) - min);
    }
    while (sizes(1) != 0) {
      var k = readLong();
      var ans = gcd(actualGCD, min + k);
      println(ans);
      sizes(1) -= 1L;
    }
  }
  def gcd(a: Long, b: Long): Long = {
    if (b == 0) a else gcd(b, a % b);
  }
}