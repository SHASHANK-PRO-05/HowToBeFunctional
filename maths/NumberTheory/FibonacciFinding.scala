package maths.NumberTheory

import io.StdIn._;
object FibonacciFinding {
  var mod = 1000000007;
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var temp = readLine().split(" ").map(_.toLong);
      if (temp(2) == 1L) {
        println(temp(1));
      } else {
        var returnArray = powMod(temp(2) - 1, Array(Array(1, 1), Array(1, 0)), Array(Array(temp(1)), Array(temp(0))));
        println(returnArray(0)(0));
      }
      t = t - 1;
    }
  }
  def matrixMultiply(M1: Array[Array[Long]], M2: Array[Array[Long]]): Array[Array[Long]] = {
    var size1 = M1.size;
    var size2 = M1(0).size;
    var size3 = M2(0).size
    var returnArray: Array[Array[Long]] = Array();
    for (i <- 0 to size1 - 1) {
      var tempArr: Array[Long] = Array();
      for (j <- 0 to size3 - 1) {
        tempArr :+= 0L;
      }
      returnArray :+= tempArr;
    }
    for (i <- 0 to size1 - 1) {
      for (k <- 0 to size2 - 1) {
        for (j <- 0 to size3 - 1) {
          returnArray(i)(j) = (returnArray(i)(j) + (M1(i)(k) * M2(k)(j)) % mod) % mod;
        }
      }
    }
    returnArray;
  }
  def powMod(m: Long, M: Array[Array[Long]], v: Array[Array[Long]]): Array[Array[Long]] = {
    var exponential = m;
    var Matrix = M;
    var result = v;
    while (exponential != 0) {
      if (exponential % 2 != 0) {
        result = matrixMultiply(Matrix, result);
      }
      Matrix = matrixMultiply(Matrix, Matrix);
      exponential = exponential / 2;
    }
    result;
  }
}