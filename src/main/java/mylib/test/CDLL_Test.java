package main.java.mylib.test;

import main.java.mylib.datastructures.linear.CDLL;
import main.java.mylib.datastructures.nodes.DNode;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CDLL_Test {

    // Test default constructor
    @Test
    public void testConstructor() {
        CDLL cdll = new CDLL();
        assertNull(cdll.getHead());
        assertNull(cdll.getTail());
        assertEquals(0, cdll.getSize());
    }

    // Test constructor with node
    @Test
    public void testConstructorWithNode() {
        DNode head = new DNode(1);
        CDLL cdll = new CDLL(head);
        assertEquals(head, cdll.getHead());
        assertEquals(head, cdll.getTail());
        assertEquals(0, cdll.getSize());
    }

    // Test insert head method
    @Test
    public void testInsertHead() {
        CDLL cdll = new CDLL();
        DNode head = new DNode(1);
        DNode head2 = new DNode(2);

        // Test insert head with empty list
        cdll.insertHead(head);
        assertEquals(head, cdll.getHead());

        // Test insert head with non-empty list
        cdll.insertHead(head2);
        assertEquals(head2, cdll.getHead());
    }

    // Test insert tail method
    @Test
    public void testInsertTail() {
        CDLL cdll = new CDLL();
        DNode tail = new DNode(1);
        DNode tail2 = new DNode(2);

        // Test insert tail with empty list
        cdll.insertTail(tail);
        assertEquals(tail, cdll.getTail());

        // Test insert tail with non-empty list
        cdll.insertTail(tail2);
        assertEquals(tail2, cdll.getTail());
    }

    // Test delete node
    @Test
    public void testDeleteNode() {
        CDLL cdll = new CDLL();
        DNode head = new DNode(1);
        DNode tail = new DNode(2);
        DNode middle = new DNode(3);

        cdll.insertHead(head);
        cdll.insertTail(tail);
        cdll.insertTail(middle);
        cdll.deleteNode(tail);

        // Test delete node with non-empty list
        assertEquals(middle, cdll.getTail());
    }

    // Test for sequential insert and delete with different methods
    @Test
    public void testInsertDelete() {
        CDLL cdll = new CDLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        cdll.insertHead(node);
        assertEquals(node, cdll.getHead());
        cdll.insertTail(node3);
        assertEquals(node3, cdll.getTail());
        cdll.insertTail(node2);
        assertEquals(node2, cdll.getTail());
        cdll.deleteNode(node2);
        assertEquals(node3, cdll.getTail());

        cdll.deleteHead();
        assertEquals(node3, cdll.getHead());
    }

}
