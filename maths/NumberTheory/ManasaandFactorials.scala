package maths.NumberTheory

import io.StdIn._;
object ManasaandFactorials {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      println(calculate(readLong()));
      t = t - 1;
    }
  }
  def calculate(a: Long): Long = {
    var start = 5L;
    var ans = 0L;
    var end = 100000000000000000L;
    while (start <= end) {
      var mid = (start + end) / 2;
      if (findZeros(mid) >= a) {
        ans = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    ans;
  }
  def findZeros(a: Long): Long = {
    var newNum = a;
    var temp = 0L;
    while (newNum != 0) {
      temp += (newNum / 5);
      newNum /= 5;
    }
    temp;
  }
}