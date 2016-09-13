package maths.NumberTheory

import io.StdIn._;
object LargestNonCoprimeSubmatrix {
  def main(args: Array[String]): Unit = {
    var inputs = readLine().split(" ").map { x => x.toInt };
    var matrix: Array[Array[Long]] = Array();
    for (i <- 0 to inputs(0) - 1) {
      matrix = matrix :+ readLine().split(" ").map(_.toLong);
    }
    var dp = Array.ofDim[Long](inputs(0), inputs(0), inputs(1));
    for (i <- 0 to inputs(0) - 1) {
      var gArr = Array.ofDim[Long](inputs(1));
      for (k <- 0 to inputs(1) - 1) {
        gArr(k) = matrix(i)(k);
      }
      for (j <- i to inputs(0) - 1) {
        for (k <- 0 to inputs(1) - 1) {
          gArr(k) = gcd(gArr(k), matrix(j)(k));
        }
        for (k <- 0 to inputs(1) - 1) {
          var temp = j - i + 1;
          var gc = gArr(k);
          var lastM = k + 1;
          var ans = 0;
          if (gc != 1) {
            ans = 1;
          }
          while (lastM < inputs(1)) {
            gc = gcd(gc, gArr(lastM));
            lastM = lastM + 1;
            if (gc != 1) {
              ans = ans + 1;
            } else {

            }
          }
          ans = ans * temp;
          dp(i)(j)(k) = ans;
        }
      }
    }
    var ans = 0L;
    for (i <- 0 to inputs(0) - 1) {
      for (j <- 0 to inputs(0) - 1) {
        for (k <- 0 to inputs(1) - 1) {
          ans = Math.max(ans, dp(i)(j)(k));
        }
      }
    }
    println(ans);
  }
  def gcd(a: Long, b: Long): Long = {
    if (b == 0) a else gcd(b, a % b);
  }
}