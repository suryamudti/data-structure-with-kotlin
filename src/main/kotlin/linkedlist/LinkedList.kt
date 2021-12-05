package linkedlist

data class Node<T>(
    var value: T,
    var next: Node<T>? = null
) {
    override fun toString(): String {
        return if (next != null)
            "$value -> ${next?.toString()}"
        else
            "$value"
    }
}

class LinkedList<T> : Iterable<T>{
    var head: Node<T>? = null
    var tail: Node<T>? = null
    var size = 0

    fun isEmpty() = size == 0
    override fun toString(): String {
        return if (isEmpty()) "Empty"
        else head.toString()
    }

    fun push(value: T): LinkedList<T> {
        head = Node(value, next = head)
        if (tail == null)
            tail = head
        size++
        return this
    }

    fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        }
        tail?.next = Node(value)
        tail = tail?.next
        size++
    }

    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        val newNode = Node(value, next = afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop() : T? {
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next
        if (isEmpty()) {
            tail = null
        }
        return result
    }

    fun removeLast(): T? {
        var prev = head
        var current = head
        var next = current?.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }
        prev?.next = null
        tail = prev
        return current?.value

    }

    override fun iterator(): Iterator<T> {
        return LinkedListIterator(this)
    }

}

fun main() {
    val data = LinkedList<Int>()
    data.push(1)
        .push(8)
        .push(3)
        .push(6)
        .push(9)
        .push(4)
        .push(7)
    println("Before $data")

    var node = data.head
    var prev: Node<Int>? = null
    while (node != null) {
        val temp = node.next
        node.next = prev
        prev = node
        node = temp
    }
    data.head = prev
    println("After $data")

    data.append(8)
    data.append(7)
    data.append(9)
    data.append(10)

    println("After $data")
    val middleNode = data.nodeAt(2)
    middleNode?.let {
        data.insert(20, it)
    }
    println("After $data")
    data.removeLast()
    println("After $data")
    data.forEach {
        print(it)
    }
}
