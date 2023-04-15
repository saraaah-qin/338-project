package main.java.mylib.test;

import main.java.mylib.datastructures.linear.QueueLL;
import main.java.mylib.datastructures.nodes.DNode;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueLL_Test {

    // Test default constructor
    @Test
    public void testConstructor() {
        QueueLL queue = new QueueLL();
        assertNull(queue.getHead());
        assertNull(queue.getTail());
        assertEquals(0, queue.getSize());
    }

    // Test constructor with node and tail
    @Test
    public void testConstructorWithNodeAndTail() {
        DNode head = new DNode(1);
        DNode tail = new DNode(2);
        QueueLL queue = new QueueLL(head, tail);
        assertEquals(head, queue.getHead());
        assertEquals(tail, queue.getTail());
        assertEquals(0, queue.getSize());
    }

    // Test set and get size method
    @Test
    public void testSetAndGetSize() {
        QueueLL queue = new QueueLL();
        queue.setSize(1);
        assertEquals(1, queue.getSize());
    }

    // Test set and get head method
    @Test
    public void testSetAndGetHead() {
        QueueLL queue = new QueueLL();
        DNode head = new DNode(1);
        queue.setHead(head);
        assertEquals(head, queue.getHead());
    }

    // Test set and get tail method
    @Test
    public void testSetAndGetTail() {
        QueueLL queue = new QueueLL();
        DNode tail = new DNode(1);
        queue.setTail(tail);
        assertEquals(tail, queue.getTail());
    }

    // Test enqueue method
    @Test
    public void testEnqueue() {
        QueueLL queue = new QueueLL();
        DNode node = new DNode(1);
        queue.enqueue(node);
        assertEquals(node, queue.getHead());
        assertNull(queue.getTail());
        assertEquals(1, queue.getSize());
    }

    // Test dequeue method
    @Test
    public void testDequeue() {
        QueueLL queue = new QueueLL();
        DNode node = new DNode(1);
        queue.enqueue(node);
        queue.dequeue();

        assertNull(queue.getHead());
        assertNull(queue.getTail());
        assertEquals(0, queue.getSize());
    }

    // Test isEmpty method
    @Test
    public void testIsEmpty() {
        QueueLL queue = new QueueLL();
        assertTrue(queue.isEmpty());
    }

    // Test search method
    @Test
    public void testSearch() {
        QueueLL queue = new QueueLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(2);
        queue.enqueue(node);
        assertEquals(node, queue.search(node));
        assertNull(queue.search(node2));
    }

    // Test peek method
    @Test
    public void testPeek() {
        QueueLL queue = new QueueLL();
        DNode node = new DNode(1);
        queue.enqueue(node);
        assertEquals(node, queue.peek());
    }

    // Test for sequential insert and delete with different methods
    @Test
    public void testSequentialInsertAndDelete() {
        QueueLL queue = new QueueLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        queue.enqueue(node);
        assertEquals(node, queue.search(node));
        queue.enqueue(node2);
        assertEquals(node2, queue.search(node2));
        queue.enqueue(node3);
        assertEquals(node3, queue.search(node3));

        queue.dequeue();
        assertNull(queue.search(node));
        queue.dequeue();
        assertNull(queue.search(node2));
        queue.dequeue();
        assertNull(queue.search(node3));

    }

}
