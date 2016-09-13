package hackerearth.maths.primalityTest

import io.StdIn._;
object LittleJhoolandhisPrimes {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var inputs = readLine().split(" ").map(_.toLong);
      var prime = readLong();
      if (inputs(0) % prime == 0) {
        println(0);
      } else if (inputs(1) % prime == 0) {
        println(-1);
      } else {
        inputs(0) %= prime;
        inputs(1) %= prime;
        inputs(0) = (prime - (inputs(0) % prime)) % prime;
        var ans = (inputs(0) * powMod(inputs(1), prime - 2, prime)) % prime;
        println(ans);
      }
      t = t - 1;
    }

  }
  def powMod(a: Long, b: Long, mod: Long): Long = {
    var mantisa = a;
    var exp = b;
    var ans = 1L;
    while (exp != 0) {
      if (exp % 2L != 0) {
        ans = (ans * mantisa) % mod;
      }
      mantisa = (mantisa * mantisa) % mod;
      exp /= 2;
    }
    ans;
  }
  def gcd(a: Long, b: Long): Long = {
    if (b == 0L) a else gcd(b, a % b);
  }
}