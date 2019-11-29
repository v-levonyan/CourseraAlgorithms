package algorithms;

import DataStructures.Edge;
import DataStructures.EdgeWeightedGraph;
import DataStructures.IndexMinPQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EagerPrimMST implements MST{

    private Edge[] edgeTo;
    private double[] distTo;
    private boolean marked[];
    private IndexMinPQ<Double> pq;

    public EagerPrimMST(EdgeWeightedGraph graph) {

        edgeTo = new Edge[graph.V()];
        distTo = new double[graph.V()];
        marked = new boolean[graph.V()];

        pq = new IndexMinPQ<>(graph.V());

        for (int v = 0; v < graph.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        pq.insert(0, 0.0);

        while (!pq.isEmpty()) {
            visit(graph, pq.delMin());
        }


    }

    private void visit(EdgeWeightedGraph graph, int v) {
        marked[v] = true;

        for (Edge e : graph.adj(v)) {

            int w = e.other(v);
            if (marked[w]) continue;

            if (e.weight() < distTo[w]) {
                edgeTo[w] = e;
                distTo[w] = e.weight();

                if (pq.contains(w)) pq.change(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    @Override
    public Iterable<Edge> edges() {
        List<Edge> edges = new ArrayList<>();
        for (Edge e : edgeTo) {
            if (e != null) {
                edges.add(e);
            }
        }
        return edges;
    }

    @Override
    public double weight() {
        double weight = 0.0;

        for(Edge e : edgeTo) {
            if (e != null) {
                weight += e.weight();
            }
        }
        return weight;
    }
}
