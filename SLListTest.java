public class SLListTest {
    public static void main(String[] args) {
        SLList test = new SLList(null);
        test.addFirst(10);
        test.addFirst(6);
        test.addFirst(5);
        test.addFirst(1);
        test.insert(100, 2);
        test.reverse();
        test.printSLList();
        
    }
}
