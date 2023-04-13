package main.java.mylib.datastructures.nodes;

public class TNode {

    private int data;
    private TNode left;
    private TNode right;
    private TNode parent;
    private int balance;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TNode getLeft() {
        return left;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getRight() {
        return right;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public TNode getParent() {
        return parent;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public TNode() {
    }

    public TNode(int data, int balance, TNode P, TNode L, TNode R) {
        this.data = data;
        this.balance = balance;
        this.left = L;
        this.right = R;
        this.parent = P;
    }

    public void print() {
        System.out.println("Data: " + data + " Balance: " + balance);
    }

    public void printAll() {
        System.out.println("Data: " + data + " Balance: " + balance);
        if (left != null) {
            System.out.print("Left: ");
            left.print();
        }
        if (right != null) {
            System.out.print("Right: ");
            right.print();
        }
        if (parent != null) {
            System.out.print("Parent: ");
            parent.print();
        }
    }

    public String toString() {
        return "Data: " + data + " Balance: " + balance;
    }
}
