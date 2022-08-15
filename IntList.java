public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    public static IntList of(Integer... args) {
        IntList result, p;
        if (args.length > 0) {
            result = new IntList(args[0], null);
        } else {
            return null;
        }
        int k;
        for (k = 1, p = result; k < args.length; k += 1, p = p.rest) {
            p.rest = new IntList(args[k], null);
        }
        return result;
    }
    
    public int size(){
        if(this.rest == null){
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int iterativeSize(){
        int totalsize = 0;
        IntList p = this;
        while(p != null){
            totalsize += 1;
            p = p.rest;
        }
        return totalsize;
    }

    public int get(int i){
        IntList p = this;
        while( i != 0){
            if (p.rest == null){
                break;
            }
            p = p.rest;
        }
        return p.first;
    }

    public void IntListPrint(){
        IntList p = this;
        while(p != null){
            System.out.println(Integer.toString(p.first));
            p = p.rest;
        }
    }

    /** Modify the IntList so that all of its elements are squared. */
    public static void dSquareList(IntList L){
        while( L != null){
            L.first = L.first * L.first;
            L = L.rest;
        }
    }

    /** Return a new IntList with all elements squared. */
    public static IntList squareListIterative(IntList L){
        if (L == null) {
            return null;
        }
        IntList squaredIntList = L;
        while( L != null){
            squaredIntList.first = L.first * L.first;
            L = L.rest;
            squaredIntList = squaredIntList.rest;
        }
        return squaredIntList;
    }

    /** Return a new IntList with all elements squared using recursion */
    public static IntList squareListRecursive(IntList L){
        if (L == null) {
            return null;
        }
        return new IntList(L.first * L.first, squareListRecursive(L.rest));
    }

    /** Modify A to a List consisting of all elements of A, following by all elements of B. */
    public static void dcatenate(IntList A, IntList B){
        if (B == null){
            return;
        }
        // IntList p = A;
        while( A.rest != null){
            A = A.rest;
        }
        A.rest = B;
    }

    /** Return an IntList consisting of all elements of A, following by all elements of B. */
    public static IntList catenate(IntList A, IntList B){
        IntList newIntList = new IntList(0, null);
        IntList p = newIntList;
        while (A.rest != null){
            p.first = A.first;
            A = A.rest;
            p.rest = new IntList(0, null);
            p = p.rest;
        }
        p.first = A.first;
        p.rest = new IntList(0, null);
        p = p.rest;
        while (B.rest != null){
            p.first = B.first;
            B = B.rest;
            p.rest = new IntList(0, null);
            p = p.rest;
        }
        p.first = B.first;
        return newIntList;
    }

    public static IntList catenateRecursive(IntList A, IntList B){
        if (A == null && B == null){
            return null;
        } else if (A == null && B != null){
            return new IntList(B.first, catenateRecursive(A, B.rest));
        } else{
            return new IntList(A.first, catenateRecursive(A.rest, B));
        }
    }
}
