public class BST<Key extends Comparable<Key>> {
    private Key key;
    private BST left;
    private BST right;

    public BST(Key k, BST l, BST r){
        this.key = k;
        this.left = l;
        this.right = r;
    }

    public BST(Key k){
        this.key = k;
    }

    public BST search(BST T, Key k){
        if (T == null){
            return null;
        }
        if (k.equals(T.key)){
            return T;
        }
        else if (k.compareTo((Key) T.key) < 0){
            return search(T.left, k);
        }
        else{
            return search(T.right, k);
        }
    }

    public BST insert(BST T, Key k){
        if (T == null){
            return new BST(k);
        }
        if (k.compareTo((Key)T.key) < 0){
            T.left = insert(T.left, k);
        }
        else if (k.compareTo((Key)T.key) > 0){
            T.right = insert(T.right, k);
        }
        return T;
    }
}
