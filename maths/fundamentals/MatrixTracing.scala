package maths.fundamentals

import io.StdIn._;
object MatrixTracing {
  val mod = 1000000007;
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var temp = readLine().split(" ").map(_.toLong);
      var top = factMod(temp(0) + temp(1) - 2);
      var bottom = powMod((factMod(temp(0) - 1) * factMod(temp(1) - 1)) % mod);
      println((top * bottom) % mod);
      t = t - 1;
    }
  }
  def factMod(num: Long): Long = {
    var ans: Long = 1;
    for (i <- 1L to num) {
      ans = (ans * i) % mod
    }
    ans;
  }
  def powMod(mantisa: Long): Long = {
    var ans: Long = 1;
    var pow = 1000000005;
    var temp = mantisa;
    while (pow != 0) {
      if (pow % 2 != 0) {
        ans = (ans * temp) % mod;
      }
      temp = (temp * temp) % mod;
      pow = pow / 2;
    }
    ans;
  }
}