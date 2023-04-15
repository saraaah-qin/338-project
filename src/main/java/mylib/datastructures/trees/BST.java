package main.java.mylib.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

import main.java.mylib.datastructures.nodes.TNode;

public class BST {
    private TNode root;

    // BST constructor that creates an empty tree
    public BST() {
        root = null;
    }

    // BST constructor that creates a tree with a single node with data val
    public BST(int val) {
        TNode newNode = new TNode();
        newNode.setData(val);
        root = newNode;
    }

    // BST constructor that takes in a TNode object and creates a new BST tree
    public BST(TNode obj) {
        root = obj;
    }

    // get root
    public TNode getRoot() {
        return root;
    }

    // set root
    public void setRoot(TNode root) {
        this.root = root;
    }

    // creates a new node with data val to be inserted into the tree
    public void Insert(int val) {
        root = Insert(root, val);
    }

    // Helper method for Insert(int val) that creates a new node with data val to be
    // inserted into the tree
    private TNode Insert(TNode node, int val) {
        if (node == null) {
            TNode newNode = new TNode();
            newNode.setData(val);
            return newNode;
        }

        if (val < node.getData()) {
            node.setLeft(Insert(node.getLeft(), val));
        } else if (val > node.getData()) {
            node.setRight(Insert(node.getRight(), val));
        }

        return node;
    }

    // inserts the node passed as argument into the tree
    public void Insert(TNode node) {
        if (root == null) {
            root = node;
        } else {
            root = Insert(root, node);
        }
    }

    // Helper method for Insert(TNode node) that inserts the node passed as argument
    // into the tree
    private TNode Insert(TNode parent, TNode node) {
        if (parent == null) {
            return node;
        }

        if (node.getData() < parent.getData()) {
            parent.setLeft(Insert(parent.getLeft(), node));
        } else if (node.getData() > parent.getData()) {
            parent.setRight(Insert(parent.getRight(), node));
        }

        return parent;
    }

    // finds the node with val as data and deletes it, if not found prints
    // a statement that the value is not in the tree
    public String Delete(int val) {
        TNode node = Search(root, val);
        if (node == null) {
            return "Node not found";
        }
        root = Delete(root, val);
        return "Node deleted";
    }

    // Helper method for Delete(int val) that finds the node with val as data and
    // deletes it
    private TNode Delete(TNode node, int val) {
        if (node == null) {
            return node;
        }

        if (val < node.getData()) {
            node.setLeft(Delete(node.getLeft(), val));
        } else if (val > node.getData()) {
            node.setRight(Delete(node.getRight(), val));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            node.setData(minValue(node.getRight()));
            node.setRight(Delete(node.getRight(), node.getData()));
        }

        return node;
    }

    // Helper method for Delete(int val) that finds the minimum value in the
    private int minValue(TNode node) {
        int minValue = node.getData();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getData();
            node = node.getLeft();
        }
        return minValue;
    }

    // searches for the node with val as data and
    // returns it or returns null if not found
    public TNode Search(int val) {
        return Search(root, val);
    }

    // Helper method for Search(int val) that searches for the node with val
    // as data and returns it or returns null if not found
    private TNode Search(TNode node, int val) {
        if (node == null || node.getData() == val) {
            return node;
        }

        if (val < node.getData()) {
            return Search(node.getLeft(), val);
        } else {
            return Search(node.getRight(), val);
        }
    }

    // print tree in ascending order
    public void printInOrder() {
        printInOrder(getRoot());
    }

    // Helper method for printInOrder() that prints the tree in ascending order
    private void printInOrder(TNode node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrder(node.getRight());
        }
    }

    // prints the content of the tree in Breadth-First order, each level on a
    // separate line
    public void printBF() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TNode node = queue.poll();
                System.out.print(node.getData() + " ");

                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }

                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            System.out.println();
        }
    }
}
