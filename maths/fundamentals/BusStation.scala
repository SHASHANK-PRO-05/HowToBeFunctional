package maths.fundamentals

import io.StdIn._;

object BusStation {
  def main(args: Array[String]): Unit = {
    var n = readInt();
    var arr = readLine().split(" ").map(_.toLong);

    arr = sumArray(arr);
    var factors = factorsList(arr(arr.length - 1));
    for (i <- 0 to factors.length - 1) {
      if (isIt(factors(i), arr)) {
        print(factors(i) + " ");
      }
    }
  }
  def isIt(num: Long, arr: Array[Long]): Boolean = {
    for (i <- 1L to arr(arr.length - 1) / num) {
      if (!containsElemBsearch(arr, num * i))
        return false;
    }
    true;
  }
  def containsElemBsearch(arr: Array[Long], elem: Long): Boolean = {
    var start = 0;
    var end = arr.length - 1;
    while (start <= end) {
      var mid = (start + end) / 2;
      if (arr(mid) == elem)
        return true;
      else if (arr(mid) > elem) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    false;
  }
  def factorsList(num: Long): Array[Long] = {
    var arr = Array(): Array[Long];
    for (i <- 1L to Math.sqrt(num).toLong) {
      if (num % i == 0) {
        arr :+= i;
      }
      if (num % i == 0 && num / i != i) {
        arr :+= num / i;
      }
    }
    arr.sorted;
  }
  def sumArray(arr: Array[Long]): Array[Long] = {
    for (i <- 1 to arr.length - 1) {
      arr(i) = arr(i) + arr(i - 1);
    }
    arr;
  }
}