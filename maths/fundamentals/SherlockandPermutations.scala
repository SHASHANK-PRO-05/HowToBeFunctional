package maths.fundamentals

import io.StdIn._;
object SherlockandPermutations {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var temp = readLine().split(" ").map(_.toLong);
      var top = fact((((temp(0) + temp(1)) % 1000000007) + 1000000007 - 1) % 1000000007)
      var bottom = (fact(temp(0)) * fact(temp(1) - 1)) % 1000000007;
      bottom = (inverse(bottom) * top) % 1000000007;
      println(bottom);
      t = t - 1;
    }
  }
  def fact(num: Long): Long = {
    var ans: Long = 1;
    var sub: Long = num;
    while (sub != 0) {
      ans = (ans * sub) % 1000000007;
      sub = sub - 1;
    }
    ans;
  }
  def inverse(mantisa: Long): Long = {
    var temp: Long = mantisa;
    var exp: Long = 1000000005;
    var ans: Long = 1;
    while (exp != 0) {
      if (exp % 2 != 0) {
        ans = (ans * temp) % 1000000007;
      }
      temp = (temp * temp) % 1000000007;
      exp = exp / 2;
    }
    ans;
  }
}