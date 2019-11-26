package LinesAndShapes;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends JPanel {
    private Vertex[] edgeTo;
    private boolean[] marked;
    private Graph graph;

    private Vertex s;

    public BreadthFirstSearch(Graph graph, Vertex s) {
        this.graph = graph;
        this.s = s;
        this.edgeTo = new Vertex[graph.getV()];
        this.marked = new boolean[graph.getV()];
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graph.paint(getGraphics());
        bfs(s);
    }

    public void bfs(Vertex v){
        Queue<Vertex> queue = new LinkedList<>();

        marked[v.getNumber()] = true;
        onNewVertex(v);
        queue.add(v);

        while (!queue.isEmpty()) {
            Vertex head = queue.remove();
            for (Vertex vertex : graph.adj(head)) {
                if (!marked[vertex.getNumber()]) {
                    marked[vertex.getNumber()] = true;
                    onNewVertex(vertex);
                    queue.add(vertex);
                    edgeTo[vertex.getNumber()] = head;
                    System.out.println(vertex.getNumber() + "-->" + head.getNumber());
                }
            }
        }
    }

    private void sleep(int mls) {
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void onNewVertex(Vertex src) {
        Graphics g = getGraphics();
        src.fillVertex(g);
        sleep(1000);
    }
}
