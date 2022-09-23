public class SLListTest {
    public static void main(String[] args) {
        /** SLList test */
        SLList<Integer> test = new SLList<>(null);
        for (int i = 0; i < 10; i++){
            test.addLast(i);
        }
        test.addFirst(99);
        System.out.println(test.getFirst());
        System.out.println(test.getLast());
        test.insert(100, 5);
        System.out.println(test.removeLast());
        test.printSLList();

        RotatingSLList<Integer> testR = new RotatingSLList<>(null);
        for (int j = 1; j < 10; j += 2){
            testR.addLast(j*2);
        }
        testR.printSLList();
        testR.rotateRight();
        testR.printSLList();
        
        /** AList test:
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
        */
    }
}
