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
    }
}
