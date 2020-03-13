package algorithms;

import DataStructures.DirectedEdge;
import DataStructures.EdgeWeightedDigraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Arbitrage
{
    public static void main(String[] args) throws FileNotFoundException {
        File inFile = null;
        if (0 < args.length) {
            inFile = new File(args[0]);
        } else {
            System.err.println("Invalid arguments count:" + args.length);
            System.exit(0);
        }
        Scanner in = new Scanner(inFile);
        int V = in.nextInt();
        String[] name = new String[V];
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
        for (int v = 0; v < V; v++) {
            name[v] = in.next();
            for (int w = 0; w < V; w++)
            {
                String rateString = in.next();
                double rate = Double.parseDouble(rateString);
                DirectedEdge e = new DirectedEdge(v, w, -Math.log(rate));
                G.addEdge(e);
            }
        }
        BellmanFordSP spt = new BellmanFordSP(G, 0);
        if (spt.hasNegativeCycle()) {
            double stake = 1000.0;
            for (DirectedEdge e : spt.negativeCycle())
            {
                System.out.printf("%10.5f %s ", stake, name[e.from()]);
                stake *= Math.exp(-e.weight());
                System.out.printf("= %10.5f %s\n", stake, name[e.to()]);
            }
        }
        else System.out.println("No arbitrage opportunity");
    }
}
