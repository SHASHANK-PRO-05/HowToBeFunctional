package maths.fundamentals

import io.StdIn._;
object SumarandtheFloatingRocks {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var temp = readLine().split(" ").map { x => x.toLong };
      var denom = Math.abs(temp(0) - temp(2));
      var numon = Math.abs(temp(1) - temp(3));
      denom = denom / gcd(numon, denom);
      if (denom != 0)
        println((Math.abs(temp(0) - temp(2)) / denom).toLong - 1);
      else
        println(Math.abs(temp(1) - temp(3)) - 1);
      t = t - 1;
    }
  }
  def gcd(a: Long, b: Long): Long = {
    if (b == 0) a else gcd(b, a % b);
  }
}
