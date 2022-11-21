import java.util.ArrayList;
import java.util.List;

public class Trieset {
    private static final int R = 128; // ASCII
    private Node root;    // root of trie

    // Bad space usage with good performance.
    private static class Node {
        private boolean isKey;   
        private DataIndexedCharMap next;

        private Node(boolean blue, int R) {
            isKey = blue;
            next = new DataIndexedCharMap<Node>(R);
        }
    }

    public Trieset(){
        this.root = new Node(false, R);
    }

    public List<String> collect(){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < this.R; i++){
            colHelper(String.valueOf((char)i), result, (Trieset.Node) this.root.next.get((char)i));
        }
        return result;
    }

    private void colHelper(String c, List<String> resTmp, Node n){
        if (n == null){
            return;
        }
        if (n.isKey){
            resTmp.add(c);
        }
        for (int j = 0; j < this.R; j++) {
            colHelper(c + String.valueOf((char)j), resTmp, (Trieset.Node) n.next.get((char)j));
        }
    }

    public void add(String inputString){
        char[] inputChars = inputString.toCharArray();
        Node p = root;
        for (int i = 0; i < inputChars.length; i++ ){
            if (p.next.get(inputChars[i]) == null){
                p.next.put(inputChars[i], new Node(false, R));
            }
            p = (Trieset.Node)p.next.get(inputChars[i]);
            if (i == inputChars.length - 1){
                p.isKey = true;
            }
        }
    }

    public static void main(String[] args) {
        Trieset testTrieSet = new Trieset();
        testTrieSet.add("null");
        testTrieSet.add("new");
        testTrieSet.add("newyork");
        System.out.println(testTrieSet.collect());
    }

}
