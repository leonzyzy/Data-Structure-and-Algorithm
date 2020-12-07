package BinarySearchTree;
public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        int[] x = {7,3,10,12,5,1,9};
        // define a bst
        BinarySearchTree bst = new BinarySearchTree();
        for (int val: x) {
            bst.add(new Node(val));
        }
        bst.infixOrder();
    }
}

// binary search tree
class BinarySearchTree {
    private Node root;

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