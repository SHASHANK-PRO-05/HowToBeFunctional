package maths.fundamentals

import io.StdIn._;

object HalloweenParty {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var k = readLong();
      if (k % 2 == 0) {
        println(k / 2 * k / 2);
      } else {
        println(k / 2 * (k + 1) / 2);
      }
      t = t - 1;
    }
  }
}