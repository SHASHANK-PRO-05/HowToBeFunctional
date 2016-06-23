
package maths.fundamentals

import io.StdIn._
object SherlockandDivisors {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      println(numberDiv(readLong()));
      t = t - 1;
    }
  }
  def numberDiv(n: Long): Long = {
    var ans = 0;
    for (i <- 2 to Math.sqrt(n).toInt) {
      if (n % i == 0 && i % 2 == 0) {
        ans = ans + 1;
        //println(i);
      }
      if ((n % (n / i) == 0) && (n / i) % 2 == 0 && i != n / i) {
        //println(n / i);
        ans = ans + 1;
      }
    }
    if (n % 2 == 0) {
      //println(n);
      ans = ans + 1;
    }
    ans;
  }
}