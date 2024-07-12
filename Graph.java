import java.util.*;

/**
 * Represents a graph using an adjacency list.
 */
public class Graph {
    private final int vertices;
    private final List<List<Edge>> adjacencyList;

    /**
     * Constructs a graph with the given number of vertices.
     */
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    /**
     * Adds an edge to the graph.
     */
    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencyList.get(source).add(edge);
        adjacencyList.get(destination).add(new Edge(destination, source, weight)); // For undirected graph
    }

    public int getVertices() {
        return vertices;
    }

    public List<Edge> getEdges(int vertex) {
        return adjacencyList.get(vertex);
    }
}
