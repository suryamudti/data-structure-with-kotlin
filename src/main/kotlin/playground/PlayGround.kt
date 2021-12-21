package playground

fun main() {
//    print(canConstruct("aab", "baa"))
//    println(reverseStr("abcdefg", 2))

    println(testArray(intArrayOf(1,2,3,4,5,6,7), 3).toList())

//    println(firstUniqChar("loveleetcode"))
//    println("loveleetcode".contains('a'))
}

fun firstUniqChar(s: String): Int {
    s.forEachIndexed { idx, char ->
        if (s.filter { it == char }.length == 1) {
            return idx
        }
    }
    return -1
}

fun testArray(arr: IntArray, k: Int): IntArray {
    val dropped = arr.drop(k)
    println(dropped.toList())
    val taken = arr.take(k)
    println(taken.toList())
    return ( dropped + taken ).toIntArray()
}


fun reverseStr(s: String, k: Int): String {
    var isReverseChunk = true
    val chunked = s.chunked(k)
    val reversed = chunked
        .joinToString("") {
            val result = if (isReverseChunk) it.reversed() else it
            isReverseChunk = !isReverseChunk
            result
        }
    return reversed
}


fun canConstruct(ransomNote: String, magazine: String): Boolean {
    return magazine.toList().sorted().toString().contains(ransomNote.toList().sorted().toString())
}



fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): IntArray {
    val sorted = (nums1.take(m) + nums2.take(n)).sorted()
    println(sorted)
    return sorted.toIntArray()
}

fun wordPattern(pattern: String, s: String): Boolean {
    val splittedWord = s.split(" ")
    if (splittedWord.isEmpty() || pattern.isEmpty()) return false
    if (splittedWord.size != pattern.length) return false

    val collectedPattern = mutableMapOf<Char, String>()
    pattern.forEachIndexed { index, item ->
        if (collectedPattern.keys.contains(item)) {
            if (collectedPattern[item] != splittedWord[index]) {
                return false
            }
        } else {
            collectedPattern[item] = splittedWord[index]
        }
    }

    return true
}