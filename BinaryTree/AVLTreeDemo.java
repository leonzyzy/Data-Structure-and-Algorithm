package AVLTree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] x = {4,3,6,5,7,8};
        int[] y = {10,12,8,9,7,6};
        AVLTree avl = new AVLTree();
        //for (int val:x) {
           // avl.add(new Node(val));
        //}
        for (int val:y) {
            avl.add(new Node(val));
        }
        avl.infixOrder();
        System.out.println(avl.getRoot().height());
        System.out.println(avl.getRoot().leftHeight());
        System.out.println(avl.getRoot().rightHeight());
        System.out.println("Root:" + avl.getRoot());
    }
}

// AVL tree class
class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    // add method
    public void add(Node node) {
        if (root == null) {
            root = node; // if root is empty, then let root = node
        } else {
            root.add(node);
        }
    }
    // search node
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }
    // search parent node
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }
    // the input node will be treated as root of right tree
    // return min node of right tree
    // delete the root node of right tree
    public int delRightTreeMin(Node node) {
        Node currentNode = node;
        // iterate search left node, which is the min node of right tree
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        // current node is the min node of right tree
        // delete the currentNode, current node now is a leaf node
        delete(currentNode.value);
        // return the value
        return currentNode.value;
    }
    // delete node
    public void delete(int value) {
        if (root == null) {
            return;
        } else {
            // find the delete node
            Node targetNode = search(value);
            // check if cannot find targetNode
            if (targetNode == null) {
                return;
            }
            // if tree only has one node
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            // find parentNode of targetNode
            Node parentNode = searchParent(value);
            // if targetNode is a leaf node
            if (targetNode.left == null &&  targetNode.right == null) {
                // check targetNode is the left/right of parentNode
                if (parentNode.left != null && parentNode.left.value == value) {
                    parentNode.left = null;
                } else if (parentNode.right != null && parentNode.right.value == value) {
                    parentNode.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {  // a parent node with two leaves
                targetNode.value = delRightTreeMin(targetNode.right);
            } else {// a parent node with one leaf
                if (targetNode.left != null) {  // if targetNode has left node
                    // check if parent is null, in this case we are deleting root
                    if (parentNode != null) {
                        // if target node is the left node of parent
                        if (parentNode.left.value == value) {
                            parentNode.left = targetNode.left;
                        } else {
                            // if target node is the right node of parent
                            parentNode.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else { // if targetNode has right node
                    if (parentNode != null) {
                        if (parentNode.left.value == value) {
                            parentNode.left = targetNode.right;
                        } else {
                            parentNode.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }
    // infix order
    public void infixOrder() {
        if (root == null) {
            System.out.println("Empty tree");
        } else {
            root.infixOrder();
        }
    }
}

// node class
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    // get left height
    public int leftHeight() {
        return left == null? 0 : left.height();
    }
    // get right height
    public int rightHeight() {
        return right == null? 0 : right.height();
    }

    // get height
    public int height() {
        return Math.max(left == null? 0 : left.height(),
                right == null? 0 : right.height()) + 1;
    }
    // left rotate
    public void leftRotate() {
        // using current node as root
        Node newNode = new Node(this.value);
        // set newNode.left to be left node
        newNode.left = this.left;
        // set newNode.right to be right.left
        newNode.right = this.right.left;
        // replace the value of current node to be its right
        this.value = this.right.value;
        // set current node.right to be its right of right
        this.right = this.right.right;
        // set current node.left to be new node
        this.left = newNode;
    }
    // right rotate
    public void rightRotate() {
        // using current node as root
        Node newNode = new Node(this.value);
        // set newNode.right to be right node
        newNode.right = this.right;
        // set newNode.left to be left.right
        newNode.left = this.left.right;
        // replace the value of current node to be its left
        this.value = this.left.value;
        // set current node.left to be its left of left
        this.left = this.left.left;
        // set current node.right to be new node
        this.right = newNode;
    }
    // add method
    public void add(Node node) {
        if (node == null) {
            return;
        }
        // compare the node value with current node value
        if (this.value > node.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        // after adding a new node, if right height - left height > 1
        if (this.rightHeight() - this.leftHeight() > 1) {
            if (this.right != null && this.right.leftHeight() > this.right.rightHeight()) {
                this.right.rightRotate();
            }
            leftRotate();
        }
        // after adding a new node, if left height - right height > 1
        if (this.leftHeight() - this.rightHeight() > 1) {
            if (this.left != null && this.left.rightHeight() > this.left.leftHeight()) {
                this.left.leftRotate();
            }
            rightRotate();
        }
    }
    // search the node
    public Node search(int value) {
        if (value == this.value) {
            // if find, then return
            return this;
        } else if (value < this.value) { // if value < current value
            // check if left node is null
            if (this.left == null) {
                return null;
            } else {
                // search to left
                return this.left.search(value);
            }
        } else { // if value > current value
            // check if right node is null
            if (this.right == null) {
                return null;
            } else {
                // search to left
                return this.right.search(value);
            }
        }
    }
    // search the parent node of the node
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }
    // infix order
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
    // toString
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}