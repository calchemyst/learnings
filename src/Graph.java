import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by afuller on 11/1/15.
 */
public class Graph {
    private final Set<Vertex> vertices;

    public Graph() {
        this.vertices = new HashSet<>();
    }

    public void addEdge(Vertex v, Vertex w) {
        v.addEdge(w);
    }

    // Number of vertices.
    public int V() {
        return vertices.size();
    }

    // Number of edges.
    public int E() {
        int numEdges = 0;
        Iterator<Vertex> vertexIterator = vertices.iterator();
        while (vertexIterator.hasNext()) {
            numEdges = numEdges + vertexIterator.next().edges();
        }
        return numEdges;
    }

    public Iterable<Vertex> vertices() {
        return vertices;
    }

    public Iterable<Vertex> adjacentTo(Vertex v) {
        return v.getEdges();
    }

    // Number of neighbors of v.
    public int degree(Vertex v) {
        return v.edges();
    }

    public boolean hasVertex(Vertex v) {
        return vertices.contains(v);
    }

    public boolean hasEdge(Vertex v, Vertex w) {
        Set<Vertex> edgesV = v.getEdges();
        Set<Vertex> edgesW = w.getEdges();
        return edgesV.retainAll(edgesW);
    }

    class Vertex {
        private final String v;
        private final Set<Vertex> edges;

        public Vertex(String v) {
            this.v = v;
            this.edges = new HashSet<>();
        }

        public Set<Vertex> getEdges() {
            return edges;
        }

        public int edges() {
            return edges.size();
        }

        public void addEdge(Vertex e) {
            edges.add(e);
        }

        public boolean removeEdge(Vertex e) {
            return edges.remove(e);
        }
    }

}
