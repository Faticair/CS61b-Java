import Project1.ArrayDeque;
import Project1.LinkedListDeque;

public class LinkedListDequeTest {
    public static void main(String[] args) {
        LinkedListDeque<Integer> intList = new LinkedListDeque<>();
        intList.addFirst(1);
        intList.addLast(2);
        intList.addLast(3);
        intList.addFirst(0);
        System.out.println(intList.get(1));
        System.out.println(intList.removeLast());
        intList.printDeque();
        LinkedListDeque<Integer> copyDeque = new LinkedListDeque<>(intList);
        System.out.println(copyDeque.removeFirst());
        copyDeque.addFirst(9);
        copyDeque.printDeque();

        LinkedListDeque<String> strList = new LinkedListDeque<>();
        strList.addFirst("Hello,");
        strList.addLast("world.");
        strList.printDeque();

        ArrayDeque<Integer> intArray = new ArrayDeque<>();
        intArray.addLast(3);
        intArray.addFirst(2);
        intArray.addLast(8);
        intArray.addFirst(1);
        System.out.println(intArray.get(1));
        System.out.println(intArray.removeLast());
        intArray.printDeque();
        ArrayDeque<Integer> copyArrayDeque = new ArrayDeque<>(intArray);
        copyArrayDeque.addLast(100);
        copyArrayDeque.addFirst(0);
        intArray.printDeque();
        copyArrayDeque.printDeque();
    }
}
