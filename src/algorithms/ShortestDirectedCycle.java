package algorithms;

import DataStructures.DiGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ShortestDirectedCycle {
    private DiGraph graph;
    private boolean [] marked;

    LinkedList<Integer> cycle;

    public ShortestDirectedCycle(DiGraph graph) {
        this.graph = graph;
        marked = new boolean[graph.getV()];
        cycle = new LinkedList<>();
    }

    public void findShortestDirectedCycle(int i) {
        dfs(i);
    }

    private void dfs(int src) {

        marked[src] = true;
        System.out.println("mark " + src);

        for (int v : graph.adj(src)) {
            if (!marked[v]) {
                System.out.println("not marked " + v);
                dfs(v);
            }
        }

    }

    void cycle() {

    }
}
