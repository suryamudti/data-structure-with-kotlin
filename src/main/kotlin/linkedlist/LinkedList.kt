package linkedlist


data class Node<T : Any>(
    var value: T,
    var next: Node<T>? = null
) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }

    fun printInverse() {
        next?.printInverse()

        if (next != null) {
            print(" -> ")
        }
        print(value.toString())
    }
}

fun main() {
    val list = Node(1,  Node(2, Node(3, Node(4, Node(5))),))
    print(list)
}

