package Project1;

public class LinkedListDeque<T> {
    private int size;
    private qNode sentinel;

    public class qNode {
        public qNode prev;
        public qNode next;
        public T item;

        // public qNode(){
        //     this.item = null;
        //     prev = null;
        //     next = null;
        // }

        public qNode(T i, qNode p, qNode n){
            this.item = i;
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque() {
        this.size = 0;
        /** sentinel.prev is the last node, sentinel.next is the first node. */
        this.sentinel = new qNode(null, null, null);
    }

    public LinkedListDeque(LinkedListDeque other){
        this.size = other.size;
        this.sentinel = new qNode(null, null, null);
        if (other.size == 0){
            return;
        }
        int s = this.size;
        qNode p = other.sentinel.next;
        qNode copyP = this.sentinel;
        while ( s > 0 ){
            copyP.next = new qNode(p.item, copyP, null);
            copyP = copyP.next;
            p = p.next;
            s -= 1;
        }
        copyP.next = this.sentinel;
        this.sentinel.prev = copyP;
    }

    public void addFirst(T item) {
        if (this.size == 0) {
            this.size += 1;
            qNode p = new qNode(item, sentinel, sentinel);
            sentinel.next = p;
            sentinel.prev = p;
        } else {
            this.size += 1;
            qNode p = new qNode(item, sentinel, sentinel.next);
            sentinel.next.prev = p;
            sentinel.next = p;
        }
    }

    public void addLast(T item) {
        if (this.size == 0) {
            this.size += 1;
            qNode p = new qNode(item, sentinel, sentinel);
            sentinel.next = p;
            sentinel.prev = p;
        } else {
            this.size += 1;
            qNode p = new qNode(item, sentinel.prev, sentinel);
            sentinel.prev.next = p;
            sentinel.prev = p;
        }
    }

    public boolean isEmpty(){
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        T[] items = (T[]) new Object[this.size];
        qNode p = this.sentinel.next;
        int i = 0;
        while ( i < this.size){
            items[i] = p.item;
            i += 1;
            p = p.next;
        }
        for (T j: items){
            System.out.print(j + " ");
        }
        System.out.println("\n");
    }

    public T removeFirst() {
        if (this.isEmpty()){
            return sentinel.item;
        }
        this.size -= 1;
        qNode p = sentinel.next;
        p.next.prev = sentinel;
        sentinel.next = p.next;
        return p.item;
    }

    public T removeLast() {
        if (this.isEmpty()){
            return sentinel.item;
        }
        this.size -= 1;
        qNode p = sentinel.prev;
        p.prev.next = sentinel;
        sentinel.prev = p.prev;
        return p.item;
    }

    public T get(int index) {
        if (this.isEmpty() || index > size || index < 0){
            return sentinel.item;
        }
        qNode p = sentinel;
        if (index < size / 2) {
            p = sentinel.next;
            while (index != 0){
                p = p.next;
                index -= 1;
            }
        } else {
            p = sentinel.prev;
            while (index != size - 1){
                p = p.prev;
                index += 1;
            }
        }
        return p.item;
    }
}
