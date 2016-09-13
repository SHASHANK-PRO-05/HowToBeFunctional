package hackerearth.maths.primalityTest

object SaveGirlfriend {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var inputs = readLine().split(" ").map(_.toLong);
      calculate(inputs(0), inputs(1));
      t = t - 1;
    }
  }
  def calculate(a: Long, b: Long): Unit = {
    var len = b - a + 1;
    var ans = Array.fill(len.toInt)(0L);
    var loopIndex = giveLeast(b);
    for (i <- 2L to loopIndex) {
      var index = a / i;
      var j = index * i;
      while (b >= j) {
        if (j > i && j > a) {
          ans((j - a).toInt) += 1L;
          //          if (j / i > i) {
          //            ans((j - a).toInt) += 1L;
          //          }
        }
        j = j + i;
      }
    }
    var stringMax = 1;
    var max = ans(0);
    for (i <- 1L to b - a) {
      if (max < ans(i.toInt)) {
        max = ans(i.toInt);
        stringMax = 1;
      } else if (max == ans(i.toInt)) {
        stringMax += 1;
      }
    }
    println((stringMax + 1));
    //    for (i <- 0L to b - a) {
    //      println(ans(i.toInt) + " " + (a + i));
    //    }
  }
  def giveLeast(a: Long): Long = {
    //Math.sqrt(a / 2).toLong + 1;
    a / 2;
  }
}