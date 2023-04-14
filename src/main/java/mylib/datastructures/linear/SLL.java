package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

/** Singly linked list class */

public class SLL {
    private DNode head;
    private int size;
    private DNode sorted;
    private DNode tail;

    // CONSTRUCTORS
    // Default constructor with no arguments that creates a null head object
    public SLL() {
        setHead(null);
        setSize(0);
    }

    // Overload constructor with a Node object argument to use as head
    public SLL(DNode head) {
        setHead(head);
        setSize(0);
    }

    // GETTERS and SETTERS
    public void setSorted(DNode sorted) {
        this.sorted = sorted;
    }

    public DNode getSorted() {
        return sorted;
    }

    public void setHead(DNode head) {
        this.head = head;
    }

    public DNode getHead() {
        return head;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public DNode getTail() {
        return null;
    }

    // INSERTION METHODS
    // Inserts node object at head of the list

    public void insertHead(DNode node) {
        if (getHead() == null) {
            setHead(node);
        } else {
            node.setNext(getHead());
            setHead(node);
        }
        setSize(getSize() + 1);

    }

    // Inserts node object at the tail of the list

    public void insertTail(DNode node) {

        if (getHead() == null) {
            setHead(node);
        } else {
            getLastNode().setNext(node);
        }
        setSize(getSize() + 1);
    }

    // Inserts node object in the specified position
    // O(n) because of getNode()
    public void insert(DNode node, int position) {
        setSize(getSize() + 1);
        if (getHead() == null) {
            insertHead(node);
            setSize(getSize() - 1);
        } else if (getNode(position) == null) {
            insertTail(node);
            setSize(getSize() - 1);
        } else if (position == 0) {
            insertHead(node);
            setSize(getSize() - 1);
        } else {
            node.setNext(getNode(position).getNext());
            getNode(position).setNext(node);

        }

    }

    // Inserts node object in its proper position in a sorted list
    // Complexity O(n)
    public void sortedInsert(DNode node) {

        DNode currentNode = getHead();
        if (isSorted() == false) {
            sort();
        }

        if (currentNode == null) {
            insertHead(node);
            setSize(getSize() - 1);

        }

        else if (getHead().getData() >= node.getData()) {
            insertHead(node);
            setSize(getSize() - 1);

        }

        else if (getLastNode().getData() < node.getData()) {
            insertTail(node);
            setSize(getSize() - 1);
        } else {
            currentNode = getHead();
            while (currentNode.getNext() != getTail() && currentNode.getData() != node.getData()
                    && currentNode.getNext().getData() < node.getData()) {
                currentNode = currentNode.getNext();
            }
            node.setNext(currentNode.getNext());
            currentNode.setNext(node);
        }
        setSize(getSize() + 1);
    }

    // SORTING METHODS
    // checks to see if list is sorted or not
    public boolean isSorted() {
        DNode currentNode = getHead();
        if (currentNode == null) {
            return true;
        }
        while (currentNode.getNext() != getTail()) {
            if (currentNode.getData() < currentNode.getNext().getData()) {
                currentNode = currentNode.getNext();
            } else {
                return false;
            }
        }
        return true;
    }

    // sorted elements ascending order

    public void sort() {

        DNode current = getHead();
        setSorted(null);

        for (int i = 0; i < getSize(); i++) {
            DNode temp = current.getNext();
            sortedInserted(current);
            current = temp;
        }
        setHead(getSorted());
        // System.out.println(head);
    }

    // created a separate sortedinserted method to use in sort to reduce confusion
    // since the actual sortedinsert has to call sort already

    // SEARCH
    // Looks up node in the list

    public DNode search(DNode node) {
        DNode currentNode = getHead();
        while (currentNode != null && currentNode != node) {
            currentNode = currentNode.getNext();
        }
        if (currentNode != null && currentNode == node) {
            DNode match = currentNode;
            return match;
        } else {
            return null;
        }
    }

    // DELETION METHODS
    // Delete head node
    // Complexity O(1)
    public DNode deleteHead() {
        if (getHead() == null) {
            System.out.println("Cannot delete from empty list");
            return null;
        }
        DNode temp = getHead();
        setHead(getHead().getNext());
        setSize(getSize() - 1);
        return temp;
    }

    // Delete tail node
    // Complexity O(n) - because you need to iterate through. If I would have held a
    // tail reference it would be O(1)
    public DNode deleteTail() {
        if (getHead() == null) {
            System.out.println("Cannot delete from empty list");
            return null;
        }
        DNode currentNode = getHead();
        DNode temp = null;
        setSize(getSize() - 1);
        while (currentNode != null) {
            if (currentNode.getNext().getNext() == null) {
                temp = currentNode.getNext();
                currentNode.setNext(null);
                return temp;
            }
            currentNode = currentNode.getNext();
        }

        return temp;
    }

    // Deletes the node if found in the list
    // Complexity O(n)
    public void delete(DNode node) {
        if (node == null || head == null) {
            return;
        }
        if (head == node) {
            head = node.getNext();
            return;
        }
        DNode currentNode = head;

        while (currentNode.getNext() != null) {
            if (currentNode.getNext() == node) {
                currentNode.setNext(currentNode.getNext().getNext());
                return;
            }
            currentNode = currentNode.getNext();
        }
    }

    // Deletes the whole list
    // Complexity O(1)
    public void clear() {
        setSize(0);
        setHead(null);
    }

    // PRINTS LIST
    // Prints the list information on the screen - list length, sorted status, list
    // content
    // Complexity O(n)
    public void print() {
        DNode currentNode = getHead();
        System.out.println("List size: " + getSize());
        System.out.println("Sorted: " + isSorted());

        for (int i = 0; i < getSize(); i++) {
            System.out.println(currentNode);
            currentNode = currentNode.getNext();
        }
    }

    // grabs last node in the list
    // Complexity O(n)
    public DNode getLastNode() {
        DNode currentNode = getHead();
        while (currentNode.getNext() != getTail()) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    // get node at specific index
    // complexity - O(n)
    public DNode getNode(int position) {
        DNode currentNode = getHead();

        for (int i = 0; i < position - 1; i++) {
            currentNode = currentNode.getNext();

        }

        return currentNode;
    }

    public void sortedInserted(DNode node) {

        if (getSorted() == null || getSorted().getData() >= node.getData()) {
            node.setNext(getSorted());
            setSorted(node);
        } else {
            DNode currentNode = getSorted();
            while (currentNode.getNext() != null && currentNode.getData() != node.getData()
                    && currentNode.getNext().getData() < node.getData()) {
                currentNode = currentNode.getNext();
            }
            node.setNext(currentNode.getNext());
            currentNode.setNext(node);
        }

    }

}
