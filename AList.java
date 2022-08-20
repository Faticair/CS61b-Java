public class AList {
    private int[] items;
    private int size;

    public AList(){
        items = new int[100];
        size = 0;
    }

    private void resize(int newsize){
        int[] a = new int[newsize];
        System.arraycopy(this.items, 0, a, 0, size);
        items = a;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size == items.length){
            this.resize(size * 2);
        }
        this.items[this.size] = x;
        this.size += 1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return this.items[this.size - 1];        
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return this.items[i];        
    }

    /** Returns the number of items in the list. */
    public int size() {
        return this.size;        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int p = getLast();
        size -= 1;
        return p;
    }

    public static int[] insert(int[] arr, int item, int position) {
        int[] a = new int[arr.length + 1];
        System.arraycopy(arr, 0, a, 0, position);
        a[position] = item;
        System.arraycopy(arr, position, a, position + 1, arr.length - position);
        return a;
    }

    public static void reverse(int[] arr){
        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            a[arr.length - i - 1] = a[i];
        }
        arr = a;
    }

    public static int[] replicate(int[] arr){
        int[] a = new int[arr.length];
        int aPos = 0;
        for (int i = 0; i < arr.length; i++){
            if (aPos + arr[i] >= a.length){
                int newsize = a.length * 2;
                while (aPos + arr[i] >= newsize){
                    newsize = newsize * 2;
                }
                int[] tmp = new int[newsize];
                System.arraycopy(a, 0, tmp, 0, a.length);
                a = tmp;
            }
            int j;
            for (j = 0; j < arr[i]; j++){
                a[aPos + j] = arr[i];
            }
            aPos += j;
        }
        return a;
    }
}
