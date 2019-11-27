package algorithms;

import DataStructures.Edge;
import DataStructures.EdgeWeightedGraph;
import DataStructures.IndexMinPQ;

import java.util.Arrays;
import java.util.Collections;

public class EagerPrimMST implements MST{

    private Edge[] edgeTo;
    private double[] distTo;
    private boolean marked[];
    private IndexMinPQ<Double> pq;

    public EagerPrimMST(EdgeWeightedGraph graph) {

        edgeTo = new Edge[graph.V() - 1];
        distTo = new double[graph.V()];
        marked = new boolean[graph.V()];

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
        return Arrays.asList(edgeTo);
    }

    @Override
    public double weight() {
        int weight = 0;

        for(double w : distTo) {
            weight += w;
        }
        return weight;
    }
}
