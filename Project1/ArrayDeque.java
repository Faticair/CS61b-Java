package Project1;

public class ArrayDeque<T> {
    
    private T[] items;
    private int size;

    public ArrayDeque(){
        this.items = (T[]) new Object[8];
        size = 0;
    }

    public ArrayDeque(ArrayDeque other){
        this.items = (T[]) new Object[8];
        this.size = 0;
        for (int i = 0; i < other.size; i++){
            this.addLast((T)other.items[i]);
        }
    }

    public void resize(int newSize){
        T[] res = (T[]) new Object[newSize];
        System.arraycopy(this.items, 0, res, 0, size);
        this.items = res;
    }

    public void addFirst(T item){
        if (size == items.length){
            resize(size * 2);
        }
        if (size == 0){
            items[size] = item;
            size += 1;
        } else {
            T[] res = (T[]) new Object[items.length];
            res[0] = item;
            System.arraycopy(items, 0, res, 1, size);
            items = res;
            size += 1;
        }
    }

    public void addLast(T item){
        if (size == items.length){
            resize(size * 2);
        }
        items[size] = item;
        size += 1;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i = 0; i < size; i++){
            System.out.print(items[i]);
            System.out.print(" ");
        }
        System.out.println("\n");
    }

    public T removeFirst(){
        T res = items[0];
        T[] tmp = (T[]) new Object[items.length];
        System.arraycopy(items, 1, tmp, 0, size - 1);
        items = tmp;
        size -= 1;
        if (size < items.length / 2){
            resize(items.length / 2);
        }
        return res;
    }

    public T removeLast(){
        T res = items[size - 1];
        T[] tmp = (T[]) new Object[items.length];
        System.arraycopy(items, 0, tmp, 0, size - 1);
        items = tmp;
        size -= 1;
        if (size < items.length / 2){
            resize(items.length / 2);
        }
        return res;
    }

    public T get(int index){
        return items[index];
    }
}
