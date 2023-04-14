package main.java.mylib.test;

import main.java.mylib.datastructures.linear.CSLL;
import main.java.mylib.datastructures.nodes.DNode;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CSLL_Test {

    // Test default constructor
    @Test
    public void testConstructor() {
        CSLL csll = new CSLL();
        assertNull(csll.getHead());
        assertNull(csll.getTail());
        assertEquals(0, csll.getSize());
    }

    // Test constructor with node
    @Test
    public void testConstructorWithNode() {
        DNode head = new DNode(1);
        CSLL csll = new CSLL(head);
        assertEquals(head, csll.getHead());
        assertEquals(head, csll.getTail());
        assertEquals(0, csll.getSize());
    }

    // Test set head method
    @Test
    public void testSetHead() {
        CSLL csll = new CSLL();
        DNode head = new DNode(1);
        csll.setHead(head);
        assertEquals(head, csll.getHead());
    }

    // Test get head method
    @Test
    public void testGetHead() {
        CSLL csll = new CSLL();

        // Test null head case
        assertNull(csll.getHead());

        // Test non-null head case
        DNode head = new DNode(1);
        csll.setHead(head);
        assertEquals(head, csll.getHead());
    }

    // Test set tail method
    @Test
    public void testSetTail() {
        CSLL csll = new CSLL();
        DNode tail = new DNode(1);
        csll.setTail(tail);
        assertEquals(tail, csll.getTail());
    }

    // Test get tail method
    @Test
    public void testGetTail() {
        CSLL csll = new CSLL();

        // Test null tail case
        assertNull(csll.getTail());

        // Test non-null tail case
        DNode tail = new DNode(1);
        csll.setHead(tail);
        assertNull(csll.getTail());
    }

    // Test set size method
    @Test
    public void testSetSize() {
        CSLL csll = new CSLL();
        csll.setSize(1);
        assertEquals(1, csll.getSize());
    }

    // Test get size method
    @Test
    public void testGetSize() {
        CSLL csll = new CSLL();

        // Test null size case
        assertEquals(0, csll.getSize());

        // Test non-null size case
        csll.setSize(1);
        assertEquals(1, csll.getSize());
    }

    // Test set pointer to tail method
    @Test
    public void testSetandGetPointerToTail() {
        CSLL csll = new CSLL();
        DNode tail = new DNode(1);
        csll.setHead(tail);
        csll.setpointerToTail(tail);
        assertEquals(tail, csll.getpointerToTail());
    }

    // Test insert head method
    @Test
    public void testInsertHead() {
        CSLL csll = new CSLL();
        DNode head = new DNode(1);
        DNode head2 = new DNode(2);

        // Test null head case
        assertNull(csll.getHead());

        // Test non-null head case
        csll.insertHead(head);
        assertEquals(head, csll.getHead());

        // Check is head is updated
        csll.insertHead(head2);
        assertEquals(head2, csll.getHead());
    }

    // Test insert tail method
    @Test
    public void testInsertTail() {
        CSLL csll = new CSLL();
        DNode tail = new DNode(1);
        DNode tail2 = new DNode(2);

        // Test null tail case
        assertNull(csll.getTail());

        // Test non-null tail case
        csll.insertTail(tail);
        assertEquals(tail, csll.getTail());

        // Check is tail is updated
        csll.insertTail(tail2);
        assertEquals(tail2, csll.getTail());
    }

    // Test insert at position method
    @Test
    public void testInsertAtPosition() {
        CSLL csll = new CSLL();
        DNode head = new DNode(1);
        DNode node = new DNode(2);
        DNode tail = new DNode(3);

        csll.insertHead(head);
        csll.insertTail(tail);
        csll.insert(node, 2);
        assertEquals(node, csll.getHead().getNext());

    }

    // Test sorted insert method
    @Test
    public void testSortedInsert() {
        CSLL csll = new CSLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        csll.insertHead(node3);
        csll.insertHead(node2);
        csll.sortedInsert(node1);
        assertEquals(node1, csll.getHead());
    }

    // Test sort method
    @Test
    public void testSort() {
        CSLL csll = new CSLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        csll.insertHead(node2);
        csll.insertHead(node1);
        csll.insertHead(node3);
        csll.sort();
        assertEquals(node1, csll.getHead());
    }

    // Test search method
    @Test
    public void testSearch() {
        CSLL csll = new CSLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        csll.insertHead(node2);
        assertEquals(node2, csll.search(node2));
        assertNull(csll.search(node3));

        csll.insertHead(node1);
        csll.insertHead(node3);
        assertEquals(node1, csll.search(node1));
        assertEquals(node3, csll.search(node3));
    }

    // Test delete head method
    @Test
    public void testDeleteHead() {
        CSLL csll = new CSLL();
        DNode head = new DNode(1);
        DNode head2 = new DNode(2);

        // Test null head case
        assertNull(csll.getHead());

        // Test non-null head case
        csll.insertHead(head);
        csll.insertHead(head2);
        assertEquals(head2, csll.getHead());
        csll.deleteHead();
        assertNull(csll.search(head2));
    }

    // Test delete tail method
    @Test
    public void testDeleteTail() {
        CSLL csll = new CSLL();
        DNode tail = new DNode(1);
        DNode tail2 = new DNode(2);

        // Test null tail case
        assertNull(csll.getTail());

        // Test non-null tail case
        csll.insertTail(tail);
        csll.insertTail(tail2);
        assertEquals(tail2, csll.getTail());

        csll.deleteTail();
        assertNull(csll.search(tail2));

        // assertEquals(tail, csll.getTail());
    }

    // Test delete node method
    @Test
    public void testDeleteNode() {
        CSLL csll = new CSLL();
        DNode head = new DNode(1);
        DNode head2 = new DNode(2);
        DNode head3 = new DNode(3);

        csll.insertHead(head);
        csll.insertHead(head3);
        csll.insertHead(head2);

        csll.delete(head2);

        // assertEquals(head2, csll.search(head2));
        assertNull(csll.search(head2));
    }

    // // Test print method (unsorted)
    // @Test
    // public void testPrintUnsorted() {
    // CSLL csll = new CSLL();
    // DNode node = new DNode(1);
    // DNode node2 = new DNode(2);
    // DNode node3 = new DNode(3);
    // DNode node4 = new DNode(4);

    // csll.insertHead(node2);
    // csll.insertHead(node);
    // csll.insertHead(node4);
    // csll.insertHead(node3);

    // ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    // System.setOut(new PrintStream(outContent));

    // csll.print();

    // String expectedOutput = "List size: " + csll.getSize() + "\n" + "Sorted: " +
    // csll.isSorted()
    // + "\n" + node3 + "\n" + node4 + "\n" + node + "\n" + node2 + "\n";
    // assertEquals(expectedOutput, outContent.toString());

    // }

    // // Test print method (sorted)
    // @Test
    // public void testPrintSorted() {
    // CSLL csll = new CSLL();
    // DNode node = new DNode(1);
    // DNode node2 = new DNode(2);
    // DNode node3 = new DNode(3);
    // DNode node4 = new DNode(4);

    // csll.insertHead(node2);
    // csll.insertHead(node);
    // csll.insertHead(node4);
    // csll.insertHead(node3);

    // csll.sort();

    // ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    // System.setOut(new PrintStream(outContent));

    // csll.print();

    // String expectedOutput = "List size: " + csll.getSize() + "\n" + "Sorted: " +
    // csll.isSorted()
    // + "\n" + node + "\n" + node2 + "\n" + node3 + "\n" + node4 + "\n";
    // assertEquals(expectedOutput, outContent.toString());

    // }

}
