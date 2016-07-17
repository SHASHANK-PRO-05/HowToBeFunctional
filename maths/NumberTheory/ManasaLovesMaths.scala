package maths.NumberTheory

import io.StdIn._;
object ManasaLovesMaths {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var string = readLine();
      var ans = false;
      if (string.length() >= 3) {
        var digitArray: Array[Int] = Array();
        for (i <- 0 to 9)
          digitArray :+= 0;
        for (i <- 0 to string.length() - 1) {
          digitArray(string(i) - '0') = digitArray(string(i) - '0') + 1;
        }

        for (i <- 0 to digitArray.length - 1) {
          if (digitArray(i) != 0) {
            digitArray(i) = digitArray(i) - 1;
            if (calculate(digitArray, "" + i)) {
              ans = true;
            }
            digitArray(i) = digitArray(i) + 1;
          }
        }
      } else {
        if (string.length() == 1) {
          if (string.toInt % 8 == 0) {
            ans = true;
          }
        } else {
          if (string.reverse.toInt % 8 == 0 || string.toInt % 8 == 0) {
            ans = true;
          }
        }
      }
      if (ans) {
        println("YES");
      } else {
        println("NO");
      }
      t = t - 1;
    }
  }

  def calculate(digitArray: Array[Int], num: String): Boolean = {

    if (num.length() == 3)
      if (num.toInt % 8 == 0) {

        return true;
      } else
        return false;
    var ans = false;
    for (i <- 0 to digitArray.length - 1) {
      if (digitArray(i) != 0) {
        digitArray(i) = digitArray(i) - 1;
        if (calculate(digitArray, num + i)) {
          return true;
        }
        digitArray(i) = digitArray(i) + 1;
      }
    }
    false;
  }
}