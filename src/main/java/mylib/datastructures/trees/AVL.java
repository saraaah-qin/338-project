package main.java.mylib.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

import main.java.mylib.datastructures.nodes.TNode;

public class AVL {
    private TNode root;

    public AVL() {
        root = null;
    }

    public AVL(int val) {
        TNode newNode = new TNode();
        newNode.setData(val);
        root = newNode;
    }

    // AVL tree constructor that takes in a TNode object and creates a new AVL tree
    // via iterative route
    public AVL(TNode obj) {
        root = null; // Set the root of the new tree to null initially
        if (obj != null) {
            // Step 1: Clone the TNode obj to create a new tree
            root = cloneTree(obj);

            // Step 2: Insert nodes iteratively from the original tree to create abalanced
            // AVL tree
            insertNodes(root, obj);
        }
    }

    // Helper method to clone a tree rooted at the given node
    private TNode cloneTree(TNode node) {
        if (node == null) {
            return null;
        }

        TNode newNode = new TNode();
        newNode.setData(node.getData());
        newNode.setLeft(cloneTree(node.getLeft()));
        newNode.setRight(cloneTree(node.getRight()));
        newNode.setBalance(node.getBalance());

        return newNode;
    }

    // Helper method to insert nodes iteratively from the original tree to create a
    // balanced AVL tree

    private void insertNodes(TNode avlNode, TNode originalNode) {
        if (originalNode == null) {
            return;
        }
        // Insert the node into the AVL tree
        Insert(avlNode, originalNode.getData());

        // Recursively insert nodes from the left and right subtrees of the original
        // tree
        insertNodes(avlNode, originalNode.getLeft());
        insertNodes(avlNode, originalNode.getRight());
    }

    // get the height/balance of a node
    public int getHeight(TNode node) {
        if (node == null) {
            return 0;
        }
        return node.getBalance();
    }

    // Helper method to get the balance factor of a node
    private int getBalanceFactor(TNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    // Helper method to rotate a subtree left at the given node
    private TNode rotateLeft(TNode z) {
        TNode y = z.getRight();
        TNode T2 = y.getLeft();

        y.setLeft(z);
        z.setRight(T2);

        z.setBalance(1 + Math.max(getHeight(z.getLeft()), getHeight(z.getRight())));
        y.setBalance(1 + Math.max(getHeight(y.getLeft()), getHeight(y.getRight())));

        return y;
    }

    // Helper method to rotate a subtree right at the given node
    private TNode rotateRight(TNode y) {
        TNode x = y.getLeft();
        TNode T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setBalance(1 + Math.max(getHeight(y.getLeft()), getHeight(y.getRight())));
        x.setBalance(1 + Math.max(getHeight(x.getLeft()), getHeight(x.getRight())));

        return x;
    }

    // get root
    public TNode getRoot() {
        return this.root;
    }

    // set root
    public void setRoot(TNode node) {
        if (node == null) {
            root = null;
        }
        TNode newNode = new TNode();
        newNode.setData(node.getData());
        newNode.setLeft(cloneTree(node.getLeft()));
        newNode.setRight(cloneTree(node.getRight()));
        newNode.setBalance(node.getBalance());
        root = newNode;
    }

    // Helper method
    // to insert
    // a node
    // with the
    // given value
    // into the tree

    private TNode Insert(TNode node, int val) {
        if (node == null) {
            return new TNode(val, 0, null, null, null);
        }

        if (val < node.getData()) {
            node.setLeft(Insert(node.getLeft(), val));
        } else if (val > node.getData()) {
            node.setRight(Insert(node.getRight(), val));
        } else {
            return node;
        }

        node.setBalance(1 + Math.max(getHeight(node.getLeft()),
                getHeight(node.getRight())));
        int balanceFactor = getBalanceFactor(node);

        // Check for imbalance and perform rotations accordingly
        if (balanceFactor > 1) {
            if (val < node.getLeft().getData()) {
                return rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                return rotateRight(node);
            }
        } else if (balanceFactor < -1) {
            if (val > node.getRight().getData()) {
                return rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                return rotateLeft(node);
            }
        }
        return node;
    }

    // Public method to insert a value into the tree
    public void Insert(int val) {
        root = Insert(root, val);
    }

    public void Insert(TNode node) {
        root = Insert(root, node.getData());
    }

    // Method to print the inorder traversal of the AVL tree
    public void printInorder() {
        printInorder(root);
    }

    // Helper method to print the inorder traversal of the tree rooted at the given
    // node
    private void printInorder(TNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.getLeft());
        System.out.print(node.getData() + " ");
        printInorder(node.getRight());
    }

    // Method to search for a node with the given value in the AVL tree
    public boolean Search(int val) {
        return Search(root, val);
    }

    // Helper method to search for a node with the given value in the tree rooted at
    // the given node
    private boolean Search(TNode node, int val) {
        if (node == null) {
            return false;
        }
        if (val == node.getData()) {
            return true;
        } else if (val < node.getData()) {
            return Search(node.getLeft(), val);
        } else {
            return Search(node.getRight(), val);
        }
    }

    // prints the content of the tree in Breadth-First order, each level on a
    // separate line
    public void printBF() {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }

        Queue<TNode> q = new LinkedList<TNode>();
        q.add(root);
        while (!q.isEmpty()) {
            TNode n = q.remove();
            System.out.print(n.getData() + " ");
            if (n.getLeft() != null) {
                q.add(n.getLeft());
            }
            if (n.getRight() != null) {
                q.add(n.getRight());
            }
        }
        System.out.println();
    }

    // BONUS: delete function

    public void Delete(int val) {
        root = Delete(root, val);
    }

    // Helper method to delete a node from the tree
    private TNode Delete(TNode node, int val) {
        if (node == null) {
            return node;
        }

        if (val < node.getData()) {
            node.setLeft(Delete(node.getLeft(), val));
        } else if (val > node.getData()) {
            node.setRight(Delete(node.getRight(), val));
        } else {
            // Node to be deleted found

            // Case 1: Node with only one child or no child
            if (node.getLeft() == null || node.getRight() == null) {
                TNode temp = null;
                if (node.getLeft() == null) {
                    temp = node.getRight();
                } else {
                    temp = node.getLeft();
                }

                // No child case
                if (temp == null) {
                    temp = node;
                    node = null;
                } else { // One child case
                    node = temp; // Copy the contents of the non-empty child
                }
            } else {
                // Case 2: Node with two children
                // Get the inorder successor (smallest in the right subtree)
                node.setData(findMinValue(node.getRight()));

                // Delete the inorder successor
                node.setRight(Delete(node.getRight(), node.getData()));
            }
        }

        // If the tree had only one node then return
        if (node == null) {
            return node;
        }

        // Update the balance factor of the node
        node.setBalance(1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight())));

        // Check for imbalance and perform rotations accordingly
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (getBalanceFactor(node.getLeft()) >= 0) {
                return rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                return rotateRight(node);
            }
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.getRight()) <= 0) {
                return rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                return rotateLeft(node);
            }
        }

        return node;
    }

    // Helper method to find the smallest value in a BST rooted at a given node
    private int findMinValue(TNode node) {
        int minValue = node.getData();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getData();
            node = node.getLeft();
        }
        return minValue;
    }
}
