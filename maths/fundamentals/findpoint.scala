package maths.fundamentals

import scala.io.StdIn._;
import scala.io.StdIn

object findpoint {
  def main(args: Array[String]): Unit = {
    var t = readLine().toInt;
    for (i <- 1 to t) {
      var temp = readLine().split(" ").map { _.toInt };
      temp(0) = temp(2) * 2 - temp(0);
      temp(1) = temp(3) * 2 - temp(1);
      println(temp(0) + " " + temp(1));
    }
  }
}
  
