package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class CDLL extends DLL{


    //Default constructor
    public CDLL() {
        super();
        if (getHead() == null) {
            setTail(null);
        } else {
            getTail().setNext(getHead());
            getHead().setPrev(getTail());
        }
    }

    //Constructor overload with one node initializes the list with head and tail pointing to the same node 
    public CDLL(DNode node) {
        super(node, node);
        node.setNext(node);
        node.setPrev(node);
    }

// METHODS 

    //OVERRIDE Inserts node object at head of the list

    @Override
    public void insertHead(DNode node) {
        if (getHead() == null) {
            setHead(node);
            setTail(node);
            node.setNext(node);
            node.setPrev(node);
        } else {
            node.setNext(getHead());
            getHead().setPrev(node);
            setHead(node);
            getHead().setPrev(getTail());
            getTail().setNext(getHead());
        }
        setSize(getSize()+1);
    }

    //OVERRIDE Inserts node object at the tail of the list

    @Override
    public void insertTail(DNode node) {
        if (getHead() == null) {
            setHead(node);
            setTail(node);
            node.setNext(node);
            node.setPrev(node);
        } else {
            getTail().setNext(node);
            node.setPrev(getTail());
            setTail(node);
            getHead().setPrev(getTail());
            getTail().setNext(getHead());
        }
        setSize(getSize()+1);
    }

    //OVERRIDE Deletes the node at the specified position in the list

    @Override
    public void delete(DNode node) {
        if (getHead() == null) {
            System.out.println("Linked list is empty");
        } else if (getSize() == 1 && (node == getHead())) {
            setHead(null);
            setTail(null);
        } else {
            
            if (node == null) {
                // System.out.println("Invalid node");
            } else if (node == getHead()) {
                setHead(getHead().getNext());
                getHead().setPrev(getTail());
                getTail().setNext(getHead());
            } else if (node == getTail()) {
                setTail(getTail().getPrev());
                getHead().setPrev(getTail());
                getTail().setNext(getHead());
            } else {
                node.getPrev().setNext(node.getNext());
                node.getNext().setPrev(node.getPrev());
            }
        }
        setSize(getSize()-1);
    }
    
}


   