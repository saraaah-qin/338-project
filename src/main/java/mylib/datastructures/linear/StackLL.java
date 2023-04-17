package main.java.mylib.datastructures.linear;
import main.java.mylib.datastructures.nodes.DNode;

public class StackLL extends SLL{ // stack is a subclass of SLL
    private DNode head;
    private int size;


    public DNode getHead() {  // returns head of the list
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

    public StackLL() { // CONSTRUCTORS
        setHead(null);
        setSize(0);
    }

    public StackLL(DNode head) { // Overload constructor with a Node object argument of head
        setHead(head);
        setSize(0);
    }


    public void push(DNode node) { //inserts node at the top of the stack
        super.insertHead(node);
    }

    //deletes top of the stack

    public DNode pop() {
        return super.deleteHead();
    }
    

    public boolean isEmpty() {
        if(getHead() == null) { // if head is null, stack is empty
            return true;
        }
        return false;
    }


    public DNode peek() { // returns top of the stack
        if(getHead() == null) {
        
            return null;
        }
        return getHead();
    
    }

    @Override
    public void insertTail(DNode node) {
        //override with empty body
    }

    @Override 
    public void insert(DNode node, int position) {
        //Override with empty body
    }


    //sortedInsert
    @Override 
    public void sortedInsert(DNode node) {
        //empty body for override
    }

    //sort
    @Override 
    public void sort() {
        //empty body for stack
    }

    @Override 
    public void sortedInserted(DNode node) {
        //empty body for Stack
    }

    @Override
    public DNode deleteTail() {
        return null;
    }

    public void delete(DNode node) {
        if (isEmpty()) {
            return; // stack is empty, nothing to delete
        }
        if (node == head) {
            head = head.getNext(); // set the new head to the next node in the stack
            size--; // decrement the size of the stack
        }
    }
    // not sure if we need this but checks to see if the node is in the stack
    public DNode searchStack(DNode node) {
        DNode current = getHead();
    
        while(current != null && current != node) {
            current = current.getNext();
 
        }
        if(current != null && current == node) {
            return node;
        }
        else {
            return null;
        }
    }
    

}

