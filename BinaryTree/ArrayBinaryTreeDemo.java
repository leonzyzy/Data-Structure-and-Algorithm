package BinaryTree;

public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        // define an array
        int[] x = {1,2,3,4,5,6,7};
        ArrayBinaryTree abt = new ArrayBinaryTree(x);
        abt.preOrder();
        abt.infixOrder();
        abt.postOrder();
    }
}

class ArrayBinaryTree {
    private int[] x;

    public ArrayBinaryTree(int[] x) {
        this.x = x;
    }
    // overwrite
    public void preOrder() {
        this.preOrder(0);
    }
    public void infixOrder() {
        this.infixOrder(0);
    }
    public void postOrder() {
        this.postOrder(0);
    }

    // pre order
    public void preOrder(int n) {
        if (x == null || x.length == 0) {
            System.out.println("Empty array.");
            return;
        }
        System.out.println(x[n]);
        if (2*n+1 < x.length) {
            preOrder(2*n+1);
        }
        if (2*n+2 < x.length) {
            preOrder(2*n+2);
        }
    }
    // infix order
    public void infixOrder(int n) {
        if (x == null || x.length == 0) {
            System.out.println("Empty array.");
        }
        if (2*n+1 < x.length) {
            infixOrder(2*n+1);
        }
        System.out.println(x[n]);
        if (2*n+2 < x.length) {
            infixOrder(2*n+2);
        }
    }
    // post order
    public void postOrder(int n) {
        if (x == null || x.length == 0) {
            System.out.println("Empty array.");
        }
        if (2*n+1 < x.length) {
            postOrder(2*n+1);
        }
        if (2*n+2 < x.length) {
            postOrder(2*n+2);
        }
        System.out.println(x[n]);
    }
}