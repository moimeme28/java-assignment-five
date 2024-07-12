/**
 * Represents an edge in the graph.
 */
public class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    /**
     * Constructs an edge with the given source, destination, and weight.
     */
    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    /**
     * Compares this edge with another edge based on weight.
     */
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}