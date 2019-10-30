package LinesAndShapes;

import DataStructures.Bag;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Graph{

    private Bag<Vertex>[] adj;

    public Vertex[] getVertices() {
        return vertices;
    }

    private Vertex[] vertices;
    private List<Edge> edges;

    public Graph (Vertex[] vertices) {
        this.vertices = vertices;

        adj =  new Bag[vertices.length];
        edges = new ArrayList<>();

        for (int v = 0; v < vertices.length; v++) {
            adj[v] = new Bag<>();
        }
    }

    public int getV() {
        return vertices.length;
    }


    public Iterable<Vertex> adj(Vertex v) {
        return adj[v.getNumber()];
    }

    private void drawVerticis(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        for (Vertex v : this.vertices) {
            v.drawVertex(g2);
        }
    }

    public void paint(Graphics g) {
        drawVerticis(g);
        drawEdges(g);
    }

    private void drawEdges(Graphics g) {
        for (Edge edge : edges) {
            edge.draw(g);
        }
    }

    public Vertex getVertex(int v) {
        for (Vertex vertex : vertices) {
            if(vertex.getNumber() == v) return vertex;
        }
        return null;
    }

    public void drawEdge(int currentVertex, int v) {

    }

    public void addEdge(Edge edge) {
        adj[edge.getV1().getNumber()].add(edge.getV2());
        adj[edge.getV2().getNumber()].add(edge.getV1());

        edges.add(edge);
    }
}
