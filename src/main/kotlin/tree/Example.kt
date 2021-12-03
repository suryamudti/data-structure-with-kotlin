package tree

typealias TreeVisitor<T> = (Tree<T>) -> Unit

class Tree<T : Any>(val value: T) {

    private val children = mutableListOf<Tree<T>>()
    fun add(child: Tree<T>) = children.add(child)

    fun forEachDeepFirst(visitor: TreeVisitor<T>) {
        visitor(this)

        children.forEach {
            it.forEachDeepFirst(visitor)
        }
    }

}

fun generateNodeNumbers(): Tree<Int> {
    val root = Tree(5)

    val nodeLeft1 = Tree(2)
    val nodeRight1 = Tree(4)

    val nodeLeft2 = Tree(3)
    val nodeRight2 = Tree(1)

    root.add(nodeLeft1)
    root.add(nodeRight1)

    nodeRight1.add(nodeRight2)
    nodeLeft1.add(nodeLeft2)

    return root
}

fun main() {
    val trees = generateNodeNumbers()
    trees.forEachDeepFirst {
        println(it.value)
    }
}