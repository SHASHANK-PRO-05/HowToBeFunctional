package maths.fundamentals

import io.StdIn._;
object PossiblePath {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var temp = readLine().split(" ").map { _.toLong }
      if (gcd(temp(0), temp(1)) == gcd(temp(2), temp(3))) println("YES") else println("NO")
      t = t - 1;
    }
  }
  def gcd(a: Long, b: Long): Long = {
    if (b == 0) a else gcd(b, a % b)
  }
}