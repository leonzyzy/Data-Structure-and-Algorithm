package SortingAlgrothimns;
import java.util.Arrays;

// Time complexity: 0(n^2)

class BubbleSort {
    public static void main(String[] args) {
        int[] x = {7,8,1,2,3,4,6};
        bubbleSort(x);
        System.out.println("After optimize code:");
        int[] y = {7,8,1,2,3,4,6};
        bubbleSortOptimize(y);
    }

    // bubble sort
    static void bubbleSort(int[] x) {
        // iterate each number
        for (int i = 0; i < x.length-1; i++) {
            int temp = 0;
            // compare each number
            for (int j = 0; j < x.length-1-i; j++) {
                // swap
                if (x[j] > x[j+1]) {
                    temp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = temp;
                }
            }
            System.out.println(i+1 + "th: "+ Arrays.toString(x));
        }
    }
    // optimize bubble sort
    static void bubbleSortOptimize(int[] x) {
        // iterate each number
        for (int i = 0; i < x.length-1; i++) {
            int temp = 0;
            // compare each number
            for (int j = 0; j < x.length-1-i; j++) {
                // swap
                if (x[j] > x[j+1]) {
                    temp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = temp;
                }
            }
            if (temp == 0) {
                break;
            }
            System.out.println(i+1 + "th: "+ Arrays.toString(x));
        }
    }
}