package maths.fundamentals

import io.StdIn._;
object EvenOddQuery {
  def main(args: Array[String]): Unit = {
    var n = readInt();
    var arr = readLine().split(" ").map(_.toInt);
    var q = readInt();
    while (q != 0) {
      var temp = readLine().split(" ").map(_.toInt);
      if (arr(temp(0) - 1) % 2 == 0 && temp(0) >= temp(1)) {
        println("Even");
      } else if (arr(temp(0) - 1) % 2 == 0 && (temp(0) >= n || arr(temp(0)) != 0)) {
        println("Even");
      } else {
        println("Odd");
      }
      q = q - 1;
    }
  }
}