package maths.NumberTheory

import io.StdIn._;
object Poweroflargenumbers {
  var mod = 1000000007;
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var temp = readLine().split(" ").map(x => BigInt(x));
      println(powMod(temp(0), temp(1) % (mod - 1)));
      t = t - 1;
    }
  }
  def powMod(a: BigInt, pow: BigInt): BigInt = {
    var newPow = pow;
    var ans = BigInt(1);
    var mantisa = a;
    while (newPow != 0) {
      if (newPow % 2 != 0) {
        ans = (ans * mantisa) % mod;
      }
      mantisa = (mantisa * mantisa) % mod;
      newPow = newPow / 2;
    }
    ans;
  }
}