package maths.fundamentals

import io.StdIn._;
object MutualRecurrences {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var abcdArray = readLine().split(" ").map { x => x.toLong };
      var M: Array[Array[Long]] = Array();
      for (i <- 0 to 23) {
        var tempArray: Array[Long] = Array();
        for (j <- 0 to 23) {

          tempArray :+= 0L;
        }
        M :+= tempArray;
      }
      for (i <- 1 to 9) {
        M(i)(i - 1) = 1;
        M(10 + i)(10 + i - 1) = 1;
      }
      M(0)((abcdArray(0) - 1).toInt) += 1; M(0)((abcdArray(1) - 1 + 10).toInt) += 1; M(0)((abcdArray(2) - 1 + 10).toInt) += 1
      M(10)((abcdArray(4) + 10 - 1).toInt) += 1; M(10)((abcdArray(5) - 1).toInt) += 1; M(10)((abcdArray(6) - 1).toInt) += 1
      M(0)(20) = 1;
      M(10)(22) = 1;
      M(20)(20) = abcdArray(3);
      M(20)(21) = abcdArray(3);
      M(21)(21) = abcdArray(3);
      M(22)(22) = abcdArray(7);
      M(22)(23) = abcdArray(7);
      M(23)(23) = abcdArray(7);
      var v: Array[Array[Long]] = Array();
      for (i <- 1 to 24) {
        v :+= Array(1L);
      }
      v(20)(0) = 0L; v(21)(0) = 1L;
      v(22)(0) = 0L; v(23)(0) = 1L;
      v = powMod(abcdArray(8) + 1, M, v);
      //      for (i <- 0 to 23) {
      //
      //        for (j <- 0 to 23) {
      //
      //          print(M(i)(j) + " ");
      //        }
      //        println();
      //      }
      println(v(0)(0) + " " + v(10)(0));
      t = t - 1;
    }
  }
  val mod = 1000000000L;
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