package maths.fundamentals

import io.StdIn._;
object SpecialMultiple {
  var arr: Array[Long] = Array();
  def main(args: Array[String]): Unit = {
    makeNum("9", 1);
    arr = arr.sorted;
    var t = readInt();
    while (t != 0) {
      println(ans(readLong));
      t = t - 1;
    }
  }
  def ans(temp: Long): Long = {
    for (i <- 0 to arr.length - 1) {
      if (arr(i) % temp == 0) {
        return arr(i);
      }
    }
    return 0L;
  }
  def makeNum(num: String, len: Int): Unit = {
    if (len > 15)
      return ;
    arr = arr :+ num.toLong;
    makeNum(num + "0", num.length() + 1);
    makeNum(num + "9", num.length() + 1);
  }
 
}