
package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

// DLL 

public class DLL extends SLL {

    private DNode head;
    private DNode tail;
    private int size;
    private DNode sorted;
    private DNode tailPointer;

    // CONSTRUCTORS
    public DLL() {
        setHead(null);
        setTail(null);
    }

    // Overload constructor with a Node object argument of head
    public DLL(DNode head, DNode tail) {
        setHead(head);
        setTail(tail);
    }

    // geters and setters
    public int getSize() { // returns size of the list
        return size;
    }

    public void setSize(int size) { // sets size of the list
        this.size = size;
    }

    public void setHead(DNode head) { // sets head of the list
        this.head = head;
    }

    public DNode getHead() {
        return head; // returns head of the list
    }

    public DNode getSorted() {
        return sorted;// returns sorted of the list
    }

    public void setSorted(DNode sorted) {
        this.sorted = sorted;// sets sorted of the list
    }

    public DNode getTailPointer() {// returns tailPointer of the list
        return tailPointer;
    }

    public void setTailPointer(DNode tailPointer) {
        this.tailPointer = tailPointer;//   sets tailPointer of the list
    }

    public DNode getTail() {// returns tail of the list
        return tail;
    }

    public void setTail(DNode tail) {
        this.tail = tail;
    }

    // actual methods
    // Inserts node at head
    @Override
    public void insertHead(DNode node) {
        if (getHead() == null) {
            setHead(node);
            setTail(node);
        } 
        else{
            node.setNext(getHead());
            getHead().setPrev(node);
            setHead(node);
        }
        setSize(getSize() + 1);
    }

    // Inserts node at the tail

    @Override
    public void insertTail(DNode node) {

        if (getHead() == null) { // if list is empty
            setHead(node);
            setTail(node);
        } else {
            getTail().setNext(node); // set next for tail
            node.setPrev(getTail());
            setTail(node);
        }
        setSize(getSize() + 1);
    }

    // Inserts node in the position 
    @Override
    public void insert(DNode node, int position) { // inserts node at position

        if (getHead() == null) { // if list is empty
            setHead(node);

            setTail(node);
            setSize(getSize() + 1);
        } else if (getNode(position) == null) { // if position is out of bounds
            insertTail(node);

        } else if (position == 0) { // if position is 0
            insertHead(node);

        } else {
            DNode nodeBefore = getNode(position).getPrev(); //`nodeBefore` is the node before position
            DNode nodeAfter = getNode(position); //`nodeAfter` is the node at position

            node.setNext(nodeAfter);
            nodeBefore.setNext(node);
            nodeAfter.setPrev(node);
            node.setPrev(nodeBefore);
            setSize(getSize() + 1); // increment size

        }

    }

    // Inserts node in its proper position in a sorted list

    @Override
    public void sortedInsert(DNode node) { // inserts node in its proper position in a sorted list

        DNode currentNode = getHead();
        if (isSorted() == false) {
            sort();
        }

        if (currentNode == null) { // if list is empty
            insertHead(node);

        }

        else if (getHead().getData() >= node.getData()) {
            insertHead(node);

        }

        else if (getLastNode().getData() < node.getData()) {
            insertTail(node);

        }

        else {
            currentNode = getHead();
            while (currentNode.getNext() != getTailPointer() && currentNode.getData() != node.getData()
                    && currentNode.getNext().getData() < node.getData()) {
                currentNode = currentNode.getNext();
            }

            node.setNext(currentNode.getNext()); // set next for new node

            node.setPrev(currentNode); // set new nodes previous

            currentNode.getNext().setPrev(node); // set previous for node before new node

            currentNode.setNext(node); // set next to be new node
            setSize(getSize() + 1);

        }
  
    }

    // sort method
    @Override
    public void sort() {
        if (getHead() == null || getHead().getNext() == null) {
            // Empty list or list with only one element is already sorted
            return;
        }
        DNode nextNode;
        boolean swapped;
        DNode currentNode = getHead();
        do {
            swapped = false;
            currentNode = getHead();

            while (currentNode != null && currentNode.getNext() != null) { // while current node is not null and next node is not null
                nextNode = currentNode.getNext();

                if (currentNode.getData() > nextNode.getData()) {
                    // Swap the nodes
                    DNode prevNode = currentNode.getPrev();
                    DNode nextNextNode = nextNode.getNext();

                    currentNode.setNext(nextNextNode);
                    currentNode.setPrev(nextNode);
                    nextNode.setNext(currentNode);
                    nextNode.setPrev(prevNode);

                    if (prevNode != null) { // if previous node is not null
                        prevNode.setNext(nextNode);
                    } else {
                        setHead(nextNode);
                    }

                    if (nextNextNode != null) { // if next next node is not null
                        nextNextNode.setPrev(currentNode);
                    } else {
                        setTail(currentNode);
                    }

                    swapped = true;
                } else {
                    currentNode = currentNode.getNext();
                }
            }
        } while (swapped); // while swapped is true
    }

 
    public void sortedInserted(DNode node) { // inserts node in its proper position in a sorted list
        if (getSorted() == null || getSorted().getData() > node.getData()) {
            node.setNext(getSorted());
          
            setSorted(node);
        } else {
            DNode currentNode = getSorted(); //`currentNode` is the node at position
   
            while (currentNode.getNext() != null && currentNode.getData() != node.getData()
                    && currentNode.getNext().getData() < node.getData()) {
                currentNode = currentNode.getNext();

            }
            node.setNext(currentNode.getNext());
            currentNode.getNext().setPrev(node);
            node.setPrev(currentNode); // set new nodes previous
            currentNode.setNext(node);
        }
    }


    // Delete head node

    @Override
    public DNode deleteHead() {
        DNode temp = getHead();
        setHead(getHead().getNext()); // set head to be the next node
        getHead().setPrev(null); // set previous of new head to be null
        setSize(getSize() - 1);// decrement size
        return temp;
    }

    // Delete tail node
    @Override
    public DNode deleteTail() { // deletes tail node
        DNode temp = getTail();
        setTail(getTail().getPrev());// set tail to be the previous node
        getTail().setNext(null);// set next of new tail to be null
        setSize(getSize() - 1);// decrement size
        return temp;
    }

    // Deletes the node if found in the list

    public DNode deleteNode(DNode node) {
        DNode tempNext = null;
        DNode currentNode = getHead();


        setSize(getSize() - 1);
        // If the id given is the first element
        if (currentNode.equals(node) && currentNode != null) {
            setSize(getSize() + 1);
            return deleteHead();
        }

        else if (getTail().equals(node)) { // if the id given is the last element
            return deleteTail();
        }

        while (currentNode != null && !currentNode.equals(node)) { // while current node is not null and current node is not equal to node
            tempNext = currentNode;
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) { // if current node is null
            setSize(getSize() + 1);
            return null;
        }
        tempNext.setNext(currentNode.getNext()); // set next for node before current node
        currentNode.getNext().setPrev(tempNext);// set previous for node after current node
        return currentNode;// return current node
    }

}
