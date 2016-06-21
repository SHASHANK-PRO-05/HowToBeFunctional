package maths.fundamentals

import io.StdIn._;
object Restaurant {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var temp = readLine().split(" ").map { _.toInt };
      var gc = gcd(temp(0), temp(1))
      println((temp(0) * temp(1)) / (gc * gc));
      t = t - 1;
    }
  }
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }
}