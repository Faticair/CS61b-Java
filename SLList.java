public class SLList<Item> implements List61B<Item> {
    public class ListNode{
        public Item item;
        public ListNode next;
        
        public ListNode(Item item, ListNode next){
            this.item = item;
            this.next = next;
        }
    }

    public ListNode first;

    public SLList(ListNode first){
        this.first = first;
    }

    public void addFirst(Item x){
        first = new ListNode(x, first);
    }

    public void addLast(Item y){
        if (this.first == null){
            first = new ListNode(y, first);
            return;
        }
        ListNode p = this.first;
        while (p.next != null){
            p = p.next;
        }
        p.next = new ListNode(y, p.next);
    }

    public void insert(Item item, int position){
        if (position == 0){
            addFirst(item);
            return;
        }
        ListNode p = first;
        while(position != 1){
            p = p.next;
            position -= 1;
            if (p.next == null){
                break;
            }
        }
        p.next = new ListNode(item, p.next);
    }

    public void reverse(){
        if (first.next == null){
            return;
        }
        ListNode p = first.next;
        first.next = null;
        if (p.next == null){
            p.next = first;
            first = p;
            return;
        }
        ListNode q = p.next;
        p.next = first;
        if (q.next == null){
            q.next = p;
            first = q;
            return;
        }
        ListNode k = q.next;
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
        ListNode p = this.first;
        while(p != null){
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
        System.out.println("\n");
    }

    public Item getFirst(){
        return this.first.item;
    }

    public Item getLast(){
        ListNode p = this.first;
        while (p.next != null){
            p = p.next;
        }
        return p.item;
    }

    public Item removeLast(){
        ListNode p = this.first;
        ListNode q = p;
        while (p.next != null){
            q = p;
            p = p.next;
        }
        Item res = p.item;
        q.next = null;
        return res;
    }

    public Item get(int i){
        ListNode p = this.first;
        while (i > 0){
            p = p.next;
            i -= 1;
            if (p.next == null){
                return null;
            }
        }
        return p.item;
    }

    public int size(){
        ListNode p = this.first;
        if (this.first == null){
            return 0;
        }
        int sizeCounter = 1;
        while (p.next != null){
            p = p.next;
            sizeCounter += 1;
        }
        return sizeCounter;
    }
}
