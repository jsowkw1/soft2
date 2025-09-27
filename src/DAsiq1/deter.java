package DAsiq1;

import java.util.Arrays;

public class deter {


    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int k = 3;
        int result = deterministicSelect(arr, k);

        System.out.println(k + "-th element: " + result);
        Arrays.sort(arr);
        System.out.println("checking "+arr[k]);
    }


    public static int deterministicSelect(int[] arr, int k) {
        return select(arr, 0, arr.length - 1, k);
    }

    private static int select(int[] arr, int left, int right, int k) {

        return 0;
    }
}