package maths.fundamentals

import io.StdIn._;
object MostDistant {
  def main(args: Array[String]): Unit = {
    var testCases = readLong();
    var maxX = 0L;
    var maxY = 0L;
    var minXX = 0L;
    var maxXX = 0L;
    var minXY = 0L;
    var maxXY = 0L;
    while (testCases != 0) {
      var temp = readLine().split(" ").map(_.toLong);
      maxX = Math.max(Math.abs(temp(0)), maxX);
      maxY = Math.max(Math.abs(temp(1)), maxY);
      if (temp(0) > maxXX) {
        maxXX = temp(0);
      }
      if (temp(0) < minXX) {
        minXX = temp(0);
      }
      if (temp(1) > maxXY) {
        maxXY = temp(1);
      }
      if (temp(1) < minXY) {
        minXY = temp(1);
      }
      testCases -= 1;
    }

    var ans = Math.sqrt(Math.pow(maxX, 2) + Math.pow(maxY, 2));
    ans = Math.max(ans.toDouble, Math.abs(maxXY - minXY).toDouble);
    ans = Math.max(ans.toDouble, Math.abs(maxXX - minXX).toDouble);
    printf("%.6f", (ans));
  }
}