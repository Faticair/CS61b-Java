public class SLList {
    private class IntNode{
        public int item;
        public IntNode next;
        
        public IntNode(int item, IntNode next){
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public SLList(IntNode first){
        this.first = first;
    }

    public void addFirst(int x){
        first = new IntNode(x, first);
    }

    public void insert(int item, int position){
        if (position == 0){
            addFirst(item);
            return;
        }
        IntNode p = first;
        while(position != 1){
            p = p.next;
            position -= 1;
            if (p.next == null){
                break;
            }
        }
        p.next = new IntNode(item, p.next);
    }

    public void reverse(){
        if (first.next == null){
            return;
        }
        IntNode p = first.next;
        first.next = null;
        if (p.next == null){
            p.next = first;
            first = p;
            return;
        }
        IntNode q = p.next;
        p.next = first;
        if (q.next == null){
            q.next = p;
            first = q;
            return;
        }
        IntNode k = q.next;
        while (k != null){
            q.next = p;
            p = q;
            q = k;
            k = k.next;
        }
        q.next = p;
        first = q;
    }

    public void printSLList(){
        IntNode p = this.first;
        while(p != null){
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
        System.out.println("\n");
    }
}
