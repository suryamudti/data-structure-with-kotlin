package linkedlist

class NodeList(
    val data: Int,
    var next: NodeList? = null,
    var prev: NodeList? = null
)

fun main() {
    val head = NodeList(1)
    val nodeB = NodeList(5)
    val nodeC = NodeList(8)
    val nodeD = NodeList(9)
    val nodeE = NodeList(2)

    head.next = nodeB
    nodeB.next = nodeC
    nodeC.next = nodeD
    nodeD.next = nodeE

    var count = 1
    var currentNode = head
    while (currentNode.next != null) {
        currentNode = currentNode.next!!
        count++
    }

    print(count)

}