package maths.NumberTheory

import io.StdIn._;
object AkhilandGF {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var inputs = readLine().split(" ").map(_.toLong);
      println(divide(inputs(0), inputs(1)));
      t = t - 1;
    }
  }
  def powMod(a: Long, b: Long, m: Long): Long = {
    var ans = 1L;
    var mantisa = a;
    var pow = b;
    while (pow != 0) {
      if (pow % 2 == 1) {
        ans = (ans * mantisa) % m;
      }
      mantisa = (mantisa * mantisa) % m;
      pow = pow / 2;
    }
    ans;
  }
  def divide(n: Long, m: Long): Long = {
    if (n == 0)
      return 0;
    else if (n == 1)
      return 1L;
    else if (n == 2)
      return 11L % m;
    else if (n == 3)
      return 111L % m;
    else if (n == 4)
      return 1111L % m;
    else if (n == 5)
      return 11111L % m;
    else if (n == 6)
      return 111111L % m;
    else if (n % 2 == 0) {
      var firstHalf = divide(n / 2, m);
      var ans = ((firstHalf * powMod(10, n / 2, m)) % m + firstHalf) % m;
      return ans;
    } else {
      var firstHalf = divide(n / 2, m);
      var ans = ((firstHalf * powMod(10, n / 2 + 1, m)) % m + (firstHalf * 10 + 1) % m) % m;
      return ans;
    }
  }
}