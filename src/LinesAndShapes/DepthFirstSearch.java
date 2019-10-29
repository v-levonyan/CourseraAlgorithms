package LinesAndShapes;

import javax.swing.*;
import java.awt.*;

public class DepthFirstSearch extends JPanel {

    private Vertex[] edgeTo;
    private boolean[] marked;
    private Vertex s;

    private Graph graph;

    public DepthFirstSearch(Graph graph, Vertex s) {
        this.graph = graph;
        edgeTo = new Vertex[graph.getV()];
        marked = new boolean[graph.getV()];
        this.s = s;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graph.paint(getGraphics());
        dfs(s);
    }




    private void dfs(Vertex src) {

        marked[Integer.parseInt(src.getNumber())] = true;
        onNewVertex(src);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Vertex v : graph.adj(src)) {
            if (!marked[Integer.parseInt(v.getNumber())]) {
                dfs(v);
                edgeTo[Integer.parseInt(v.getNumber())] = src;
            }
        }
    }

    private void onNewVertex(Vertex src) {
        Graphics g = getGraphics();
        src.fillVertex(g);
    }










    boolean hasPathTo(int v) {
        return marked[v];
    }














//    Iterable<Integer> pathTo(int v) {
//
//        if (!hasPathTo(v)) return null;
//
//        Stack<Integer> path = new Stack<>();
//
//        for(int p = v; p != s; p = edgeTo[p]) {
//            path.push(p);
//        }
//        path.push(s);
//
//        return path;
//    }

}

