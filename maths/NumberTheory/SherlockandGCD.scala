package maths.NumberTheory

import io.StdIn._;
object SherlockandGCD {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var n = readInt();
      var inputs = readLine().split(" ").map(_.toLong);
      var gcd = inputs(0);
      for (i <- 1 to n - 1) {
        gcd = gcdCal(gcd, inputs(i));
      }
    
      if (gcd == 1) {
        println("YES");
      } else {
        println("NO");
      }
      t = t - 1;
    }
  }
  def gcdCal(a: Long, b: Long): Long = {
    if (b == 0) a else gcdCal(b, a % b);
  }
}