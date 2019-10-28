import java.util.Stack;

public class DepthFirstSearch {

    private int[] edgeTo;
    private boolean[] marked;
    private int s;

    private Graph graph;
    public DepthFirstSearch(Graph graph, int s) {
        this.graph = graph;
        edgeTo = new int[graph.getV()];
        marked = new boolean[graph.getV()];
        this.s = s;
        dfs(s);
    }

    private void dfs(int src) {

        marked[src] = true;

        for (int v : graph.adj(src)) {
            if (!marked[v]) {
                dfs(v);
                edgeTo[v] = src;
            }
        }

    }

    boolean hasPathTo(int v) {
        return marked[v];
    }

    Iterable<Integer> pathTo(int v) {

        if (!hasPathTo(v)) return null;

        Stack<Integer> path = new Stack<>();

        for(int p = v; p != s; p = edgeTo[p]) {
           path.push(p);
        }
        path.push(s);

        return path;
    }

}
