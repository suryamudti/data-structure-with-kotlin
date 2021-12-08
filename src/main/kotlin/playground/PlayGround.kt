package playground

fun main() {
    println(wordPattern("abba", "dog dog dog dog"))
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