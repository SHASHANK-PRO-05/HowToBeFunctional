package maths.NumberTheory

import io.StdIn._;
import java.io.PrintWriter

object EulersCriterion {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    //var pw = new PrintWriter("File.txt");
    while (t != 0) {
      var temp = readLine().split(" ").map(_.toLong);
      if (temp(0) == 0) {
        println("YES");
      } else if (gcd(temp(0), temp(1)) != 1 || temp(1) == 2) {
        println("NO");
      } else {
        var pow = (temp(1) - 1) / 2;
        if (advanceMul(temp(0), pow, temp(1)) == 1) {
          println("YES");
        } else {
          println("NO");
        }
      }

      t = t - 1;
    }
    //pw.flush();
    //pw.close();
  }
  def advanceMul(num: Long, e: Long, mod: Long): Long = {
    var res = 1L;
    var power = e;
    var mulThis = num;
    while (power != 0) {
      if (power % 2 != 0) {
        res = (res * mulThis) % mod;
      }
      mulThis = (mulThis * mulThis) % mod;
      power = power / 2;
    }
    res;
  }
  def gcd(a: Long, b: Long): Long = {
    if (b == 0) a else gcd(b, a % b);
  }
}