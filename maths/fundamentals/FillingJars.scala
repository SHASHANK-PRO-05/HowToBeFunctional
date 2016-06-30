package maths.fundamentals

import io.StdIn._;
object FillingJars {
  def main(args: Array[String]): Unit = {
    var temp = readLine().split(" ").map(_.toLong);
    var ans: Long = 0;
    for (i <- 1L to temp(1)) {
      var task = readLine().split(" ").map(_.toLong);
      ans += ((task(1) - task(0) + 1) * task(2));
    }
    println((ans / temp(0)).toLong);
  }
}