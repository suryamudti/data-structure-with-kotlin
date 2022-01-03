package graph.graphtest

import graph.EdgeType

class AdjacencyListTest<T>: GraphTest<T> {

    private val adjacencyList: HashMap<VertexTest<T>, ArrayList<EdgeTest<T>>> = HashMap()

    override fun createVertex(data: T): VertexTest<T> {
        val vertex = VertexTest(adjacencyList.size, data)
        adjacencyList[vertex] = ArrayList()
        return vertex
    }

    override fun addDirectedEdge(source: VertexTest<T>, destination: VertexTest<T>, distance: Int?) {
        val edge = EdgeTest(source, destination, distance)
        adjacencyList[source]?.add(edge)
    }

    override fun addUnDirectedEdge(source: VertexTest<T>, destination: VertexTest<T>, distance: Int?) {
        addDirectedEdge(source, destination, distance)
        addDirectedEdge(destination, source, distance)
    }

    override fun edges(source: VertexTest<T>): ArrayList<EdgeTest<T>> {
        return adjacencyList[source] ?: arrayListOf()
    }

    override fun add(edgeType: EdgeType, source: VertexTest<T>, destination: VertexTest<T>, distance: Int?) {
        when (edgeType) {
            EdgeType.DIRECTED -> addDirectedEdge(source, destination, distance)
            EdgeType.UNDIRECTED -> addUnDirectedEdge(source, destination, distance)
        }
    }

    override fun distance(source: VertexTest<T>, destination: VertexTest<T>): Int? {
        return edges(source).firstOrNull { it.destination == destination }?.distance
    }
}