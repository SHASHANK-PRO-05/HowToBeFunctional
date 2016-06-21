package maths.fundamentals

import io.StdIn._;

object ConnectingTowns {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var n = readInt();
      var temp = readLine().split(" ").map { _.toLong };
      var ans: Long = 1;
      for (i <- 0 to n - 2) {
        ans = (ans * temp(i)) % 1234567;
      }
      println(ans);
      t = t - 1;
    }
  }
}