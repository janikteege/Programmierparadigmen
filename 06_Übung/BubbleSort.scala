// Zusammenarbeit von Janik Teege & Nele Hüsemann

def swap(arr : Array[Int], index1 : Int, index2 : Int): Unit = {
    val temp = arr(index1)
    arr(index1) = arr(index2)
    arr(index2) = temp
}

def bubbleSort(arr : Array[Int], alreadySorted: Int = 0, current: Int = 0): Array[Int] = {
    if (alreadySorted == arr.length) {
        return arr
    } else if (arr.length - alreadySorted - 1 == current) {
        bubbleSort(arr, alreadySorted + 1, 0)
    } else {
        if (arr(current) > arr(current+1)) {
            swap(arr, current, current+1)
        }
        bubbleSort(arr, alreadySorted, current+1)
    }
}

@main
def main() = {
    val arr1 = Array(5, 3, 2, 4, 1)
    val sortedArr1 = bubbleSort(arr1)
    println(sortedArr1.mkString(", "))

    val arr2 = Array(10)
    val sortedArr2 = bubbleSort(arr2)
    println(sortedArr2.mkString(", "))

    val arr3 = Array(2, 2, 3, 3, 1, 2)
    val sortedArr3 = bubbleSort(arr3)
    println(sortedArr3.mkString(", "))

    val arr4 = Array[Int]()
    val sortedArr4 = bubbleSort(arr4)
    println(sortedArr4.mkString(", "))
}
