package LinesAndShapes;

import DataStructures.Bag;

import java.awt.*;

import static LinesAndShapes.Vertex.*;

public class Graph{

    private Bag<Vertex>[] adj;

    public Vertex[] getVertices() {
        return vertices;
    }

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
        new Edge(vertices[0], vertices[1]).withCoordinates(RAD/2, RAD, RAD/2, 0).draw(g);
        new Edge(vertices[1], vertices[2]).withCoordinates(RAD, RAD/2, 0, RAD/2).draw(g);

        new Edge(vertices[2], vertices[3]).withCoordinates(RAD/2, 0, RAD/2, RAD).draw(g);
        new Edge(vertices[0], vertices[3]).withCoordinates(RAD, RAD/2, 0, RAD/2).draw(g);
        new Edge(vertices[0], vertices[6]).withCoordinates(RAD, RAD/2, 0, RAD/2).draw(g);
        new Edge(vertices[0], vertices[5]).withCoordinates(RAD, RAD/2, 0, RAD/2).draw(g);
        new Edge(vertices[1], vertices[4]).withCoordinates(RAD, RAD/2, 0, RAD/2).draw(g);

        new Edge(vertices[4], vertices[2]).withCoordinates(RAD, RAD/2, 0, RAD/2).draw(g);
    }

    public Vertex getVertex(int v) {
        for (Vertex vertex : vertices) {
            if(vertex.getNumber() == v) return vertex;
        }
        return null;
    }

    public void drawEdge(int currentVertex, int v) {

    }
}
