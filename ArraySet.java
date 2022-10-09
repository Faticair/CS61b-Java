import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArraySet<T> implements Iterator<T> {

    private T[] items;
    private int size;
    private int cursor;

    public ArraySet() {
        items = (T[])new Object[100];
        size = 0;
        cursor = 0;
    }

    public boolean hasNext(){
        return cursor <= size;
    }

    public T next(){
        cursor += 1;
        if (cursor > size){
            throw new NoSuchElementException();
        }
        else {
            return items[cursor];
        }
    }
    
    public int size() {
        return size;
    }

    public boolean contains(T x) {
        if (size == 0){
            return false;
        }
        for (int i = 0; i < size; i++){
            if (items[i] == x){
                return true;
            }
        }
        return false;
    }

    public void add(T x){
        if (this.contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }
}
