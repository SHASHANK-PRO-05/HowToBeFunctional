package adInfi2016

import io.StdIn._;
object LeonardosPrimeFactors {
  def main(args: Array[String]): Unit = {
    var temp = Array(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 53L, 59L, 61L, 67L, 71L, 73L, 79L);
    var t = readInt();
    while (t != 0) {
      var ans = 0;
      var prod = 1L;
      var input = readLong();
      while (prod < input) {
        prod = prod * temp(ans);
        ans = ans + 1;

      }
      println(ans);
      t = t - 1;
    }

  }
}