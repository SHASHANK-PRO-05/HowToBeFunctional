package maths.NumberTheory

import io.StdIn._;
import java.io.PrintWriter

object Numberofzeroxorsubsets {
  def main(args: Array[String]): Unit = {
    var temp = new PrintWriter("hello");
    var t = readInt();
    var mod = 1000000007L;
    while (t != 0) {
      var n = readLong();
      var newPow = (powMod(2L, n, mod - 1) - n) % (mod - 1);
      newPow = (newPow + mod - 1) % (mod - 1);
      println(powMod(2L, newPow, mod))
      t = t - 1;
    }
    temp.flush()
    temp.close();
  }
  def powMod(mantisa: Long, pow: Long, mod: Long): Long = {
    var ans = 1L;
    var newMantisa = mantisa;
    var newPow = pow;
    while (newPow != 0) {
      if (newPow % 2 != 0) {
        ans = (ans * newMantisa) % mod;
      }
      newPow /= 2;
      newMantisa = (newMantisa * newMantisa) % mod;
    }
    ans;
  }
}