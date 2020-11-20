package Searching;

class BinarySearch {
    public static void main(String[] args) {
        int[] x = {1,2,3,4,5,6,7};
        int z = 7;
        int index = binarySearch(x,0,x.length-1,z);
        if (index != -1) {
            System.out.printf("Find value %d, index: %d",z,index);
        } else {
            System.out.printf("Cannot find value %d",z);
        }
    }
    static int binarySearch(int[] x, int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        int mid = (left+right)/2;
        int midValue = x[mid];
        if (midValue < value) {
            // search right
            return binarySearch(x,mid+1,right,value);
        } else if (midValue > value) {
            // search left
            return binarySearch(x,left,mid-1,value);
        } else {
            return mid;
        }
    }
}