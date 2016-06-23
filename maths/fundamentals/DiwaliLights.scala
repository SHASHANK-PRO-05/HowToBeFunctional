package maths.fundamentals

import io.StdIn._;
object DiwaliLights {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var ans = advancePow(readLong());
      ans = (ans - 1);
      println(ans);
      t = t - 1;
    }
  }
  def advancePow(pow: Long): Long = {
    var ans: Long = 1;
    var temp: Long = 2;
    var p = pow;
    while (p != 0) {
      if (p % 2 != 0) {
        ans = (ans * temp) % 100000;
      }
      temp = (temp * temp) % 100000;
      p = p / 2;
    }
    ans;
  }
}