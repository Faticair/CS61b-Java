import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArraySet<T> implements Iterable<T> {

    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[])new Object[100];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(T x) {
        if (size == 0){
            return false;
        }
        for (int i = 0; i < size; i++){
            if (items[i].equals(x)){
                return true;
            }
        }
        return false;
    }

    public void add(T x){
        if (this.contains(x)) {
            return;
        }
        if (x == null){
            throw new IllegalArgumentException("cannot add null", null);
        }
        items[size] = x;
        size += 1;
    }

    private class ArraySetIterator implements Iterator<T> {
        private int IterCursor;

        public ArraySetIterator(){
            IterCursor = 0;
        }

        public boolean hasNext(){
            return IterCursor < size;
        }
    
        public T next(){
            if (IterCursor > size){
                throw new NoSuchElementException();
            }
            else {
                T resItem = items[IterCursor];
                IterCursor += 1;
                return resItem;
            }
        }
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder("{");
        for (int i = 0; i < size - 1; i+=1){
            returnString.append(items[i].toString());
            returnString.append(", ");
        }
        returnString.append(items[size - 1].toString());
        returnString.append("}");
        return returnString.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (this.getClass() != obj.getClass()){
            return false;
        }

        ArraySet<T> o = (ArraySet<T>) obj;
        if (this.size() != o.size()){
            return false;
        }
        for (T item: this){
            if (!o.contains(item)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);
        aset.add(5);

        //iteration
        for (int i : aset) {
            System.out.println(i);
        }

        //toString
        System.out.println(aset.toString());

        //equals
        ArraySet<Integer> asetclone = new ArraySet<>();
        asetclone.add(5);
        asetclone.add(42);
        asetclone.add(23);
        // asetclone.add(10);
        if (aset.equals(asetclone)){
            System.out.println("asetclone is equal to aset.");
        }
        else{
            System.out.println("asetclone is not equal to aset.");
        }
    }
}
