package Searching;

class LinearSearch {
    public static void main(String[] args) {
        int[] x = {1,3,4,5,2,6,7,8};
        int z = 7;
        int index = linearSearch(x,z);
        if (index != -1) {
            System.out.printf("Find value %d, at index %d",z,index);
        } else {
            System.out.printf("Cannot find value %d",z);
        }
    }
    static int linearSearch(int[] x, int value) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
