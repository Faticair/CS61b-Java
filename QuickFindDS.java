public class QuickFindDS implements DisjointSets {
    
    private int[] setID;

    // Using index as set elements.
    // The setID[i] represents which set "i" belongs to.
    public QuickFindDS(int N) {
        setID = new int[N];
        for (int i = 0; i < N; i++){
            setID[i] = i;
        }
    }

    public void connect(int p, int q) {
        if (setID[p] == setID[q]) {
            return;
        }
        int pid = setID[p];
        int qid = setID[q];
        for (int i = 0; i < setID.length; i++) {
            if (setID[i] == pid){
                setID[i] = qid;
            }
        }
    }

    // Quick find out if two integets are connected. O(1)
    public boolean isConnect(int p, int q) {
        return setID[p] == setID[q];
    }
}
