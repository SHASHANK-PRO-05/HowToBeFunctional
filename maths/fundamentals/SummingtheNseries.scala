package maths.fundamentals

import io.StdIn._;
object SummingtheNseries {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      val n = readLong() % 1000000007;
      println((n * n) % (1000000007));
      t = t - 1;
    }
  }
}