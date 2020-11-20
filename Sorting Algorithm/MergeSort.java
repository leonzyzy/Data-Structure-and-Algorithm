package SortingAlgrothimns;
import java.util.Arrays;

class MergeSort {
    public static void main(String[] args) {
        int[] x = {8,4,5,1,7,3,6,2};
        int[] temp = new int[x.length];
        mergeSort(x,0,x.length-1,temp);
        System.out.println(Arrays.toString(x));
    }
    // merge sort
    static void mergeSort(int[]x, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left+right)/2;
            // divide
            mergeSort(x,left,mid,temp);
            mergeSort(x,mid+1,right,temp);
            // conquer
            merge(x,left,mid,right,temp);
        }
    }
    // conquer
    static void merge(int[]x, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid+1;
        int t = 0; // index for temp array
        // iterate
        while (i <= mid && j <= right) {
            if (x[i] <= x[j]) {
                temp[t] = x[i];
                i++;
            } else {
                temp[t] = x[j];
                j++;
            }
            t++;
        }
        // check which side left values
        while (i <= mid) {
            // if left side has values
            temp[t] = x[i];
            i++;
            t++;
        }
        while (j <= right) {
            // if right side has values
            temp[t] = x[j];
            j++;
            t++;
        }
        // copy values from temp to input array
        int tempLeft = left;
        t = 0;
        while (tempLeft <= right) {
            x[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }
}
