package maths.fundamentals

import io.StdIn._;

object MaximumDrawer {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var temp = readInt();
      temp = temp + 1;
      println(temp);
      t = t - 1;
    }
  }
}