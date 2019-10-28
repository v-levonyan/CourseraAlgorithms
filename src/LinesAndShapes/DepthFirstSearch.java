package LinesAndShapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class DepthFirstSearch extends JPanel implements ActionListener {

    private Vertex[] edgeTo;
    private boolean[] marked;
    private Vertex s;
    private final Timer timer;

    private Graph graph;
    private Vertex currentVertex;

    public DepthFirstSearch(Graph graph, Vertex s) {
        this.graph = graph;
        edgeTo = new Vertex[graph.getV()];
        marked = new boolean[graph.getV()];
        this.s = s;
        timer = new Timer(20000, this);
        timer.setInitialDelay(190);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graph.paint(g);
        dfs(s, g);
    }

    private void dfs(Vertex src, Graphics g) {

        marked[Integer.parseInt(src.getNumber())] = true;
        src.fillVertex(g);
        currentVertex = src;
        timer.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Vertex v : graph.adj(src)) {
            if (!marked[Integer.parseInt(v.getNumber())]) {
                dfs(v, g);
                edgeTo[Integer.parseInt(v.getNumber())] = src;
            }
        }

    }

    boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint((int)currentVertex.getX(), (int)currentVertex.getY(), (int)currentVertex.getRad(), (int)currentVertex.getRad());
        timer.stop();
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

