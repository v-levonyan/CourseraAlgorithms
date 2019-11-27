package algorithms;

import DataStructures.Bag;
import DataStructures.Edge;
import DataStructures.EdgeWeightedGraph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LazyPrimMST implements MST{

    private final EdgeWeightedGraph graph;
    private Queue<Edge> mst;
    private PriorityQueue<Edge> pq;
    private boolean[] marked;


    public LazyPrimMST(EdgeWeightedGraph graph) {
        mst = new LinkedList<>();
        pq = new PriorityQueue<>();
        marked = new boolean[graph.V()];
        this.graph = graph;
        mst();
    }

    private void mst() {
        visit(0);

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.add(e);
            if (!marked[v]) visit(v);
            if (!marked[w]) visit(w);
        }
    }

    private void visit(int i) {
        marked[i] = true;

        for (Edge e : graph.adj(i)) {
            if (!marked[e.other(i)]) {
                pq.add(e);
            }
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        double weight = 0;

        for (Edge e : mst) {
            weight += e.weight();
        }
        return weight;
    }
}
