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
    val queue = QueueImpl<String>().apply {
        enqueue("Vincent")
        enqueue("Remel")
        enqueue("Lukiih")
        enqueue("Allison")
    }
    println(queue)
    println("=====BoardGame========")
    queue.nextPlayer()
    println(queue)
    queue.nextPlayer()
    println(queue)
    queue.nextPlayer()
    println(queue)
}

fun <T> QueueImpl<T>.nextPlayer(): T? {
    val person = this.dequeue() ?: return null
    this.enqueue(person)
    return person
}