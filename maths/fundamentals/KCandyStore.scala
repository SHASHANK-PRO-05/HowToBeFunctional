package maths.fundamentals

import io.StdIn._;
object KCandyStore {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var n = readInt();
      var k = readInt();
      println(combRep(n, k));
      t = t - 1;
    }
  }
  def combRep(n: Int, k: Int): Long = {
    var top = BigInt(1);
    for (i <- 1 to (n + k - 1)) {
      top = top * BigInt(i);
    }
    for (i <- 1 to (n - 1)) {
      top = top / i;
    }
    for (i <- 1 to (k)) {
      top = top / i;
    }
    top.mod(1000000000).toLong;
  }
}