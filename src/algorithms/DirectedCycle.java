package algorithms;

import DataStructures.DiGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DirectedCycle {
    private DiGraph diGraph;
    private boolean[] marked;
    private boolean[] onStack;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private List<Stack<Integer>> cycles;

    public DirectedCycle(DiGraph diGraph) {
        this.diGraph = diGraph;
        marked = new boolean[diGraph.getV()];
        onStack = new boolean[diGraph.getV()];
        edgeTo = new int[diGraph.getV()];
        cycles = new ArrayList<>();

        for (int i = 0; i < diGraph.getV(); i++) {
//            if (!marked[i]) {
                markAll(false);
                dfsShortestCycle(i);
        }
    }

    private void markAll(boolean b) {
        for (int i = 0; i < marked.length; i++) {
            marked[i] = b;
        }
    }

    private void dfs(int src) {
        marked[src] = true;

        onStack[src] = true;
        for (int v : diGraph.adj(src)) {

            if (hasCycle()) {
                return;
            }
            else if (!marked[v]) {
                edgeTo[v] = src;
                dfs(v);
            }
            else if (onStack[v]) {
                cycle = new Stack<>();

                for (int i = src; i != v ; i = edgeTo[i]) {
                    cycle.add(i);
                }
                cycle.add(v);
                cycle.add(src);
            }
        }
        onStack[src] = false;
    }

    private void dfsShortestCycle(int src) {
        marked[src] = true;

        onStack[src] = true;
        for (int v : diGraph.adj(src)) {

            if (!marked[v]) {
                edgeTo[v] = src;
                dfsShortestCycle(v);
            }
            else if (onStack[v]) {
                cycle = new Stack<>();

                for (int i = src; i != v ; i = edgeTo[i]) {
                    cycle.add(i);
                }
                cycle.add(v);
                cycle.add(src);
                cycles.add(cycle);
            }
        }
        onStack[src] = false;
    }


    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public List<Stack<Integer>> cycles() {
        return cycles;
    }


}
