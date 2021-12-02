fun List<Int>.findSumOfBy(sum: Int): Boolean {
    forEach { first ->
        forEach { second ->
            if (first + second == sum)
                return true
        }
    }
    return false
}

fun main() {


}