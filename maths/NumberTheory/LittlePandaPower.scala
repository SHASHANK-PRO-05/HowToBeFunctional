package maths.NumberTheory

import io.StdIn._;
import scala.collection.mutable.Map

object LittlePandaPower {

  var prime: Array[Long] = Array();
  var array: Array[Boolean] = Array();
  def main(args: Array[String]): Unit = {

    array :+= true;
    for (i <- 1 to 1000) {
      array :+= true;
    }
    for (i <- 2 to 1000) {
      if (array(i)) {
        prime :+= i.toLong;
        var j = i * i;
        while (j <= 1000) {
          array(j) = false;
          j = j + i;
        }
      }
    }
    var t = readInt();
    //    println(phi(202023));
    while (t != 0) {
      var abx = readLine().split(" ").map(_.toLong);
      if (abx(1) >= 0L) {
        println(powMod(abx(0), abx(1), abx(2)));
      } else {
        println(powMod(powMod(abx(0), phi(abx(2)).toLong
          - 1, abx(2)), Math.abs(abx(1)).toLong, abx(2)))
      }
      t = t - 1;
    }
  }
  def phi(a: Double): Double = {
    var newNum = a;
    var res = a;
    for (i <- 0 to prime.length - 1) {
      if (newNum % prime(i) == 0) {
        while (newNum % prime(i) == 0) {
          newNum /= prime(i);
        }
        res *= (1D - (1D / prime(i)));
      }
    }
    if (newNum != 1) {
      res *= (1D - (1D / newNum));
    }
    res;
  }
  def powMod(a: Long, b: Long, mod: Long): Long = {
    var res = 1L;
    var mantisa = a;
    var pow = b;
    while (pow != 0) {
      if ((pow & 1) != 0) {
        res = (res * mantisa) % mod;
      }
      mantisa = (mantisa * mantisa) % mod;
      pow = pow / 2;
    }
    res;
  }
}