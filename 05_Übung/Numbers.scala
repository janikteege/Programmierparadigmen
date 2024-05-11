//Zusammenarbeit von Janik Teege und Nele Hüsemann

object Numbers {
  
    def relativePrimes(n: Int): Vector[Int] = {
        (1 to n).filter(gcd(n, _) == 1).toVector
    }

    def gcd(a: Int, b: Int): Int = {
        if (b == 0) a
        else gcd(b, a % b)
    }
    
    def main(args:Array[String]) = {
        println(gcd(10, 15))
        println(relativePrimes(10))
    }  
}