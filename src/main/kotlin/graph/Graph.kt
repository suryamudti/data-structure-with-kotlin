package graph

interface Graph<T> {

    fun createVertex(data: T): Vertex<T>

    fun addDirectedEdge(
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?
    )

    fun addUnDirectedEdge(
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?
    )

    fun edges(source: Vertex<T>): ArrayList<Edge<T>>

    fun add(
        edgeType: EdgeType,
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double? = null
    )

    fun weight(
        source: Vertex<T>,
        destination: Vertex<T>
    ): Double?

}

enum class EdgeType {
    DIRECTED, UNDIRECTED
}

data class Vertex<T>(
    val index: Int,
    val data: T
)

data class Edge<T>(
    val source: Vertex<T>,
    val destination: Vertex<T>,
    val weight: Double?
)