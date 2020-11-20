package LinkedList;
import java.util.Stack;

// test demo
public class LinkedListDemo {
    public static void main(String[] args) {
        Node n1 = new Node(1,"a");
        Node n2 = new Node(2,"b");
        Node n4 = new Node(4,"c");
        Node n3 = new Node(3,"c");

        LinkedList list = new LinkedList();
        list.add(n1);
        list.add(n2);
        list.add(n4);

        System.out.println("Testing add");
        list.showList();

        System.out.println("\n\nTesting add by order");
        list.addByOrder(n3);
        list.showList();
        System.out.println("\n\nTesting size");
        System.out.println(list.size());

        System.out.println("\nTesting reverse linked list");
        list.reverseLinkedList();
        list.showList();

        System.out.println("\n\nTesting reverse print");
        list.reversePrint();


        list.update(new Node(3, "e"));
        list.update(new Node(1, "g"));
        System.out.println("\n\nTesting update");
        list.showList();

        System.out.println("\n\nTesting remove");
        list.remove(1);
        list.showList();

        System.out.println("\n\nTesting search");
        System.out.println(list.search(2));
        System.out.println(list.search(3));
        System.out.println(list.search(4));
        System.out.println(list.search(5));
    }
}

// link list
class LinkedList {
    // head node only use as pointer
    private Node head = new Node(0,"");

    // add method
    public void add(Node node) {
        // create a temp node
        Node temp = head;

        // find the tail
        while (temp.next != null) {
            temp = temp.next;
        }
        // once reach to tail, add new node
        temp.next = node;
    }
    // add by order method
    public void addByOrder(Node node) {
        // create a temp node
        Node temp = head;

        // find the index of adding
        while (temp.next != null) {
            // if node is already in linked list
            if (temp.next.id == node.id) {
                System.out.println("New node already in linked list");
                return;
            } else if (temp.next.id > node.id) {
                // find that add index
                break;
            } else {
                // keep iterate
                temp = temp.next;
            }
        }
        node.next = temp.next;
        temp.next = node;
    }
    // get length method
    public int size() {
        // check if is empty
        if (head.next == null) {
            return 0;
        }
        Node currNode = head.next;
        int length = 0;
        while (currNode != null) {
            length ++;
            currNode = currNode.next;
        }
        return length;
    }

    // remove method
    public void remove(int id) {
        // create a current node
        Node currNode = head;

        // check if is empty
        if (currNode.next == null) {
            System.out.println("Empty linked list");
            return;
        }
        // find the previous node of the node we want to remove
        while (currNode.next != null) {
            // if we find its id
            if (currNode.next.id == id) {
                // remove it
                currNode.next = currNode.next.next;
                return;
            }
            currNode = currNode.next;
        }
        // if does not find
        if (currNode.next == null) {
            System.out.printf("id: %d is not in the linked list",id);
            return;
        }
    }
    // search method
    public String search(int id) {
        // create a current node
        Node currNode = head.next;

        // check if is empty
        if (currNode.next == null) {
            System.out.println("Empty linked list");
        }
        // iterate and ind its id
        while (currNode != null) {
            if (currNode.id == id) {
                return currNode.value;
            }
            currNode = currNode.next;
         }
        return null;
    }


    // update value method
    public void update (Node node) {
        // create a temp node
        Node temp = head;
        if (temp.next == null) {
            // if empty list
            System.out.println("Empty linked list");
            return;
        }
        // find the index of its node
        while (temp.next != null) {
            // if finds
            if (temp.next.id == node.id) {
                temp.next.value = node.value;
                return;
            }
            temp = temp.next;
        }
        // if does not find
        if (temp.next == null) {
            System.out.println("Cannot find " + node.toString());
            return;
        }
    }
    // iterate linked list
    public void showList() {
        // create a temp node
        Node temp = head.next;

        // check if is a empty list
        if (temp == null) {
            System.out.println("Empty linked list");
            return;
        }
        // if not empty
        while (temp != null) {
            System.out.print(temp.toString()+" ");
            temp = temp.next;
        }
    }
    // reverse linked list
    public void reverseLinkedList() {
        // check if is empty or only one node
        if (head.next == null || head.next.next == null) {
            return;
        }
        // create some variables
        Node currNode = head.next; // current node
        Node nextNode = null; // next node
        Node reverseHead = new Node(0,""); // a temp head

        // iterate
        while (currNode != null) {
            nextNode = currNode.next; // mark next node
            currNode.next = reverseHead.next; // link to null for first step
            reverseHead.next = currNode;
            currNode = nextNode;
        }
        // link head node to current node
        head.next = reverseHead.next;
    }
    // reverse print node
    // usage: Stack ADT
    public void reversePrint() {
        Stack<Node> stack = new Stack<Node>();
        // check if is empty node
        if (head.next == null) {
            System.out.println("Empty list");
        }
        Node currNode = head.next;
        while (currNode != null) {
            // push into stack
            stack.push(currNode);
            currNode = currNode.next;
        }
        // print
        while (stack.size() > 0) {
            System.out.println(stack.pop().toString());
        }
    }
}
// Node class
class Node {
    int id;
    String value;
    Node next;

    public Node(int id, String value) {
        this.id = id;
        this.value = value;
    }
    @Override
    public String toString() {
        return "{" + "id=" + id + ", value='" + value + '\'' + '}';
    }
}

