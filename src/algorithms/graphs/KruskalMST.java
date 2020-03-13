package algorithms.graphs;

import DataStructures.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KruskalMST implements MST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G)
    {
        mst = new LinkedList<>();
        MinPQ<Edge> pq = new MinPQ<Edge>((List<Edge>) G.edges());
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);

            if (uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.add(e);
        }
    }

    public Iterable<Edge> edges ()
    {
        return mst;
    }

    public double weight ()
    {
        double weight = 0.0;
        for (Edge e : mst) {
            weight += e.weight();
        }
        return weight;
    }
}