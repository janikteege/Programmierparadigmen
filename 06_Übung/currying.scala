// Zusammenarbeit von Janik Teege & Nele Hüsemann

// 1.
def concatThree(s1: String)(s2: String)(s3: String): String = {
    s1 + s2 + s3
}

// 2.
def prefix(): (String, String) => String = {
    (pre, txt) => concatThree(pre)(txt)("")
}
def postfix(): (String, String) => String = {
    (txt, post) => concatThree("")(txt)(post)
}
def preAndPostFix(): String => String = {
    txt => concatThree(">>>")(txt)("<<<")
}

object Currying {
    def main(args: Array[String]): Unit = {
        val concatResult = concatThree("Hello")(" ")("World")
        println(concatResult)

        val prefixResult = prefix()(">", "Hello")
        println(prefixResult)

        val postfixResult = postfix()("World","<")
        println(postfixResult)

        val preAndPostFixResult = preAndPostFix()("Hello World")
        println(preAndPostFixResult)
    }
}
