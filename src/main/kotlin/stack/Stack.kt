package stack

interface Stack<T: Any> {
    fun pop(): T?
    fun push(element: T)

    fun peek(): T?

    val count: Int

    val isEmpty: Boolean
        get() = count == 0

}