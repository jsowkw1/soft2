package DAsiq1;

import java.util.Random;

public class SortComparison {

    public static int[] generateArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000};

        for (int size : sizes) {
            System.out.println("Test size: " + size);

            int[] arr1 = generateArray(size);
            int[] arr2 = arr1.clone();

            long startMerge = System.nanoTime();
            MergeSort.mergeSort(arr1, 0, arr1.length - 1);
            long endMerge = System.nanoTime();
            long mergeTime = endMerge - startMerge;

            long startQuick = System.nanoTime();
            QuickSort.quickSort(arr2, 0, arr2.length - 1);
            long endQuick = System.nanoTime();
            long quickTime = endQuick - startQuick;

            System.out.println("MergeSort: " + mergeTime + " ns");
            System.out.println("QuickSort: " + quickTime + " ns");
            System.out.println("----------------------------------");
        }
    }
}
