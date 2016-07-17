package maths.NumberTheory

import io.StdIn._;
object CheeseandRandomToppings {

  var primes = Array(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53);
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      var inputs = readLine().split(" ").map(_.toLong);
      var array: Array[ChineseVariables] = Array();
      for (i <- 0 to primes.length - 1) {
        if (inputs(2) % primes(i) == 0) {
          var newLucas = new LucasPrimes;
          newLucas.m1 = inputs(0);
          newLucas.m2 = inputs(1);
          newLucas.primeNum = primes(i);
          var newAns = newLucas.primeMod();
          var newChine = new ChineseVariables;
          newChine.a = newAns;
          newChine.mod = primes(i);
          array :+= newChine;
        }
      }
//      for (i <- 0 to array.length - 1) {
//        println(array(i).a + " " + array(i).mod);
//      }
      println(chineseRemainder(array));

      t = t - 1;
    }
  }
  def extendedGcd(a: Long, b: Long): Array[Long] = {
    var array: Array[Long] = Array();
    if (b == 0) {
      return Array(1, 0);
    } else {
      array = extendedGcd(b, a % b);
      return Array(array(1), array(0) - ((a / b).toLong * array(1)));
    }
  }
  def chineseRemainder(array: Array[ChineseVariables]): Long = {
    if (array.length == 1) {
      return array(0).a % array(0).mod;
    }
    var bigB = 1L;
    for (i <- 0 to array.length - 1) {
      bigB *= array(i).mod;
    }
    var ans = 0L;
    for (i <- 0 to array.length - 1) {
      ans += (array(i).a * (bigB / array(i).mod) * inverse(bigB / array(i).mod, array(i).mod));
      while (ans < 0)
        ans = (ans + bigB) % bigB;

      ans = (ans) % bigB

    }
    while (ans > bigB) {
      ans = ans % bigB;
    }
    ans;
  }
  def inverse(a: Long, b: Long): Long = {
    extendedGcd(a, b)(0) % b;
  }
}
class ChineseVariables {
  var a = 0L;
  var mod = 0L;
}
class LucasPrimes {
  var primeNum = 0L;
  var m1 = 0L;
  var m2 = 0L;
  var basePrimeM1: Array[Long] = Array();
  var basePrimeM2: Array[Long] = Array();
  def primeMod(): Long = {
    converBase();
    var ans = 1L;
    for (i <- 0 to basePrimeM1.length - 1) {
      //println(basePrimeM1(i) + " " + basePrimeM2(i) + " " + combination(basePrimeM1(i), basePrimeM2(i)) + "<--Comb");
      var comb = combination(basePrimeM1(i), basePrimeM2(i)).mod(primeNum).toLong;
      ans = (ans * comb) % primeNum;
    }
    ans;
  }
  def combination(a: Long, b: Long): BigInt = {
    var ans = 1L;
    var num1 = BigInt(1);
    for (i <- 1L to b) {
      num1 = num1 * (a - i + 1);
    }
    for (i <- 1L to b) {
      num1 = num1 / (i);
    }
    num1;
  }
  def converBase() = {
    var newM1 = m1;
    while (newM1 != 0) {
      basePrimeM1 :+= newM1 % primeNum;
      newM1 /= primeNum;
    }
    var newM2 = m2;
    while (newM2 != 0) {
      basePrimeM2 :+= newM2 % primeNum;
      newM2 /= primeNum;
    }
    while (basePrimeM2.length < basePrimeM1.length) {
      basePrimeM2 :+= 0L;
    }
  }
}