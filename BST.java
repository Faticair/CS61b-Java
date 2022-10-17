public class BST<Key> {
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
}
