package maths.fundamentals

import io.StdIn._;
object Handshake {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      println(handshake(readLong()));
      t = t - 1;
    }
  }
  def handshake(n: Long): Long = {
    n * (n - 1) / 2
  }
}