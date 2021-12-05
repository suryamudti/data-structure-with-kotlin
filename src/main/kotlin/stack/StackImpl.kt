//package stack
//
//import java.util.*
//
//class StackImpl<T : Any> : Stack<T> {
//
//    private var storage = arrayListOf<T>()
//
//    override fun pop(): T? {
//        return storage.removeLastOrNull()
//    }
//
//    override fun push(element: T) {
//        storage.add(element)
//    }
//
//    override fun peek(): T? {
//        return storage.lastOrNull()
//    }
//
//    override val count: Int
//        get() = storage.size
//}
//
//fun String.isValidParentheses(): Boolean {
//    val stack = StackImpl<Char>()
//    for (char in this) {
//        when (char) {
//            '(' -> {
//                stack.push(char)
//            }
//            ')' -> {
//                if (stack.isEmpty)
//                    return false
//                else stack.pop()
//            }
//        }
//    }
//
//    return stack.isEmpty
//}
//
//fun main() {
//    print("((()))".isValidParentheses())
//
//}