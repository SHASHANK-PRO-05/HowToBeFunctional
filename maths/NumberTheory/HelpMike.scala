package maths.NumberTheory

import io.StdIn._;
object HelpMike {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var inputs = readLine().split(" ").map { x => x.toLong };
      var ans = 0L;
      var zeroLocation = (inputs(0) / inputs(1)).toLong;
      ans = ans + (zeroLocation * (zeroLocation - 1)) / 2;
     
      if ((inputs(1) & 1) != 0) {
        for (i <- 1L to ((inputs(1)) / 2L).toLong) {
          var tempStart = 1L + ((inputs(0) - i) / inputs(1)).toLong;
          var tempEnd = 1L + ((inputs(0) - (inputs(1) - i)) / inputs(1)).toLong;
          ans += (tempStart * tempEnd);
        }
      } else {
        for (i <- 1L to ((inputs(1)) / 2L).toLong - 1) {
          var tempStart = 1L + ((inputs(0) - i) / inputs(1)).toLong;
          var tempEnd = 1L + ((inputs(0) - (inputs(1) - i)) / inputs(1)).toLong;
          ans += (tempStart * tempEnd);
        }
        var middle = inputs(1) / 2;
        var tempStart = 1L + ((inputs(0) - middle) / inputs(1)).toLong; ;
        ans += (tempStart * (tempStart - 1)) / 2;
      }
      println(ans);
      t = t - 1;
    }
  }
}