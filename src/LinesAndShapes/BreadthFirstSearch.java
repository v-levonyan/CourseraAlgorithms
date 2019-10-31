package LinesAndShapes;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    private Vertex[] edgeTo;
    private boolean[] marked;
    private Graph graph;

    private Vertex s;

    public BreadthFirstSearch(Graph graph, Vertex s) {
        this.graph = graph;
        this.s = s;
        this.edgeTo = new Vertex[graph.getV()];
        this.marked = new boolean[graph.getV()];
        bfs(s);
    }

    public void bfs(Vertex v){
        Queue<Vertex> queue = new LinkedList<>();

        marked[v.getNumber()] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            Vertex head = queue.remove();
            for (Vertex vertex : graph.adj(head)) {
                if (!marked[vertex.getNumber()]) {
                    marked[vertex.getNumber()] = true;
                    queue.add(vertex);
                    edgeTo[vertex.getNumber()] = head;
                }
            }
        }
    }
}
