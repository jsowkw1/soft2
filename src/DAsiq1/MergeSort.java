package DAsiq1;

public class MergeSort {

    private static final int CUTOFF = 16; // small-n cutoff (Insertion Sort)
    private static long comparisons = 0;
    private static int maxDepth = 0;

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 3};
        sort(arr);


        for (int x : arr) {
            System.out.print(x + " ");
        }

        // метрики
        System.out.println("\nComparisons: " + comparisons);
        System.out.println("Max recursion depth: " + maxDepth);
    }

    public static void sort(int[] arr) {
        int[] buffer = new int[arr.length];
        comparisons = 0;
        maxDepth = 0;
        sort(arr, buffer, 0, arr.length - 1, 0);
    }

    private static void sort(int[] arr, int[] buffer, int left, int right, int depth) {
        if (left >= right) return;


        if (depth > maxDepth) maxDepth = depth;


        if (right - left + 1 <= CUTOFF) {
            insertionSort(arr, left, right);
            return;
        }

        int mid = left + (right - left) / 2;
        sort(arr, buffer, left, mid, depth + 1);
        sort(arr, buffer, mid + 1, right, depth + 1);

        merge(arr, buffer, left, mid, right);
    }

    private static void merge(int[] arr, int[] buffer, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;


        System.arraycopy(arr, left, buffer, left, right - left + 1);

        while (i <= mid && j <= right) {
            comparisons++;
            if (buffer[i] <= buffer[j]) {
                arr[k++] = buffer[i++];
            } else {
                arr[k++] = buffer[j++];
            }
        }

        while (i <= mid) {
            arr[k++] = buffer[i++];
        }
        while (j <= right) {
            arr[k++] = buffer[j++];
        }
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                j--;
            }
            if (j >= left) comparisons++;
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(int[] arr, int i, int i1) {
    }
}
