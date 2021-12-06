package tree

import queue.QueueImpl

typealias Visitor<T> = (TreeNode<T>) -> Unit

class TreeNode<T>(val value: T) {

    val children = mutableListOf<TreeNode<T>>()

    fun add(node: TreeNode<T>) = children.add(node)

    fun forEachDeepFirst(visitor: Visitor<T>) {
        visitor(this)
        children.forEach {
            it.forEachDeepFirst(visitor)
        }
    }

    fun forEachLevel(visitor: Visitor<T>) {
        visitor(this)
        val queue = QueueImpl<TreeNode<T>>()
        children.forEach {
            queue.enqueue(it)
        }
        var node = queue.dequeue()
        while (node != null) {
            visitor(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }

    fun search(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null
        forEachLevel {
            if (it.value == value)
                result = it
        }
        return result
    }
}

fun makeBeverageTree(): TreeNode<String> {
    val tree = TreeNode("Beverages")

    val hot = TreeNode("hot")
    val cold = TreeNode("cold")

    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("cocoa")

    val blackTea = TreeNode("black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("chai")

    val soda = TreeNode("soda")
    val milk = TreeNode("milk")

    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")

    tree.add(hot)
    tree.add(cold)

    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)

    cold.add(soda)
    cold.add(milk)

    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)

    soda.add(gingerAle)
    soda.add(bitterLemon)

    return tree
}

fun main() {
    val tree = makeBeverageTree()

    tree.forEachLevel {
        println(it.value)
    }
    var hot = tree.search("hot")

//    tree.printEachLevel()

//    println(tree.search("ginger ae")?.value ?: error("error bro"))

//    tree.forEachLevelOrder { println(it.value) }
}
