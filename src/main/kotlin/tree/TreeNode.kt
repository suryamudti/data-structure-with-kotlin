package tree

import queue.QueueImpl

typealias Visitor<T> = (TreeNode<T>) -> Unit

class TreeNode<T>(val value: T) {

    private val children: MutableList<TreeNode<T>> = mutableListOf()
    fun add(child: TreeNode<T>) = children.add(child)

    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }

    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)
        val queue = QueueImpl<TreeNode<T>>()
        children.forEach {
            queue.enqueue(it)
        }
        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach { queue.enqueue(it) }

            node = queue.dequeue()
        }
    }

    fun search(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null
        forEachDepthFirst {
            if (it.value == value) {
                result = it
                println("fount value is ${it.value}")
            }
        }
        return result
    }

    fun printEachLevel() {
        val queue = QueueImpl<TreeNode<T>>()
        var nodesLeftInCurrentLevel = 0

        queue.enqueue(this)
        while (queue.isEmpty.not()) {
            nodesLeftInCurrentLevel = queue.count

            while (nodesLeftInCurrentLevel > 0) {
                val node = queue.dequeue()
                if (node != null) {
                    println("${node.value}")

                    node.children.forEach { queue.enqueue(it) }
                    nodesLeftInCurrentLevel--
                } else {
                    break
                }
            }
            println(nodesLeftInCurrentLevel)
        }
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

//    tree.forEachDepthFirst {
//        println(it.value)
//    }

    tree.printEachLevel()

//    println(tree.search("ginger ae")?.value ?: error("error bro"))

//    tree.forEachLevelOrder { println(it.value) }
}
