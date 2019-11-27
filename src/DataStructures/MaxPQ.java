package DataStructures;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;             // heap-ordered complete binary tree
    private int N = 0;            //    in pq[1..N] with pq[0] unused

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

//    private boolean less(int i, int j){}
    private void exch(int i, int j){}
    private void swim(int k){


    }
    private void sink(int k){}
}
