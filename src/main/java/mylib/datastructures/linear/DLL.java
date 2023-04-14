// package main.java.mylib.datastructures.linear;

// import main.java.mylib.datastructures.nodes.DNode;

package main.java.mylib.datastructures.linear;
import main.java.mylib.datastructures.nodes.DNode;
/** Doubly linked list class */

public class DLL extends SLL
{
    //INSTANCE VARIABLES
    private DNode head;
    private DNode tail;
    private int size;
    private DNode sorted;
    private DNode tailPointer;

    //CONSTRUCTORS
    public DLL() {
        setHead(null);
        setTail(null);
    }

    //Overload constructor with a Node object argument to use as head
    public DLL(DNode head, DNode tail) {
        setHead(head);
        setTail(tail);
    }

    //GETTERS and SETTERS
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setHead(DNode head) {
        this.head = head;
    }
    public DNode getHead() {
        return head;
    }

    public DNode getSorted() {
        return sorted;
    }

    public void setSorted(DNode sorted) {
        this.sorted = sorted;
    }

    public DNode getTailPointer() {
        return tailPointer;
    }

    public void setTailPointer(DNode tailPointer) {
        this.tailPointer = tailPointer;
    }


    public DNode getTail() {
        return tail;
    }

    public void setTail(DNode tail) {
        this.tail = tail;
    }





// actual methods
    //Inserts node at head 
    @Override
    public void insertHead(DNode node) {
        if (getHead() == null) {
            setHead(node);
            setTail(node);
        } 
        else {
            node.setNext(getHead());
            getHead().setPrev(node);
            setHead(node);
        }
        setSize(getSize()+1);
    }

    //Inserts node  at the tail

    @Override
    public void insertTail(DNode node) {

        if (getHead() == null) {
            setHead(node);
            setTail(node);
        } 
        else {
            getTail().setNext(node);
            node.setPrev(getTail());
            setTail(node);
        }
        setSize(getSize()+1);
    }

    //Inserts node in the  position
    @Override
    public void insert(DNode node, int position) {
        if(getHead() == null) {
            setHead(node);
            setTail(node);
        }
        else if(getNode(position) == null) {
            insertTail(node);
            setSize(getSize()-1);
        }
        else if(position == 0) {
            insertHead(node);
            setSize(getSize()-1);
        }
        else {
            DNode nodeBefore = getNode(position).getPrev();
            DNode nodeAfter = getNode(position);
            node.setNext(nodeAfter);
            nodeBefore.setNext(node);
            nodeAfter.setPrev(node);
            node.setPrev(nodeBefore);

        }
        setSize(getSize()+1);
    }

    //Inserts node in its proper position in a sorted list

    @Override
    public void sortedInsert(DNode node) {

        DNode currentNode = getHead();
        if(isSorted() == false) {
            sort();
        }
    
        if(currentNode == null) {
            insertHead(node);
            setSize(getSize()-1);
        }

        else if(getHead().getData() >= node.getData()) {
            insertHead(node);
            setSize(getSize()-1);
        }

        else if(getLastNode().getData() < node.getData()) {
            insertTail(node);
            setSize(getSize()-1);
        }

        else {
            currentNode = getHead();
            while(currentNode.getNext() != getTailPointer() && currentNode.getData() != node.getData() && currentNode.getNext().getData() < node.getData()) {
                currentNode = currentNode.getNext(); 
            }
     
            node.setNext(currentNode.getNext());        //set next for new node
        
            node.setPrev(currentNode);     //set new nodes previous
    
            currentNode.getNext().setPrev(node);         //set previous for node before new node
        
            currentNode.setNext(node);     //set next to be new node
            
        }
        setSize(getSize()+1);
    }

//sort methods
    @Override
    public void sort() {
        super.sort();
        setTail(getLastNode());
    }

    //O(n)
    public void sortedInserted(DNode node) {
        if(getSorted() == null || getSorted().getData() > node.getData()) {
			node.setNext(getSorted());
            //getSorted().setPrev(node);
            setSorted(node);           
		}
        else {
			DNode currentNode = getSorted();
            //System.out.println("geetSorted: "+getSorted());
			while(currentNode.getNext() != null && currentNode.getData() != node.getData() && currentNode.getNext().getData() < node.getData()) {
				currentNode = currentNode.getNext();
                
			}
			node.setNext(currentNode.getNext());
            currentNode.getNext().setPrev(node);
            node.setPrev(currentNode);
			currentNode.setNext(node);
		}
    }

    //DELETE METHODS
    //Delete head node

    @Override
    public DNode deleteHead() {
        DNode temp = getHead();
        setHead(getHead().getNext());
        getHead().setPrev(null);
        setSize(getSize()-1);
        return temp;
    }

    //Delete tail node
    @Override
    public DNode deleteTail() {
        DNode temp = getTail();
        setTail(getTail().getPrev());
        getTail().setNext(null);
        setSize(getSize()-1);
        return temp;
    }

    //Deletes the node if found in the list
   
    public DNode deleteNode(DNode node) {
        DNode currentNode = getHead();
        DNode tempNext = null;
        setSize(getSize()-1);
        // If the id given is the first element
        if (currentNode.equals(node)&& currentNode != null) {
            setSize(getSize()+1);
            return deleteHead();
        }

        else if(getTail().equals(node)) {
            return deleteTail();
        }
        
        while (currentNode != null && !currentNode.equals(node) ) {
            tempNext = currentNode;
            currentNode = currentNode.getNext();
        }

        if(currentNode == null) {
            setSize(getSize()+1);
            System.out.println("Element not found in list");
            return null;
        }
        tempNext.setNext(currentNode.getNext());
        currentNode.getNext().setPrev(tempNext);
        return currentNode;
    }
    
}

