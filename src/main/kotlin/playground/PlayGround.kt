package playground

fun main() {
    val data = "😂 🙏 😎 main 🦶🏻"
    val middle = data.length / 2

    val left = data.substring(0..middle)
    val right = data.substring(middle..data.lastIndex)
    println(left)
    println(right)
}