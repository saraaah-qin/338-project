package main.java.mylib.datastructures.nodes;
public class DNode implements Comparable<DNode>{
    private int data;
    private DNode next;
    private DNode prev;
    
    public DNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
    public int getData() {
        return this.data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    public DNode getNext() {
        return this.next;
    }
    
    public void setNext(DNode next) {
        this.next = next;
    }
    
    public DNode getPrev() {
        return this.prev;
    }
    
    public void setPrev(DNode prev) {
        this.prev = prev;
    }
    @Override
    public int compareTo(DNode other) {
        return Integer.compare(this.data, other.data);
    }
}
