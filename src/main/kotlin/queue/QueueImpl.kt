package queue

class QueueImpl<T> : Queue<T> {

    private val storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size

    override fun peek(): T? {
        return storage.getOrNull(0)
    }

    override fun enqueue(element: T): Boolean {
        return storage.add(element)
    }

    override fun dequeue(): T? {
        return if (isEmpty) null else storage.removeAt(0)
    }
}