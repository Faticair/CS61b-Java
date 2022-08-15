public class IntListTest {
    public static void main(String[] args) {
        IntList test = IntList.of(1,2,3,4);
        IntList test1 = IntList.of(5,6);
        // IntList.dSquareList(test);
        // IntList.squareListIterative(test);
        // IntList.squareListRecursive(test).IntListPrint();
        // test.IntListPrint();

        // IntList.dcatenate(test, test1);
        // test.IntListPrint();

        IntList res = IntList.catenateRecursive(test, test1);
        res.IntListPrint();
        
    }
}
