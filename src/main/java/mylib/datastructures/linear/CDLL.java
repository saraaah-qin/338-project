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
        if (getHead() == null) { // if list is empty
            setHead(node);
            setTail(node);
            node.setNext(node);
            node.setPrev(node);
        } else {
            node.setNext(getHead()); // set new node's next to current head
            getHead().setPrev(node);
            setHead(node);
            getHead().setPrev(getTail());
            getTail().setNext(getHead());
        }
        setSize(getSize()+1);// increment size
    }

    //OVERRIDE Inserts node object at the tail of the list

    @Override
    public void insertTail(DNode node) { // inserts node at tail
        if (getHead() == null) {
            setHead(node); // set head to node
            setTail(node); //   set tail to node
            node.setNext(node);//   set next for tail
            node.setPrev(node); // set prev for tail
        } else { // if list is not empty
            getTail().setNext(node);
            node.setPrev(getTail());
            setTail(node);
            getHead().setPrev(getTail());
            getTail().setNext(getHead());
        }
        setSize(getSize()+1); // increment size
    }

    //OVERRIDE Deletes the node at the specified position in the list

    @Override
    public void delete(DNode node) {
        if (getHead() == null) {  // if list is empty


        } else if (getSize() == 1 && (node == getHead())) { // if list has only one node
            setHead(null);
            setTail(null);
        } else { // if list has more than one node
            
            if (node == null) {
     
            } else if (node == getHead()) { // if node is head
                setHead(getHead().getNext());
                getHead().setPrev(getTail());
                getTail().setNext(getHead());
            } else if (node == getTail()) { // if node is tail
                setTail(getTail().getPrev());
                getHead().setPrev(getTail());
                getTail().setNext(getHead());
            } else { // if node is in the middle
                node.getPrev().setNext(node.getNext());
                node.getNext().setPrev(node.getPrev());
            }
        }
        setSize(getSize()-1); // decrement size
    }
    
}


   