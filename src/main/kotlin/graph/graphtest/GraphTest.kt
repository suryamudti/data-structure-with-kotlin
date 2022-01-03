package graph.graphtest

import graph.EdgeType

interface GraphTest<T> {

    fun createVertex(data: T): VertexTest<T>

    fun addDirectedEdge(
        source: VertexTest<T>,
        destination: VertexTest<T>,
        distance: Int?
    )

    fun addUnDirectedEdge(
        source: VertexTest<T>,
        destination: VertexTest<T>,
        distance: Int?
    )

    fun edges(source: VertexTest<T>): ArrayList<EdgeTest<T>>

    fun add(
        edgeType: EdgeType,
        source: VertexTest<T>,
        destination: VertexTest<T>,
        distance: Int?
    )

    fun distance(
        source: VertexTest<T>,
        destination: VertexTest<T>
    ): Int?
}

data class VertexTest<T>(
    val index: Int,
    val data: T
)

data class EdgeTest<T>(
    val source: VertexTest<T>,
    val destination: VertexTest<T>,
    val distance: Int?
)