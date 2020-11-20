package SortingAlgrothimns;
import java.util.Arrays;

// Time complexity: 0(n^2)

class SelectionSort {
    public static void main(String[] args) {
        int[] y = {7, 6, 9, 10, 5};
        selectSort(y);

        System.out.println("After optimize code:");
        int[] x = {7, 6, 9, 10, 5};
        selectSortOptimize(x);
    }

    // select sort
    static void selectSort(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            int min = x[i];
            int minIndex = i;
            for (int j = minIndex + 1; j < x.length; j++) {
                if (x[j] < min) {
                    minIndex = j;
                    min = x[minIndex];
                }
            }
            // swap
            x[minIndex] = x[i];
            x[i] = min;
        }
    }

    // optimize code
    static void selectSortOptimize(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            int min = x[i];
            int minIndex = i;
            for (int j = minIndex + 1; j < x.length; j++) {
                if (x[j] < min) {
                    minIndex = j;
                    min = x[minIndex];
                }
            }
            // swap if index change
            if (minIndex != i) {
                x[minIndex] = x[i];
                x[i] = min;
                System.out.println(Arrays.toString(x));
            }
        }
    }
}