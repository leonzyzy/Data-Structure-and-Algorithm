package HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int[] x = {13,7,8,3,29,6,1};
        Node root = huffManTree(x);
        preOrder(root);
    }
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("Empty node");
        }
    }

    /***
     * @param x: input an array
     * @return: a node from huffman tree
     */
    public static Node huffManTree(int[] x) {
        // define a list and put all value from array into list
        ArrayList<Node> list = new ArrayList<>();
        for (int value : x) {
            list.add(new Node(value));
        }
        // produce a huffman tree
        while (list.size() > 1) {
            // sort list
            Collections.sort(list);
            System.out.println(list);

            Node leftNode = list.get(0);
            Node rightNode = list.get(1);

            // define a new parent node
            Node parentNode = new Node(leftNode.value+rightNode.value);
            parentNode.left = leftNode;
            parentNode.right = rightNode;
            list.remove(leftNode);
            list.remove(rightNode);
            list.add(parentNode);
        }
        return list.get(0);
    }
}

// define a node class
class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }
}
