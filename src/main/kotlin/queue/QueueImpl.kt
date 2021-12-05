package queue

class QueueImpl<T> : Queue<T> {

    private val storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size

    override fun peek() = storage.firstOrNull()

    override fun enqueue(element: T) = storage.add(element)

    override fun dequeue(): T? = storage.removeFirstOrNull()

    override fun toString() = buildString {
        appendLine("----front-----")
        storage.forEach {
            appendLine(it)
        }
        appendLine("--------------")
    }
}

fun main() {
    val queue = QueueImpl<Char>()
    queue.enqueue('D')
    queue.enqueue('S')
    queue.enqueue('A')
    queue.enqueue('L')
    queue.enqueue('G')
    println(queue)
    queue.dequeue()
    println(queue)
    println("next is ${queue.peek()}")
}