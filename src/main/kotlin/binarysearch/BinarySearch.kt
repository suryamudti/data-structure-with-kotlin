package binarysearch


fun <T : Comparable<T>> ArrayList<T>.findIndices(
    value: T
): IntRange? {
    val startIndex = startIndex(value = value, 0..size) ?: return null
    val endIndex = endIndex(value = value, 0..size) ?: return null

    return startIndex until endIndex
}

fun <T : Comparable<T>> ArrayList<T>.startIndex(
    value: T,
    range: IntRange
): Int? {
    val middleIndex = range.start + (range.last - range.start - 1)
    if (middleIndex == 0 || middleIndex == lastIndex) {
        return if (this[middleIndex] == value)
            middleIndex
        else null
    }

    return if (this[middleIndex] == value) {
        if (this[middleIndex - 1] != value) {
            middleIndex
        } else {
            startIndex(value, range.start until middleIndex)
        }
    } else if (value < this[middleIndex]) {
        startIndex(value, range.start until middleIndex)
    } else {
        startIndex(value, (middleIndex + 1) until range.last)
    }
}

fun <T : Comparable<T>> ArrayList<T>.endIndex(
    value: T,
    range: IntRange
): Int? {
    val middleIndex = range.start + (range.last - range.start - 1)
    if (middleIndex == 0 || middleIndex == lastIndex) {
        return if (this[middleIndex] == value)
            middleIndex + 1
        else null
    }

    return if (this[middleIndex] == value) {
        if (this[middleIndex + 1] != value) {
            middleIndex + 1
        } else {
            endIndex(value, (middleIndex + 1)..range.last)
        }
    } else if (value < this[middleIndex]) {
        endIndex(value, range.start until middleIndex)
    } else {
        endIndex(value, (middleIndex + 1)..range.last)
    }
}

fun main() {
    val list = listOf<Int>(1, 5, 15, 17, 19, 22, 24, 31, 105)
    print(list.binarySearch(31))
}