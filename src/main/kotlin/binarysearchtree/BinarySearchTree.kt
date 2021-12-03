package binarysearchtree

import binarytree.BinaryNode

class BinarySearchTree<T : Comparable<T>> {
    var root: BinaryNode<T>? = null
    override fun toString() = root?.toString() ?: "empty tree"

    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun insert(
        node: BinaryNode<T>?,
        value: T
    ): BinaryNode<T> {
        node ?: return BinaryNode(value)
        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }

        return node
    }

    fun contains(value: T): Boolean {
        root ?: return false
        var found = false
        root?.traverseInOrder {
            if (value == it)
                found = true
        }
        return found
    }
}

fun main() {
    val bst = BinarySearchTree<Int>()
    (0..4).forEach {
        bst.insert(it)
    }
    println(bst)

    val exampleTree = BinarySearchTree<Int>().apply {
        insert(3)
        insert(1)
        insert(4)
        insert(0)
        insert(2)
        insert(5)
    }

    println(exampleTree)
    print(exampleTree.contains(9))
}