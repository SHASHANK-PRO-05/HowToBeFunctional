package maths.fundamentals

import io.StdIn._;
object ReverseGame {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var temp = readLine().split(" ").map { _.toLong };
      if (temp(1) >= temp(0) / 2) {
        println(0 + 2 * (temp(0) - 1 - temp(1)));
      } else {
        println(1 + 2 * (temp(1)))
      }
      t = t - 1;
    }
  }
}