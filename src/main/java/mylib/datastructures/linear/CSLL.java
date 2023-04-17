package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;
// csll
public class CSLL extends SLL {
    private DNode head;
    private DNode tail;
    private int size;

    private DNode pointerToTail;

    // getters and setters
    public DNode getHead() { // returns head of the list
        return head;
    }

    public void setHead(DNode head) { // sets head of the list
        this.head = head;
    }

    public int getSize() { // returns size of the list
        return size;
    }

    public void setSize(int size) { // sets size of the list
        this.size = size;
    }

     public DNode getTail() { // returns tail of the list
        return tail;
    }

    public void setTail(DNode tail) { // sets tail of the list
        this.tail = tail;
    }

    public DNode getpointerToTail() { // returns tail of the list
        return getHead();
    }
    public void setpointerToTail(DNode pointerToTail) {// sets tail of the list
        this.pointerToTail = pointerToTail;
    }



    // CONSTRUCTORS
    public CSLL() {
        setHead(null);
        setTail(getHead());
        setSize(0);
    }

    public CSLL(DNode head) { // Overload constructor with a Node object argument of head
        setHead(head);
        setTail(getHead());
        getHead().setNext(getTail());
        getTail().setNext(getHead());
        setSize(0);
    }

    // METHODS

    @Override
    public void insertHead(DNode node) { // inserts node at the head of the list

        super.insertHead(node); //  call the super class method
        if (getTail() == null) { // if the list is empty
            setTail(getHead());
        } else { // if the list is not empty
            getTail().setNext(getHead()); // set the tail's next to the head
        }

    }


    // override insertTail
    @Override
    public void insertTail(DNode node) { // inserts node at the tail of the list
        super.insertTail(node);
        setTail(node);
        node.setNext(getHead());
    }


    @Override
    public void insert(DNode node, int position) { // inserts node at the position of the list
        super.insert(node, position);
        setTail(getLastNode());
        getTail().setNext(getHead());
    }

    public void sortedInsert(DNode node) { // inserts node at the position of the list

        DNode currentNode = getHead(); // set the current node to the head
        if (isSorted() == false) {
            sort();
            setSize(getSize() + 1); // increment the size of the list
        }

        if (currentNode == null) { // if the list is empty
            insertHead(node);
        }

        else if (getHead().getData() >= node.getData()) {// if the node is less than the head
            insertHead(node);
        }

        else if (getLastNode().getData() < node.getData()) { // if the node is greater than the tail
            insertTail(node);
        } else {
            currentNode = getHead();
            while (currentNode.getNext() != getpointerToTail() && currentNode.getData() != node.getData() // if the node is greater than the tail
                    && currentNode.getNext().getData() < node.getData()) { // if the node is greater than the tail
                currentNode = currentNode.getNext(); // set the current node to the next node
            }
            node.setNext(currentNode.getNext()); // set the node's next to the current node's next
            currentNode.setNext(node);
            setSize(getSize() + 1); // increment the size of the list
        }

    }

// overrides the sort function
    @Override
    public void sort() {
        DNode currentNode = getHead();
        setSorted(null);

        for (int i = 0; i < getSize(); i++) { // loop through the list
            DNode returnValue = currentNode.getNext();
            sortedInserted(currentNode);
            currentNode = returnValue;
        }
        setHead(getSorted());

        DNode returnValue2 = getHead(); // set the current node to the head
        for (int i = 1; i < getSize(); i++) { //    loop through the list
            returnValue2 = returnValue2.getNext();

        }
        setTail(returnValue2);
        getTail().setNext(getHead());

    }


    @Override
    public DNode search(DNode node) { // searches for a node in the list
        DNode currentNode = getHead();
        DNode match = null;
        for (int i = 0; i < getSize(); i++) { // loop through the list
            if (currentNode == node) { // if the current node is the node to be searched
                match = currentNode; 
            }
            currentNode = currentNode.getNext(); // set the current node to the next node
        } 
        return match; // return the node if found
    }

    // DELETION METHODS

    @Override
    public DNode deleteHead() { // deletes the head of the list
        DNode returnValue = getHead();
        setHead(getHead().getNext());
        getTail().setNext(getHead());
        setSize(getSize() - 1); // decrement the size of the list
        return returnValue;
    }


    @Override
    public DNode deleteTail() { // deletes the tail of the list
        DNode currentNode = getHead();
        DNode returnValue = null;
        setSize(getSize() - 1); // decrement the size of the list
        while (currentNode.getNext() != getHead()) {
            currentNode = currentNode.getNext();
            if (currentNode.getNext().getNext() == getHead()) {
                returnValue = currentNode.getNext();
                currentNode.setNext(getHead());
                return returnValue;
            }
        }
        return returnValue;
    }


    @Override
    public void delete(DNode node) {
        DNode currentNode = getHead();
        DNode prev = null;

        // Find the node to be deleted
        while (currentNode != node && currentNode.getNext() != getHead()) {
            prev = currentNode;
            currentNode = currentNode.getNext();
        }

        // If the node is not found in the list
        if (currentNode != node) {
            System.out.println("Node not found in the list");
            return;
        }

        // If the node is the head of the list
        if (currentNode == getHead()) {
            setHead(getHead().getNext());
        } else {
            prev.setNext(currentNode.getNext());
        }

        // If the node is the tail of the list
        if (currentNode == getTail()) {
            setTail(prev);
        }

        // Update the size of the list
        setSize(getSize() - 1);

        // Update the tail pointer
        getTail().setNext(getHead());
    }

}
