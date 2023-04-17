package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

/**
 * Circular Singly Linked Lists
 *
 */
public class CSLL extends SLL {
    private DNode head;
    private DNode tail;
    private int size;
    private DNode pointerToTail;

    // GETTERS & SETTERS
    public DNode getHead() {
        return head;
    }

    public void setHead(DNode head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public DNode getTail() {
        return tail;
    }

    public void setTail(DNode tail) {
        this.tail = tail;
    }

    public DNode getpointerToTail() {
        return getHead();
    }
    public void setpointerToTail(DNode pointerToTail) {
        this.pointerToTail = pointerToTail;
    }



    // CONSTRUCTORS
    public CSLL() {
        setHead(null);
        setTail(getHead());
        setSize(0);
    }

    public CSLL(DNode head) {
        setHead(head);
        setTail(getHead());
        getHead().setNext(getTail());
        getTail().setNext(getHead());
        setSize(0);
    }

    // INSERTION METHODS

    @Override
    public void insertHead(DNode node) {
        // System.out.println(getTail());
        super.insertHead(node);
        if (getTail() == null) {
            setTail(getHead());
        } else {
            getTail().setNext(getHead());
        }

    }


    // override insertTail
    @Override
    public void insertTail(DNode node) {
        super.insertTail(node);
        setTail(node);
        node.setNext(getHead());
    }


    @Override
    public void insert(DNode node, int position) {
        super.insert(node, position);
        setTail(getLastNode());
        getTail().setNext(getHead());
    }

    public void sortedInsert(DNode node) {

        DNode current = getHead();
        if (isSorted() == false) {
            sort();
        }

        if (current == null) {
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
            current = getHead();
            while (current.getNext() != getpointerToTail() && current.getData() != node.getData()
                    && current.getNext().getData() < node.getData()) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
        }
        setSize(getSize() + 1);
    }

// overrides the sort function
    @Override
    public void sort() {
        DNode current = getHead();
        setSorted(null);

        for (int i = 0; i < getSize(); i++) {
            DNode temp = current.getNext();
            sortedInserted(current);
            current = temp;
        }
        setHead(getSorted());

        DNode temp2 = getHead();
        for (int i = 1; i < getSize(); i++) {
            temp2 = temp2.getNext();

        }
        setTail(temp2);
        getTail().setNext(getHead());

    }

    // SEARCH
    // Looks up node in the list
    @Override
    public DNode search(DNode node) {
        DNode current = getHead();
        DNode match = null;
        for (int i = 0; i < getSize(); i++) {
            if (current == node) {
                match = current;
            }
            current = current.getNext();
        }
        return match;
    }

    // DELETION METHODS
    // Delete head node

    @Override
    public DNode deleteHead() {
        DNode temp = getHead();
        setHead(getHead().getNext());
        getTail().setNext(getHead());
        setSize(getSize() - 1);
        return temp;
    }


    @Override
    public DNode deleteTail() {
        DNode current = getHead();
        DNode temp = null;
        setSize(getSize() - 1);
        while (current.getNext() != getHead()) {
            current = current.getNext();
            if (current.getNext().getNext() == getHead()) {
                temp = current.getNext();
                current.setNext(getHead());
                return temp;
            }
        }
        return temp;
    }


    @Override
    public void delete(DNode node) {
        DNode current = getHead();
        DNode prev = null;

        // Find the node to be deleted
        while (current != node && current.getNext() != getHead()) {
            prev = current;
            current = current.getNext();
        }

        // If the node is not found in the list
        if (current != node) {
            System.out.println("Node not found in the list");
            return;
        }

        // If the node is the head of the list
        if (current == getHead()) {
            setHead(getHead().getNext());
        } else {
            prev.setNext(current.getNext());
        }

        // If the node is the tail of the list
        if (current == getTail()) {
            setTail(prev);
        }

        // Update the size of the list
        setSize(getSize() - 1);

        // Update the tail pointer
        getTail().setNext(getHead());
    }

}
