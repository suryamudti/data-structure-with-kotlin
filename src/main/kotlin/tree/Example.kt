package tree

import queue.QueueImpl

typealias TreeVisitor<T> = (Tree<T>) -> Unit

class Tree<T : Any>(
    val value: T
) {

    private val children = mutableListOf<Tree<T>>()
    fun add(child: Tree<T>) = children.add(child)

    fun forEachDeepFirst(visitor: TreeVisitor<T>) {
        visitor(this)

        children.forEach {
            it.forEachDeepFirst(visitor)
        }
    }

    fun forEachLevelOrder(visit: TreeVisitor<T>) {
        visit(this)
        val queue = QueueImpl<Tree<T>>()
        children.forEach { queue.enqueue(it) }

        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }

    fun search(value: T): Tree<T>? {
        var result: Tree<T>? = null
        forEachLevelOrder {
            if (value == it.value)
                result = it
        }
        return result
    }

}

fun generateNodeNumbers(): Tree<Pair<Int, Int>> {
    val root = Tree(Pair(1, 4))

    val nodeLeft1 = Tree(Pair(2, 7))
    val nodeRight1 = Tree(Pair(2, 9))

    val nodeLeft2 = Tree(Pair(3, 10))
    val nodeRight2 = Tree(Pair(3, 2))
    val nodeRight3 = Tree(Pair(3, 6))

    val nodeRight4 = Tree(Pair(4, 6))
    val nodeLeft5 = Tree(Pair(5, 2))

    root.add(nodeLeft1)
    root.add(nodeRight1)

    nodeRight1.add(nodeRight3)
    nodeLeft1.add(nodeLeft2)
    nodeLeft1.add(nodeRight2)

    nodeRight2.add(nodeRight4)
    nodeRight4.add(nodeLeft5)

    return root
}

fun main() {
    val trees = generateNodeNumbers()

    val listOfPairs = mutableListOf<Pair<Int, Int>>()
    trees.forEachDeepFirst {
        listOfPairs.add(it.value)
    }
    val result = mutableListOf<Int>()
    listOfPairs.groupBy { it.first }.forEach {
        val sum = it.value.sumOf { it.second }
        result.add(sum / it.value.size)
    }

//    trees.forEachLevelOrder {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                alue)
//    }
    val searchResult = trees.search(Pair(2, 7))?.value
    searchResult?.let {
        print(it)
    } ?: print("cannot found")

}