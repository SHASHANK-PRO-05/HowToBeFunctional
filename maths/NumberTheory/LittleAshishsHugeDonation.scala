package maths.NumberTheory

import io.StdIn._;
object LittleAshishsHugeDonation {

  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      println(bSearch(readLong()));
      t = t - 1;
    }
  }

  def bSearch(num: Long): Long = {
    var start = 1L;
    var end = 2000000L;
    var ans = 0L;
    while (start <= end) {
      var mid: Long = (start + end) / 2;
      if (calSeq(mid) <= num) {
        
        ans = mid;
        start = mid + 1L;
      } else {
        end = mid - 1L;
      }
    }
    ans;
  }
  def calSeq(a: Long): Long = {
   
    a.toLong * (a + 1).toLong * (2 * a + 1).toLong / 6.toLong
  }
}