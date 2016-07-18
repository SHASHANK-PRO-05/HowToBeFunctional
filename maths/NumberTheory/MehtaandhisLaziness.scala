package maths.NumberTheory

import io.StdIn._;
object MehtaandhisLaziness {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var array = answer(readLong());
      if (array(0) == 0) {
        println(0);
      } else {
        println(array(0) + "/" + array(1));
      }
      t = t - 1;
    }
  }
  def answer(a: Long): Array[Long] = {
    var array: Array[Long] = Array(0, 0);
    for (i <- 1L to Math.sqrt(a).toLong) {
      if (a % i == 0) {
        array(1) += 1;
        if (evenPerfectSquare(i)) {
          //println(i);
          array(0) += 1;
        }
        if (a / i != i && a / i != a && evenPerfectSquare(a / i)) {

          array(1) += 1;
          array(0) += 1;
        } else if (a / i != i && a / i != a) {
          array(1) += 1;
        }
      }
    }
    var gcdCal = gcd(array(0), array(1));
    //println(array(0), array(1));
    array(0) /= gcdCal;
    array(1) /= gcdCal;
    array;
  }
  def gcd(a: Long, b: Long): Long = {
    if (b == 0) a else gcd(b, a % b);
  }
  def evenPerfectSquare(a: Long): Boolean = {
    if (a % 2 != 0) {
      return false;
    }
    var num = Math.sqrt(a).toLong;
    if ((num * num).toLong == a) {
      return true;
    }
    false;
  }
}