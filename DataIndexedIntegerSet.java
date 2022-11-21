public class DataIndexedIntegerSet {
    private boolean[] present;
    private int setSize = 1000;

    public DataIndexedIntegerSet() {
        present = new boolean[setSize];   //default value is false. Default size is 1000.
    }

    public DataIndexedIntegerSet(int userSetSize) {
        setSize = userSetSize;
        present = new boolean[setSize];
    }

    public void add(int x) {
        present[x] = true;
    }

    public boolean contains(int x) {
        return present[x];
    }
}
