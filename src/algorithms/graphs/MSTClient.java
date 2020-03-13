package algorithms.graphs;

import DataStructures.Edge;
import DataStructures.EdgeWeightedGraph;

import java.io.*;

public class MSTClient {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
        EdgeWeightedGraph G;
        G = new EdgeWeightedGraph(in);
//        MST mst = new LazyPrimMST(G);
//        MST mst = new EagerPrimMST(G);
        MST mst = new KruskalMST(G);
        for (Edge e : mst.edges())
            System.out.println(e);

        System.out.println(mst.weight());
    }
}
