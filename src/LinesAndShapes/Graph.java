package LinesAndShapes;

import DataStructures.Bag;

import java.awt.*;

import static LinesAndShapes.Vertex.*;

public class Graph{

    private Bag<Vertex>[] adj;
    private Vertex[] vertices;

    public Graph (Vertex[] vertices) {
        this.vertices = vertices;

        adj =  new Bag[vertices.length];

        for (int v = 0; v < vertices.length; v++) {
            adj[v] = new Bag<>();
        }
    }

    public int getV() {
        return vertices.length;
    }


    public void addEdge(Vertex v, Vertex w) {
        adj[Integer.valueOf(v.getNumber())].add(w);
        adj[Integer.valueOf(w.getNumber())].add(v);
    }

    public Iterable<Vertex> adj(Vertex v) {
        return adj[Integer.parseInt(v.getNumber())];
    }

    private void drawVerticis(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        for (Vertex v : this.vertices) {
            v.drawVertex(g2);
        }
    }

    public void paint(Graphics g) {
        drawVerticis(g);
        new Edge(vertices[0], vertices[1]).draw(g,RAD/2, RAD, RAD/2, 0);
        new Edge(vertices[1], vertices[2]).draw(g, RAD, RAD/2, 0, RAD/2);

        new Edge(vertices[2], vertices[3]).draw(g, RAD/2, 0, RAD/2, RAD);
        new Edge(vertices[0], vertices[3]).draw(g, RAD, RAD/2, 0, RAD/2);
        new Edge(vertices[0], vertices[6]).draw(g, RAD, RAD/2, 0, RAD/2);
        new Edge(vertices[0], vertices[5]).draw(g, RAD, RAD/2, 0, RAD/2);
        new Edge(vertices[1], vertices[4]).draw(g, RAD, RAD/2, 0, RAD/2);

        new Edge(vertices[4], vertices[2]).draw(g, RAD, RAD/2, 0, RAD/2);
    }
}
