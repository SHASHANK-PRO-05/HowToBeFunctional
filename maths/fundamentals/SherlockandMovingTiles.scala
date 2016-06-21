package maths.fundamentals
import io.StdIn._;
object SherlockandMovingTiles {
  def main(args: Array[String]): Unit = {
    var temp = readLine().split(" ").map { _.toDouble };
    val L = temp(0);
    var velocity = Math.abs(temp(2) - temp(1));
    var t = readInt();
    while (t != 0) {
      printf("%.4f\n", time(L, readDouble(), velocity));
      t = t - 1;
    }

  }
  def time(L: Double, area: Double, velocityDiff: Double): Double = {
    Math.sqrt(2) * (L - Math.sqrt(area)) / velocityDiff;
  }
}