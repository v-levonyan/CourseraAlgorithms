package DataStructures;

public class DiGraph {
    private final int V;
    private Bag<Integer>[] adj;

    public DiGraph (int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];

        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public int getV() {
        return V;
    }


    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
