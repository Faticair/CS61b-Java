public class AList<Item> implements List61B<Item>{
    private Item[] items;
    private int size;

    public AList(){
        items = (Item[])new Object[8];
        size = 0;
    }

    private void resize(int newsize){
        Item[] a = (Item[]) new Object[newsize];
        System.arraycopy(this.items, 0, a, 0, size);
        items = a;
    }

    public void addFirst(Item x) {
        if (size == items.length){
            this.resize(size * 2);
        }
        Item[] a = (Item[]) new Object[this.items.length];
        System.arraycopy(this.items, 0, a, 1, size);
        a[0] = x;
        items = a;
        this.size += 1;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
        if (size == items.length){
            this.resize(size * 2);
        }
        this.items[this.size] = x;
        this.size += 1;
    }

    public Item getFirst() {
        return this.items[0];
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return this.items[this.size - 1];        
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return this.items[i];        
    }

    /** Returns the number of items in the list. */
    public int size() {
        return this.size;        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public Item removeLast() {
        Item p = getLast();
        size -= 1;
        return p;
    }

    public void insert(Item x, int position){
        if (size == items.length){
            this.resize(size * 2);
        }
        Item[] a = (Item[]) new Object[this.items.length];
        System.arraycopy(this.items, 0, a, 0, position);
        a[position] = x;
        System.arraycopy(this.items, position, a, position + 1, this.size - position);
        this.items = a;
        this.size += 1;
    }

    public void printList(){
        for (int j = 0; j < this.size; j++){
            System.out.print(this.items[j]);
            System.out.print(" ");
        }
        System.out.println("\n");
    }

    /** 
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
    */
}
