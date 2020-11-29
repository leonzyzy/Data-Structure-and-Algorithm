package BinaryTree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        // define a binary tree
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1, "a");
        Node node2 = new Node(2, "b");
        Node node3 = new Node(3, "c");
        Node node4 = new Node(4, "d");
        Node node5 = new Node(5, "e");
        Node node6 = new Node(6, "f");
        Node node7 = new Node(7, "g");

        // set left and right
        binaryTree.setRoot(root);
        root.setLeft(node2);
        node2.setLeft(node4);
        node2.setRight(node5);
        root.setRight(node3);
        node3.setLeft(node6);
        node3.setRight(node7);

        binaryTree.preOrderSearch(6);
        System.out.print(binaryTree.preOrderSearch(6));

        // test pre order
        //binaryTree.preOrder();
       // System.out.println();

        // test mid order
        //binaryTree.midOrder();
        //System.out.println();

        // test post order
        //binaryTree.postOrder();

    }
}

// define a binary tree
class BinaryTree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    // delete node
    public void delNode(int id) {
        if (root != null) {
            if (root.getId() == id) {
                root = null;
            } else {
                root.delNode(id);
            }
        } else {
            System.out.println("Empty tree");
        }
    }

    // preOrder
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("Empty binary tree");
        }
    }

    // midOrder
    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        } else {
            System.out.println("Empty binary tree");
        }
    }

    // postOrder
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("Empty binary tree");
        }
    }

    // pre order search
    public Node preOrderSearch(int id) {
        if (this.root == null) {
            return null;
        }
        return this.root.preOrderSearch(id);
    }

    // mid order search
    public Node midOrderSearch(int id) {
        if (this.root == null) {
            return null;
        }
        return this.root.midOrderSearch(id);
    }
    // post order search
    public Node postOrderSearch(int id) {
        if (this.root == null) {
            return null;
        }
        return this.root.postOrderSearch(id);
    }

}

// define a node class
class Node{
    private int id;
    private String name;
    private Node left; // default null
    private Node right; // default null

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // define a delete note function
    public void delNode(int id) {
        if (this.left == null && this.left.id == id) {
            this.left = null;
            return;
        }
        if (this.right == null && this.right.id == id) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(id);
        }
        if (this.right != null) {
            this.right.delNode(id);
        }
    }
    // define preOrder
    public void preOrder() {
        // print current node (parent node)
        System.out.println(this);
        // recursive left subtree
        if (this.left != null) {
            this.left.preOrder();
        }
        // recursive right subtree
        if (this.right != null) {
            this.right.preOrder();
        }
    }
    // define midOrder
    public void midOrder() {
        // recursive left subtree
        if (this.left != null) {
            this.left.midOrder();
        }
        // print current node (parent node)
        System.out.println(this);
        // recursive right subtree
        if (this.right != null) {
            this.right.preOrder();
        }
    }
    // define postOrder
    public void postOrder() {
        // recursive left subtree
        if (this.left != null) {
            this.left.postOrder();
        }
        // recursive right subtree
        if (this.right != null) {
            this.right.postOrder();
        }
        // print current node (parent node)
        System.out.println(this);
    }
    public Node preOrderSearch(int id) {
        // compare current node
        if (this.id == id) {
            return this;
        }
        // compare with left subtree
        Node n = null;
        if (this.left != null) {
            n = this.left.preOrderSearch(id);
        }
        if (n != null) {
            return n;
        }
        if (this.right != null) {
            n = this.right.preOrderSearch(id);
        }
        return n;
    }
    public Node midOrderSearch(int id) {
        Node n = null;
        if (this.left != null) {
            n = this.left.midOrderSearch(id);
        }
        if (n != null) {
            return n;
        }
        if (this.id == id) {
            return this;
        }
        if (this.right != null) {
            n = this.right.midOrderSearch(id);
        }
        return n;
    }
    public Node postOrderSearch(int id) {
        Node n = null;
        if (this.left != null) {
            n = this.left.postOrderSearch(id);
        }
        if (n != null) {
            return n;
        }
        if (this.right != null) {
            n = this.right.postOrderSearch(id);
        }
        if (this.id == id) {
            return this;
        }
        return n;
    }
}