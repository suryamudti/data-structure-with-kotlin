package binarytree

import kotlin.math.max

typealias Visitor<T> = (T) -> Unit

class BinaryNode<T>(val value: T) {

    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    override fun toString() = diagram(this)
    private fun diagram(
        node: BinaryNode<T>?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(
                    node.leftChild,
                    "$bottom│ ", "$bottom└──", "$bottom "
                )
            }
        } ?: "${root}null\n"
    }

    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
        visit(value)
    }

    fun height(node: BinaryNode<T>? = this): Int {
        return node?.let { 1 + max(height(node.leftChild), height(node.rightChild)) } ?: -1
    }

    val isBinarySearchTree: Boolean
        get() = isBST(this, min = null, max = null)

    fun isBST(tree: BinaryNode<T>?, min: T?, max: T?): Boolean {
        tree ?: return true

        if (min != null && tree.value as Int <= min as Int) {
            return false
        } else if (max != null && tree.value as Int > max as Int) {
            return false
        }

        return isBST(tree.leftChild, min, tree.value) && isBST(tree.rightChild, tree.value, max)
    }

}

fun main() {
    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)

    seven.leftChild = one
    one.leftChild = zero
    one.rightChild = five
    seven.rightChild = nine
    nine.leftChild = eight

    val data = listOf(10, 12, 30, 49, 30).indexOf(30)
    println(data)
}