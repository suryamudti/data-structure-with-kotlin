package playground

import java.util.*

fun main() {
//    print(canConstruct("aab", "baa"))
//    println(reverseStr("abcdefg", 2))

//    println(testArray(intArrayOf(1,2,3,4,5,6,7), 3).toList())

//    println(firstUniqChar("loveleetcode"))
//    println("loveleetcode".contains('a'))
//    println(intersect(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4)).toList())
    val list = listOf(10, 8, 18, 45, 63, 49, 88, 15, 62)
    val linkedList = LinkedList<Int>(list)
    for (i in linkedList) {
        println("List Item $i")
    }
}

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val map1 = nums1.groupBy { it }.map { it.key to it.value.size }.toMap()
    val map2 = nums2.groupBy { it }.map { it.key to it.value.size }.toMap()

    val result = mutableListOf<Int>()

    map1.keys.intersect(map2.keys).forEach {
            num -> repeat (minOf(map1[num]!!, map2[num]!!)) { result.add(num) }
    }

    return result.toIntArray()
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