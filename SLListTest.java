public class SLListTest {
    public static void main(String[] args) {
        /**
        SLList test = new SLList(null);
        test.addFirst(10);
        test.addFirst(6);
        test.addFirst(5);
        test.addFirst(1);
        test.insert(100, 2);
        test.reverse();
        test.printSLList();
        */
        AList<Integer> test = new AList<>();
        for (int i = 0; i < 10; i++){
            test.addLast(i);
        }
        test.addFirst(99);
        System.out.println(test.getFirst());
        System.out.println(test.getLast());
        test.insert(100, 5);
        System.out.println(test.removeLast());
        test.printList();
    }
}
