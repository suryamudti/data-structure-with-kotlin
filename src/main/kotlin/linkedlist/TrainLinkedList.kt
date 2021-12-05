package linkedlist

import java.util.LinkedList

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

    val nodeList = mutableListOf<Int>()
    var currentNode = head
    while (currentNode.next != null) {
        nodeList.add(currentNode.data)
        currentNode = currentNode.next!!
        if (currentNode.next == null) {
            nodeList.add(currentNode.data)
        }
    }

    var newHead: NodeList? = null
    var temp = newHead
    nodeList.forEachIndexed { index, item ->
        if (newHead == null) {
            newHead = NodeList(item)
        }
        temp = newHead?.next
        newHead = temp
//        if (index < nodeList.lastIndex)
            newHead?.next = NodeList(item)
    }

    var printed: NodeList? = null
    var next = newHead
    while (next != null) {

        printed = next
        next = printed.next
        println(printed.data)
    }


    println(nodeList)
    println(printed)
//    print(count)

}