package main.java.mylib.test;

import main.java.mylib.datastructures.linear.StackLL;
import main.java.mylib.datastructures.nodes.DNode;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackLL_Test {

    // Test default constructor
    @Test
    public void testConstructor() {
        StackLL stack = new StackLL();
        assertNull(stack.getHead());
        assertEquals(0, stack.getSize());
    }

    // Test constructor with node
    @Test
    public void testConstructorWithNode() {
        DNode head = new DNode(1);
        StackLL stack = new StackLL(head);
        assertEquals(head, stack.getHead());
        assertEquals(0, stack.getSize());
    }

    // Test set head method
    @Test
    public void testSetHead() {
        StackLL stack = new StackLL();
        DNode head = new DNode(1);
        stack.setHead(head);
        assertEquals(head, stack.getHead());
    }

    // Test get head method
    @Test
    public void testGetHead() {
        StackLL stack = new StackLL();

        // Test null head case
        assertNull(stack.getHead());

        // Test non-null head case
        DNode head = new DNode(1);
        stack.setHead(head);
        assertEquals(head, stack.getHead());
    }

    // Test set size method
    @Test
    public void testSetSize() {
        StackLL stack = new StackLL();
        stack.setSize(1);
        assertEquals(1, stack.getSize());
    }

    // Test get size method
    @Test
    public void testGetSize() {
        StackLL stack = new StackLL();
        stack.setSize(1);
        assertEquals(1, stack.getSize());
    }

    // Test push method
    @Test
    public void testPush() {
        StackLL stack = new StackLL();
        DNode head = new DNode(1);
        stack.push(head);
        assertEquals(head, stack.getHead());
        assertEquals(1, stack.getSize());
    }

    // Test pop method
    @Test
    public void testPop() {
        StackLL stack = new StackLL();
        DNode head = new DNode(1);
        stack.push(head);
        assertEquals(head, stack.pop());
        assertEquals(0, stack.getSize());
    }

    // Test isEmpy method
    @Test
    public void testIsEmpty() {
        StackLL stack = new StackLL();
        assertTrue(stack.isEmpty());
        DNode head = new DNode(1);
        stack.push(head);
        assertFalse(stack.isEmpty());
    }

    // Test delete method
    @Test
    public void testDelete() {
        StackLL stack = new StackLL();
        DNode head = new DNode(1);
        stack.push(head);
        stack.delete(head);
        assertNull(stack.getHead());
        assertEquals(0, stack.getSize());
    }

    // Test for sequential insert and delete with different methods
    @Test
    public void testInsertDelete() {
        StackLL stack = new StackLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        stack.push(node);
        assertEquals(node, stack.pop());
        stack.push(node2);
        assertEquals(node2, stack.pop());
        stack.push(node3);
        assertEquals(node3, stack.pop());

        assertEquals(0, stack.getSize());
    }

}
