package Searching;
import java.util.ArrayList;

class BinarySearch {
    public static void main(String[] args) {
        // test linear search for unique values
        int[] x = {1,2,3,4,5,6,7};
        int z = 7;
        int index = binarySearch(x,0,x.length-1,z);
        if (index != -1) {
            System.out.printf("Find value %d, index: %d\n",z,index);
        } else {
            System.out.printf("Cannot find value %d\n",z);
        }
        // test linear search for multiple values
        int[] y = {1,2,3,4,4,4,4,5,6};
        int w = 4;
        System.out.println(binarySearchOptimize(y,0,y.length-1,w));

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
    static ArrayList binarySearchOptimize(int[] x, int left, int right, int value) {
        if (left > right) {
            return new ArrayList();
        }
        int mid = (left+right)/2;
        int midValue = x[mid];
        if (midValue < value) {
            // search right
            return binarySearchOptimize(x,mid+1,right,value);
        } else if (midValue > value) {
            // search left
            return binarySearchOptimize(x,left,mid-1,value);
        } else {
           // define a list to add all index
           ArrayList<Integer> list = new ArrayList<>();
           // left scan
           int temp = mid-1;
           while (temp >= 0 && x[temp] == value) {
               list.add(temp);
               temp--;
           }
           list.add(mid);
           // right scan
           temp = mid+1;
           while (temp <= x.length-1 && x[temp] == value) {
               list.add(temp);
               temp++;
           }
           return list;
        }
    }
}
