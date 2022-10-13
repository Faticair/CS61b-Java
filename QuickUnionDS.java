public class QuickUnionDS implements DisjointSets {
    private int[] parent;

    // Using index as set elements.
    // Using tree to store elements in the same set, 
    // every parent[root] is -1.
    // The parent[i] represents which parent "i" belongs to.
    public QuickUnionDS(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++){
            parent[i] = -1;
        }
    }

    // return root of n.
    private int find(int n) {
        int nRoot = n;
        while (parent[nRoot] > 0){
            nRoot = parent[nRoot];
        }
        return nRoot;
    }

    public void connect(int p, int q) {
        int pParent = find(p);
        int qParent = find(q);
        if (pParent == qParent){
            return;
        }
        parent[pParent] = qParent;
    }

    public boolean isConnect(int p, int q){
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        QuickUnionDS quds = new QuickUnionDS(10);
        quds.connect(1, 2);
        quds.connect(8, 9);
        quds.connect(2, 6);
        System.out.println(quds.isConnect(1, 9));
        System.out.println(quds.isConnect(1, 6));
    }
}
