public class QuickUnionDS implements DisjointSets {
    private int[] parent;

    // Using index as set elements.
    // Using tree to store elements in the same set, 
    // every parent[root] is the nagetive integet of this set.
    // The parent[i] represents which parent "i" belongs to.
    public QuickUnionDS(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++){
            parent[i] = -1;
        }
    }

    public void validate(int v) {
        if (v >= parent.length) {
            throw new IndexOutOfBoundsException(v + " is not a valid index.");
        }
    }

    // return root of n.
    private int find(int n) {
        validate(n);
        int nRoot = n;
        while (parent[nRoot] > 0){
            nRoot = parent[nRoot];
        }
        return nRoot;
    }

    public int sizeOf(int v){
        validate(v);
        return parent(find(v));
    }

    public int parent(int v){
        validate(v);
        return parent[v];
    }

    public void connect(int p, int q) {
        validate(q);
        validate(p);
        int pParent = find(p);
        int qParent = find(q);
        if (pParent == qParent){
            return;
        }
        int pSize = -1 * sizeOf(pParent);
        int qSize = -1 * sizeOf(qParent);
        if (pSize > qSize){
            parent[qParent] = pParent;
            parent[pParent] -= qSize;
        }
        else{
            parent[pParent] = qParent;
            parent[qParent] -= pSize;
        }
    }

    public boolean isConnect(int p, int q){
        validate(q);
        validate(p);
        return find(p) == find(q);
    }

    public void printDS() {
        for (int i = 0; i < this.parent.length; i++){
            System.out.print(parent[i]);
            System.out.print("\t");
        }
        System.out.println();
        for (int i = 0; i < this.parent.length; i++){
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickUnionDS quds = new QuickUnionDS(10);
        quds.connect(1, 2);
        quds.connect(2, 0);
        quds.connect(1, 4);
        System.out.println(quds.isConnect(1, 9));
        System.out.println(quds.isConnect(4, 0));
        // quds.printDS();
        quds.connect(5, 7);
        // quds.connect(8, 9);
        quds.connect(7, 9);
        System.out.println(quds.isConnect(5, 9));
        System.out.println(quds.isConnect(1, 6));
        // quds.printDS();
        quds.connect(0, 9);
        quds.printDS();
    }
}
