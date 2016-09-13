package hackerearth.maths.primalityTest

import io.StdIn._
object millarRabin {
  def main(args: Array[String]): Unit = {
    var t = readInt();
    while (t != 0) {
      if (millarRabinPrimeTest(readLong())) {
        println("prime");
      } else {
        println("composite");
      }
      t = t - 1;
    }
  }
  def millarRabinPrimeTest(a: Long): Boolean = {
    if(a==2){
      return true;
    }
    if (a % 2 == 0L) {
      return false;
    }
    var r = 0L;
    var d: Long = a - 1;
    while (d % 2L == 0) {
      r = r + 1;
      d = d / 2;
    }
    var k = 100L;
    while (k != 0L) {
      var A = rand2ToNMinus2(a);

      var x = powMod(A, d, a);

      if (x != 1 && x != a - 1) {
        if (!checkIt(x, a, r)) {
          return false;
        }
      }
      k = k - 1;
    }
    return true;
  }
  def checkIt(x: Long, a: Long, iter: Long): Boolean = {
    var tempX: Long = x;
    for (i <- 0L to iter - 1) {
      tempX = powMod(tempX, 2, a);

      if (tempX == 1) {
        return false;
      } else if (tempX == a - 1) {
        return true;
      }
    }
    return false;
  }
  def rand2ToNMinus2(a: Long): Long = {
    //var temp: Long = (a);
    Math.sqrt(a).toLong;
  }
  def powMod(a: Long, pow: Long, mod: Long): Long = {
    var mantisa = BigInt(a);
    var exp = pow;
    var ans = BigInt(1);
    while (exp != 0) {
      if (exp % 2 != 0) {
        ans = (ans * mantisa) % mod;

      }

      mantisa = (mantisa * mantisa) % mod;

      exp /= 2L;
    }
    ans.toLong;
  }
}