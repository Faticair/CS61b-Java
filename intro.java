public class intro {
    /** These codes are mentioned in the intro lecture, for pratice*/
    public static int larger(int x, int y){
        if(x > y){
            return x;
        }
        return y;
    }
    /** Exercise 1b: Drawing a Triangle with Method */
    public static void drawTriangle(int N){
        if( N == 0){
            System.out.println("N is 0, no triangle.");
        }
        else{
            String output = "";
            while (N > 0){
                output = output + "*";
                System.out.println(output);
                N = N - 1;
            }
        }
    }
    /** Exercise 2: find max number in an array. */
    public static int max(int[] m){
        int mlength = m.length - 1;
        int maxnumber = m[0];
        while (mlength >= 0) {
            if(maxnumber < m[mlength]){
                maxnumber = m[mlength];
            }
            mlength = mlength - 1;
        }
        return maxnumber;
    }

    /** Exercise 3: find max number in an array using for loop. */
    public static int maxForLoop(int[] m){
        int mlength = m.length - 1;
        int maxnumber = 0;
        for(int i = 0; i < mlength; i++){
            if(maxnumber < m[i]){
                maxnumber = m[i];
            }
        }
        return maxnumber;
    }

    /** Exercise 4: Add a[i] through a[i+n] */
    public static void windowPosSum(int[] a, int n){
        for(int i = 0; i < a.length - 1; i++){
            if(a[i] < 0){
                continue;
            }
            else if(i == a.length - 1){
                continue;
            }
            else{
                int sum = a[i];
                for(int j = 1; j <= n; j++){
                    if(i + j >= a.length){
                        break;
                    }
                    sum = sum + a[i+j];
                }
                a[i] = sum;
            }
        }
        System.out.println(java.util.Arrays.toString(a));
    }
    public static void main(String[] args) {
        // System.out.println("Hello, world!");
        
        // int x = 0;
        // while(x < 10){
        //     System.out.println(x);
        //     x = x + 1;
        // }

        // System.out.println(larger(-2, 1));

        /** HW 0 is praticed below. */
        /** Exercise 1a: Drawing a Triangle */
        // int lines = 1;
        // String output = "";
        // while (lines > 0){
        //     output = output + "*";
        //     System.out.println(output);
        //     lines = lines - 1;
        // }

        /** Exercise 1b: Drawing a Triangle with Method */
        // drawTriangle(10);

        /** Exercise 2: find max number in an array. */
        // int[] numbers = new int[]{9,12,33,2,15,1,2,6};
        // System.out.println(max(numbers));

        /** Exercise 3: find max number in an array using for loop. */
        // System.out.println(maxForLoop(numbers));
        
        /** Exercise 4: Add a[i] through a[i+n] */
        // int[] a = new int[]{1,2,-3,4,5,4};
        // windowPosSum(a, 3);

        /** Enhanced for loop */
        int[] aa = {1,2,3,4,5,6};
        for(Integer x: aa){
            System.out.println(x);
        }

    }
}
