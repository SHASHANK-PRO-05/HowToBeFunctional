package randomMaths

import io.StdIn._;

object FibonacciFinding {
  var mod = 1000000007;
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var temp = readLine().split(" ").map(_.toLong);
      var matrix = modPowMatrix(temp(2));
      //matrix.foreach((x) => println(x));
      var ans = ((matrix(1)(0) * temp(1)) % mod + (matrix(1)(1) * temp(0)) % mod) % mod;
      println(ans);
      t = t - 1;
    }
  }
  def modPowMatrix(n: Long): Array[Array[Long]] = {
    var temp = Array(Array(1L, 1L), Array(1L, 0L));
    var newArray = Array(Array(1L, 0L), Array(0L, 1L));
    var newN = n;
    while (newN != 0) {
      if (newN % 2 != 0) {

        newArray = matrixMultiply(newArray, temp);
      }
      temp = matrixMultiply(temp, temp);
      newN = newN / 2;

    }

    newArray;
  }
  def matrixMultiply(x: Array[Array[Long]], y: Array[Array[Long]]): Array[Array[Long]] = {
    var temp = Array(Array(((x(0)(0) * y(0)(0)) % mod + (x(0)(1) * y(1)(0)) % mod) % mod, ((x(0)(0) * y(0)(1)) % mod + (x(0)(1) * y(1)(1)) % mod) % mod),
      Array(((x(1)(0) * y(0)(0)) % mod + (x(1)(1) * y(1)(0)) % mod) % mod, ((x(1)(0) * y(0)(1)) % mod + (x(1)(1) * y(1)(1)) % mod) % mod));
    temp;
  }
}