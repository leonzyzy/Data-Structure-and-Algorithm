package SortingAlgrothimns;

import java.util.Arrays;

class InsertSort {
    public static void main(String[] args) {
        int[] x = {7, 6, 9, 10, 5};
        insertSort(x);
    }
    static void insertSort(int[] x) {
        // for each value
        for (int i = 1; i < x.length; i++) {
            // start from second value
            int insertVal = x[i];
            int insertPos = i-1;

            // iterate
            while (insertPos >= 0 && x[insertPos] > insertVal) {
                // assign insert value to previous index
                // ex: 101, 34, 119, 1 => 101, 101, 119, 1 => 34, 101, 119, 1
                x[insertPos+1] = x[insertPos];
                insertPos--;
            }
            // re assign insert value to insert index
            x[insertPos+1] = insertVal;
        }
        System.out.println(Arrays.toString(x));
    }
}
