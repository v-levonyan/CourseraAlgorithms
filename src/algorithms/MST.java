package algorithms;

import DataStructures.Edge;
import DataStructures.EdgeWeightedGraph;

public interface MST {

    public Iterable<Edge> edges();

    public double weight();
}
