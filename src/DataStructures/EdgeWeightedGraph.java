package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Edge>();
    }

    public EdgeWeightedGraph(BufferedReader in) throws IOException {
        this(Integer.parseInt(in.readLine().split(" ")[0]));

        String[] strarr;
//        E = Integer.parseInt(strarr[1]);

        String line;
        while ((line=in.readLine()) != null) {

            strarr = line.split(" ");

            int v = Integer.parseInt(strarr[0]);
            int w = Integer.parseInt(strarr[1]);
            double weight = Double.parseDouble(strarr[2]);
            addEdge(new Edge(v, w, weight));
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }
//    public EdgeWeightedGraph(InputStream in) {
//    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return this.adj[v];
    }

    public Iterable<Edge> edges() {
        List<Edge> edges = new ArrayList<>();

        for (int v = 0; v < V; v++) {
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    edges.add(e);
                }
            }
        }
        return edges;
    }

    @Override
    public String toString() {
        StringBuilder resultBuilder = new StringBuilder();
        for (Edge e : edges()) {
            resultBuilder.append(e.toString());
            resultBuilder.append(System.lineSeparator());
        }
        return resultBuilder.toString();
    }
}
