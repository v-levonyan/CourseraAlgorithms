package algorithms.graphs;

import DataStructures.Graph;

import java.util.Stack;

public class GraphDiameter {

private Graph graph;

    public GraphDiameter(Graph graph) {
        this.graph = graph;
    }

    public Iterable<Integer> findLongestPath() {
        Stack<Integer> stack = new Stack<>();


        for (int v = 0; v < graph.getV(); v++) {
            int next = graph.adj(v).iterator().next();
        }

        return stack;
    }
}
