package maths.fundamentals

import io.StdIn._;
object DieHard3 {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var temp = readLine().split(" ").map(_.toInt);
      if (temp(2) < temp(1) || temp(2) < temp(0)) {
        if (temp(2) % gcd(temp(0), temp(1)) == 0) {
          println("YES");
        } else {
          println("NO");
        }
      } else {
        println("NO");
      }
      t = t - 1;
    }
  }
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b);
  }
}