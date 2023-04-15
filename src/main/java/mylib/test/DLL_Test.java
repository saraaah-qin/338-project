package main.java.mylib.test;

import main.java.mylib.datastructures.linear.DLL;
import main.java.mylib.datastructures.nodes.DNode;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DLL_Test {

    // Test default constructor
    @Test
    public void testConstructor() {
        DLL dll = new DLL();
        assertNull(dll.getHead());
        assertNull(dll.getTail());
    }

    // Test constructor with node
    @Test
    public void testConstructorWithNode() {
        DNode head = new DNode(1);
        DNode tail = new DNode(2);
        DLL dll = new DLL(head, tail);
        assertEquals(head, dll.getHead());
        assertEquals(tail, dll.getTail());
    }

    // Test set size method
    @Test
    public void testSetSize() {
        DLL dll = new DLL();
        dll.setSize(1);
        assertEquals(1, dll.getSize());
    }

    // Test get size method
    @Test
    public void testGetSize() {
        DLL dll = new DLL();
        dll.setSize(1);
        assertEquals(1, dll.getSize());
    }

    // Test set head method
    @Test
    public void testSetHead() {
        DLL dll = new DLL();
        DNode head = new DNode(1);
        dll.setHead(head);
        assertEquals(head, dll.getHead());
    }

    // Test get head method
    @Test
    public void testGetHead() {
        DLL dll = new DLL();
        DNode head = new DNode(1);
        DNode head2 = new DNode(3);
        dll.setHead(head);
        dll.setHead(head2);
        assertEquals(head2, dll.getHead());
    }

    // Test set sort method
    // Test get sort method

    // Test set tail pointer method
    // Test get tail pointer method

    // Test set tail method
    @Test
    public void testSetTail() {
        DLL dll = new DLL();
        DNode tail = new DNode(1);
        DNode tail2 = new DNode(3);
        dll.setTail(tail2);
        dll.setTail(tail);
        assertEquals(tail, dll.getTail());
    }

    // Test get tail method
    @Test
    public void testGetTail() {
        DLL dll = new DLL();
        DNode tail = new DNode(1);
        DNode tail2 = new DNode(3);
        dll.setTail(tail);
        dll.setTail(tail2);
        assertEquals(tail2, dll.getTail());
    }

    // Test insert head method
    @Test
    public void testInsertHead() {
        DLL dll = new DLL();
        DNode head = new DNode(1);
        DNode head2 = new DNode(3);
        dll.insertHead(head);
        dll.insertHead(head2);
        assertEquals(head2, dll.getHead());
        assertEquals(head, dll.getTail());
    }

    // Test insert tail method
    @Test
    public void testInsertTail() {
        DLL dll = new DLL();
        DNode tail = new DNode(1);
        DNode tail2 = new DNode(3);
        dll.insertTail(tail);
        dll.insertTail(tail2);
        assertEquals(tail, dll.getHead());
        assertEquals(tail2, dll.getTail());
    }

    // Test insert at position method
    @Test
    public void testInsertAtPosition() {
        DLL dll = new DLL();
        DNode head = new DNode(1);
        DNode middle = new DNode(2);
        DNode tail = new DNode(3);
        dll.insertHead(head);
        dll.insertTail(tail);
        dll.insert(middle, 2); // Insert at position 2?
        assertEquals(head, dll.getHead());
        assertEquals(middle, dll.getHead().getNext());
        assertEquals(tail, dll.getTail());
    }

    // Test sorted insert method
    @Test
    public void testSortedInsert() {
        DLL dll = new DLL();
        DNode head = new DNode(1);
        DNode middle = new DNode(2);
        DNode tail = new DNode(3);
        dll.insertHead(head);
        dll.insertTail(tail);
        dll.sortedInsert(middle);
        assertEquals(head, dll.getHead());
        assertEquals(tail, dll.getHead().getNext());
        assertEquals(middle, dll.getTail());
    }

    // Test sort method
    @Test
    public void testSort() {
        DLL dll = new DLL();
        DNode head = new DNode(3);
        DNode middle = new DNode(2);
        DNode tail = new DNode(1);
        dll.insertHead(head);
        dll.insertHead(tail);
        dll.insertHead(middle);

        dll.sort();

        assertEquals(tail, dll.getHead());
        assertEquals(middle, dll.getHead().getNext());
        assertEquals(head, dll.getTail());
    }

    // Test delete head method
    @Test
    public void testDeleteHead() {
        DLL dll = new DLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(3);
        dll.insertHead(node);
        dll.insertHead(node2);
        dll.deleteHead();

        // Check that node2 is now null
        assertNull(dll.search(node2));

        // Check that head is now the original head
        assertEquals(node, dll.getHead());
        assertEquals(node, dll.getTail());
    }

    // Test delete tail method
    @Test
    public void testDeleteTail() {
        DLL dll = new DLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(3);
        dll.insertHead(node);
        dll.insertHead(node2);
        dll.deleteTail();

        // Check that node is now null
        assertNull(dll.search(node));

        // Check that tail is now the original tail
        assertEquals(node2, dll.getHead());
        assertEquals(node2, dll.getTail());
    }

    // Test delete node method
    @Test
    public void testDeleteNode() {
        DLL dll = new DLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(3);
        dll.insertHead(node);
        dll.insertHead(node2);
        dll.deleteNode(node);

        // Check that node is now null
        assertNull(dll.search(node));

        // Check that tail is now the original tail
        assertEquals(node2, dll.getHead());
        assertEquals(node2, dll.getTail());
    }

    // Test search method
    @Test
    public void testSearch() {
        DLL dll = new DLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(2);

        // Test search for node in list
        dll.insertHead(node);
        assertEquals(node, dll.search(node));

        // Test search for node not in list
        assertNull(dll.search(node2));
    }

    // Test clear method
    @Test
    public void testClear() {
        DLL dll = new DLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);

        dll.insertHead(node);
        dll.insertTail(node2);
        dll.insertHead(node3);
        dll.insertTail(node4);

        dll.clear();
        assertNull(dll.getHead());
    }

    // Test print method
    @Test
    public void testPrintUnsorted() {
        DLL dll = new DLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);

        dll.insertHead(node);
        dll.insertTail(node2);
        dll.insertHead(node3);
        dll.insertTail(node4);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        dll.print();

        String expectedOutput = "List size: " + dll.getSize() + "\n" + "Sorted: " + dll.isSorted()
                + "\n" + node3 + "\n" + node + "\n" + node2 + "\n" + node4 + "\n";
        assertEquals(expectedOutput, outContent.toString());

    }

    @Test
    public void testPrintSorted() {
        DLL dll = new DLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);

        dll.insertHead(node);
        dll.insertTail(node2);
        dll.insertHead(node3);
        dll.insertTail(node4);

        dll.sort();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        dll.print();

        String expectedOutput = "List size: " + dll.getSize() + "\n" + "Sorted: " +
                dll.isSorted()
                + "\n" + node + "\n" + node2 + "\n" + node3 + "\n" + node4 + "\n";
        assertEquals(expectedOutput, outContent.toString());

    }

    // Test for sequential insert and delete with different methods
    @Test
    public void testSequentialInsertAndDelete() {
        DLL dll = new DLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);

        dll.insertHead(node);
        assertEquals(node, dll.getHead());
        dll.insertTail(node2);
        assertEquals(node2, dll.getTail());
        dll.insertHead(node3);
        assertEquals(node3, dll.getHead());
        dll.insertTail(node4);
        assertEquals(node4, dll.getTail());

        dll.deleteHead();
        assertEquals(node, dll.getHead());
        dll.deleteTail();
        assertEquals(node2, dll.getTail());
        dll.deleteNode(node2);

        assertEquals(node, dll.getHead());
        assertEquals(node, dll.getTail());
    }

}
