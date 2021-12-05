package stack

interface Stack<T> {
    fun pop()
    fun push(element: T)
    fun peek(): T?
    val count: Int
    val isEmpty: Boolean
        get() = count == 0
}

class StackImpl<T : Any> : Stack<T> {
    private val storage = arrayListOf<T>()

    override fun pop() {
        if (isEmpty) return
        storage.removeAt(storage.lastIndex)
    }

    override fun push(element: T) {
        storage.add(element)
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size

    override fun toString() = buildString {
        appendLine("-----top------")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("--------------")
    }
}

fun main() {
    val stack = StackImpl<Int>()
    stack.push(100)
    stack.push(200)
    stack.push(900)
    stack.push(880)

    println(stack)
    stack.pop()
    println(stack)
    println(stack.peek())

    val isValid = "h((e))llo(world)()".checkValidParentheses()
    println(isValid)
}

fun String.checkValidParentheses(): Boolean {
    val stack = StackImpl<Char>()
    forEach {
        when(it) {
            '(' -> stack.push(it)
            ')' -> {
                if (stack.isEmpty) return false
                else stack.pop()
            }
        }
    }
    return stack.isEmpty
}