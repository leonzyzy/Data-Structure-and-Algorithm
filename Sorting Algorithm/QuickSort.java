package SortingAlgrothimns;
import java.util.Arrays;

class QuickSort {
    public static void main(String[] args) {
        // define an array
        int[] x = {8,4,5,1,7,3,6,2};
        System.out.println("Before sorting: " + Arrays.toString(x));
        quickSort(x,0,x.length-1);
        System.out.println("After sorting (quick sort): " + Arrays.toString(x));
    }

    // quicksort
    static void quickSort(int[] x, int left, int right) {
        // define l and r as two pointers
        int l = left;
        int r = right;

        // define pivot point
        int pivot = x[(left+right)/2];

        // define a temp variable for swapping values
        int temp = 0;

        // iterate when l < r
        while (l<r) {
            // small value left side and put larger value right side to pivot
            while (x[l] < pivot) {
                // find the index where x[l] < pivot
                l++;
            }
            while (x[r] > pivot) {
                // find the index where x[r] > pivot
                r--;
            }
            // stop condition
            if (l==r) {
                break;
            }
            // swap
            temp = x[l];
            x[l] = x[r];
            x[r] = temp;
            // if swap pivot, pointers must move
            if (x[l] == pivot) {
                r--;
            }
            if (x[r] == pivot) {
                l++;
            }
        }
        // after iteration, l = r
        // change the pointers for recursion
        if (l==r) {
            l++;
            r--;
        }
        // define the stop condition for left recursion
        if (left < r) {
            quickSort(x,left,r);
        }
        // define the stop condition for right recursion
        if (right > l) {
            quickSort(x,l,right);
        }
    }
}