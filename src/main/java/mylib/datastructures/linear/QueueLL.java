package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;


public class QueueLL extends SLL {
  private DNode head;
  private DNode tail;
  private int size;
  // constructors
  public QueueLL() {
    setTail(null);
    setHead(null);
    setSize(0);
  }
  public QueueLL(DNode head, DNode tail) {
    setHead(head);
    setTail(tail);
    setSize(0);
}

// getters and setters 

public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
  public DNode getHead() {
    return head;
  }

  public void setHead(DNode head) {
    this.head = head;
  }

  public DNode getTail() {
    return tail;
  }

  public void setTail(DNode tail) {
    this.tail = tail;
  }





// actual methods
 // adds something to the tail
  public void enqueue(DNode node) {
    super.insertTail(node);
  }
// dequeue or removes head
  public void dequeue() {
    super.deleteHead();
  }

  public boolean isEmpty() {
    if(getHead() == null) {
        return true;
    }
    return false;
  }

//  returns node if it is in the queue
  public DNode searchQueue(DNode node) {
    DNode current = getHead();
    // int count = 0;
    while(current != null && current!= node) {
      current = current.getNext();
        // count++;
    }
    if(current != null && current == node) {
      return node;
    }
    else {
      return null;
    }
  }

// peeks into the queue
  public DNode peek() {
    if(getHead() == null) {
      return null;
    }
    return getHead();
  }
  public void clear(){
    setHead(null);
    setTail(null);
    setSize(0);
  }


}
