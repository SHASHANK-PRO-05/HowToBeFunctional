package maths.fundamentals

import io.StdIn._;
object RussianPeasantExponentiation {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var inputs = readLine().split(" ").map { x => x.toLong };
      inputs = powMod(Array(inputs(0), inputs(1)), inputs(2), inputs(3));
      println(inputs(0) + " " + inputs(1));
      t = t - 1;
    }
  }
  def powMod(inputs: Array[Long], pow: Long, mod: Long): Array[Long] = {
    var newPow = pow;
    var initialArray = Array(1L, 0L);
    var newArray = Array(inputs(0), inputs(1));
    while (newPow != 0L) {
      if (newPow % 2L != 0L) {
        initialArray = multiplyComplex(initialArray, newArray, mod);
      }
      newArray = multiplyComplex(newArray, newArray, mod);
      newPow /= 2L;
    }
    initialArray;
  }
  def multiplyComplex(a: Array[Long], b: Array[Long], mod: Long): Array[Long] = {
    Array(((((a(0) * b(0)) % mod) - ((a(1) * b(1)) % mod)) + mod) % mod, (((a(0) * b(1)) % mod) + ((a(1) * b(0)) % mod)) % mod);
  }
}