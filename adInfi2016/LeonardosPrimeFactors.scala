package adInfi2016

import io.StdIn._;
object LeonardosPrimeFactors {
  def main(args: Array[String]): Unit = {
    var primeAr:Array[Long]=new Array[Long](1000000000);
    for(i<-2 to 32000){
      if(primeAr(i)==0){
        primeAr(i)=1;
        var j=i*2;
        while(j<=32000){
          primeAr(j)=primeAr(j)+1;
          j=j+i;
        }
      }
    }
    var max=primeAr(1);
    for(i<-1 to 32000 ){
     max=Math.max(max, primeAr(i));
     primeAr(i)=max;
    }
    print();
  }
}