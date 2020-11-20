package Searching;

class InsertSearch {
    public static void main(String[] args) {
        int[] x = new int[100];
        for (int i = 0; i < x.length; i++) {
            x[i] = i+1;
        }
        int z = 100;
        int index = insertSearch(x,0,x.length-1,z);
        if (index != -1) {
            System.out.printf("Find value %d, index: %d\n",z,index);
        } else {
            System.out.printf("Cannot find value %d\n",z);
        }
    }
    static int insertSearch (int[] x, int low, int high, int value) {
        // check stop condition
        if (low > high || value < x[low] || value > x[high]) {
            return -1;
        }
        // define mid point
        int mid = low+(high-low)*(value-x[low])/(x[high]-x[low]);
        // recursion
        if (value < x[mid]) {
            // left recursion
            return insertSearch(x,low,mid-1,value);
        } else if (value > x[mid]) {
            return insertSearch(x,mid+1,high,value);
        } else {
            return mid;
        }
    }
}