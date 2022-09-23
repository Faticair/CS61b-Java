public class RotatingSLList<Item> extends SLList<Item> {

    public RotatingSLList(SLList<Item>.ListNode first) {
        super(first);
    }

    public void rotateRight(){
        if (this.first == null | this.first.next == null){
            return;
        }
        Item x = this.removeLast();
        this.addFirst(x);
    }
    
}
