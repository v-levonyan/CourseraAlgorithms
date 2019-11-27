package algorithms;


import DataStructures.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch {
    private int[] edgeTo;
    private boolean[] marked;
    private Graph graph;
    int s;

    public BreadthFirstSearch(Graph graph, int s) {
        this.graph = graph;
        this.edgeTo = new int[graph.getV()];
        this.marked = new boolean[graph.getV()];
        this.s = s;
        bfs(s);
    }


    public void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        marked[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            int head = queue.remove();
            for (int vertex : graph.adj(head)) {
                if (!marked[vertex]) {
                    marked[vertex] = true;
                    queue.add(vertex);
                    edgeTo[vertex] = head;
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

}
