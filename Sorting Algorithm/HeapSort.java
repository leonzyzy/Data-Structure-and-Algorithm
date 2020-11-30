package SortingAlgrothimns;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] x = {3,5,7,6,2,4,9};
        heapSort(x);
        System.out.println(Arrays.toString(x));
    }
    // heap sort
    public static void heapSort(int[] x) {
        // define a temp for swapping value
        int temp = 0;
        // adjust node for each non-leaf nodes
        for (int i = (x.length/2)-1; i >= 0; i--) {
            adjust(x,i,x.length);
        }
        // repeat building a max heap and swap top value to end
        // each max heap will exclude last node
        for (int j = x.length-1; j > 0; j--) {
            temp = x[j];
            x[j] = x[0];
            x[0] = temp;
            // after first max heap, only work on root node
            adjust(x,0,j);
        }
    }
    // adjust node to build a max heap
    public static void adjust(int[] x, int i, int length) {
        int temp = x[i]; // i: current node, i = l/2-1
        for (int k = 2*i+1; k < length; k = 2*k+1) {
            // adjusting
            // start from last non-leaf node
            // k = 2*k+1: after swap, needs to re-adjust again
            if (k+1 < length && x[k] < x[k+1]) {
                // k+1: avoid null pointer
                // check if left leaf < right leaf
                k++; // point to right
            }
            if (temp < x[k]) {
                // check if parent node < leaf node
                x[i] = x[k]; // swap
                i = k; // point parent to leaf for re-adjusting if needs
            } else {
                // if parent node > leaf node, just break, since it starts from bottom to top.
                break;
            }
        }
        x[i] = temp; // finish swap after loop;
    }
}