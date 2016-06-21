package maths.fundamentals
import io.StdIn._;
object StrangeGridAgain {
  def main(args: Array[String]): Unit = {
    var input = readLine().split(" ").map(_.toLong);
    if (input(0) % 2 == 0) {
      println(1 + 2 * ((input(0) / 2 - 1) * 5 + input(1) - 1))
    } else {
      println(0 + 2 * ((input(0) / 2) * 5 + input(1) - 1))
    }
  }
}