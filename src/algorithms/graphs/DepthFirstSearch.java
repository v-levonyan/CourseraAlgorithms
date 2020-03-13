package algorithms.graphs;

import DataStructures.Graph;

import java.util.Stack;

public class DepthFirstSearch {

    private int[] edgeTo;
    private boolean[] marked;
    private int s;


    private Graph graph;
    public DepthFirstSearch(Graph graph, int s) {
        this.graph = graph;
        edgeTo = new int[graph.getV()];
        marked = new boolean[graph.getV()];
        this.s = s;
        dfs(s);
    }

    private void dfs(int src) {

        marked[src] = true;
        System.out.println("mark " + src);

        for (int v : graph.adj(src)) {
            if (!marked[v]) {
                dfs(v);
                edgeTo[v] = src;
                System.out.println(v + "-->" + src);

            }
        }

    }

    private void dfsNonRecursive(int src) {

        Stack<Integer> stack = new Stack<>();

        stack.push(src);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!marked[current]) {
                marked[current] = true;
                System.out.println(current);


                for (int v : graph.adj(current)) {
                    if (!marked[v]) {
                        stack.add(v);
                    }
                }
            }
        }
    }

    boolean hasPathTo(int v) {
        return marked[v];
    }

    Iterable<Integer> pathTo(int v) {

        if (!hasPathTo(v)) return null;

        Stack<Integer> path = new Stack<>();

        for(int p = v; p != s; p = edgeTo[p]) {
           path.push(p);
        }
        path.push(s);

        return path;
    }

    public int diameter() {
        int diameter = 0;

        for (int i = 0; i < graph.getV(); i++) {
            Stack<Integer> path = (Stack<Integer>)pathTo(i);
            int pathLength = path.size();
            if (diameter < pathLength) {
                diameter = pathLength;
            }
        }
        return diameter;

    }

}
