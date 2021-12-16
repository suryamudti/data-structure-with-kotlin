package graph

fun main() {
    val graph = AdjacencyList<String>()

    val vincent = graph.createVertex("vincent")
    val chesley = graph.createVertex("chesley")
    val ruiz = graph.createVertex("ruiz")
    val patrick = graph.createVertex("patrick")
    val ray = graph.createVertex("ray")
    val sun = graph.createVertex("sun")
    val cole = graph.createVertex("cole")
    val kerry = graph.createVertex("kerry")

    graph.add(EdgeType.UNDIRECTED, vincent, chesley)
    graph.add(EdgeType.UNDIRECTED, vincent, ruiz)
    graph.add(EdgeType.UNDIRECTED, vincent, patrick)

    graph.add(EdgeType.UNDIRECTED, ruiz, ray)
    graph.add(EdgeType.UNDIRECTED, ruiz, sun)
    graph.add(EdgeType.UNDIRECTED, ruiz, vincent)


    graph.add(EdgeType.UNDIRECTED, patrick, cole)
    graph.add(EdgeType.UNDIRECTED, patrick, kerry)

    graph.add(EdgeType.UNDIRECTED, cole, ruiz)
    graph.add(EdgeType.UNDIRECTED, cole, vincent)

    println(graph)





}