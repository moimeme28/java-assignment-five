import java.util.*;

/**
 * Implements Prim's algorithm to find the Minimum Spanning Tree (MST) of a graph.
 */
public class PrimMST {
    
    /**
     * Computes the Minimum Spanning Tree (MST) using Prim's algorithm.
     * 
     * @param graph The input graph.
     * @return A list of edges representing the MST.
     */
    public List<Edge> primMST(Graph graph) {
        boolean[] visited = new boolean[graph.getVertices()];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        List<Edge> mst = new ArrayList<>();

        // Start from vertex 0 (or any arbitrary vertex)
        addEdges(graph, pq, 0, visited);

        while (!pq.isEmpty() && mst.size() < graph.getVertices() - 1) {
            Edge edge = pq.poll();
            if (visited[edge.destination]) {
                continue;
            }
            mst.add(edge);
            addEdges(graph, pq, edge.destination, visited);
        }
        return mst;
    }

    /**
     * Adds edges of a given vertex to the priority queue.
     * 
     * @param graph The input graph.
     * @param pq The priority queue used to select the next edge.
     * @param vertex The current vertex.
     * @param visited The array indicating which vertices have been visited.
     */
    private void addEdges(Graph graph, PriorityQueue<Edge> pq, int vertex, boolean[] visited) {
        visited[vertex] = true;
        for (Edge edge : graph.getEdges(vertex)) {
            if (!visited[edge.destination]) {
                pq.add(edge);
            }
        }
    }
}
