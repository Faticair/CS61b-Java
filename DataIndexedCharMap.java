public class DataIndexedCharMap<V> {
        private V[] items;
        
        public DataIndexedCharMap(int R) {
            items = (V[]) new Object[R];
        }

        public void put(char c, V val) {
            items[c] = val;
        }

        public V get(char c) {
            return items[c];
        }
    }

