package heap

interface Collection<T> {
    val count: Int
        get

    val isEmpty: Boolean
        get() = count == 0

    fun insert(element: T)

    fun remove(): T?

    fun removeIndex(index: Int): T
}

interface Heap<T>: Collection<T> {

    fun peek(): T?
}