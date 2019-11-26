package LinesAndShapes;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

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
//        drawPath(pathTo(graph.getVertices()[4]));
    }

    private void drawPath(Iterable<Integer> path) {
        Graphics g = getGraphics();
        int currentVertex = -1;
        for (int v : path) {
            if (currentVertex == -1) {
                currentVertex = v;
            } else {
                graph.drawEdge(currentVertex, v, g);
                currentVertex = v;
            }
            graph.getVertex(v).fillVertex(g, Color.RED);
            sleep(1000);
        }
    }

    private void dfs(Vertex src) {

        marked[src.getNumber()] = true;
        onNewVertex(src);
        sleep(2000);
        for (Vertex v : graph.adj(src)) {
            if (!marked[v.getNumber()]) {
                dfs(v);
                edgeTo[v.getNumber()] = src;
                System.out.println(v.getNumber() + "-->" + src.getNumber());
            }
        }
    }

    //TODO: wrong solution
    private void dfsNonRecursive(Vertex src) {
        marked[src.getNumber()] = true;

        Stack<Vertex> stack = new Stack<>();

        stack.add(src);
        while (!stack.isEmpty()) {
            Vertex current = stack.pop();
            for (Vertex v : graph.adj(current)) {
                if (!marked[v.getNumber()]) {
                    stack.add(v);
                }
            }
            marked[current.getNumber()] = true;
            if (stack.peek() != null) {
                edgeTo[current.getNumber()] = stack.peek();
                System.out.println(current.getNumber() + "-->" + stack.peek().getNumber());
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
    }

    boolean hasPathTo(Vertex v) {
        return marked[v.getNumber()];
    }

    Iterable<Integer> pathTo(Vertex v) {

        if (!hasPathTo(v)) return null;

        Stack<Integer> path = new Stack<>();

        for(int p = v.getNumber(); p != s.getNumber(); p = edgeTo[p].getNumber()) {
            path.push(p);
        }
        path.push(s.getNumber());

        return path;
    }

}

