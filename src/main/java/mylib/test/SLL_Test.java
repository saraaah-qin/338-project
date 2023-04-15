package main.java.mylib.test;

import main.java.mylib.datastructures.linear.SLL;
import main.java.mylib.datastructures.nodes.DNode;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SLL_Test {

    // Test default constructor
    @Test
    public void testConstructor() {
        SLL sll = new SLL();
        assertNull(sll.getHead());
    }

    // Test constructor with node
    @Test
    public void testConstructorWithNode() {
        DNode node = new DNode(1);
        SLL sll = new SLL(node);
        assertEquals(node, sll.getHead());
    }

    // Test set sorted
    @Test
    public void testSetSorted() {
        SLL sll = new SLL();
        DNode node = new DNode(1);
        sll.setSorted(node);
        assertEquals(node, sll.getSorted());
    }

    // Test get sorted
    @Test
    public void testGetSorted() {
        SLL sll = new SLL();
        assertNull(sll.getSorted());
    }

    // Test set head
    @Test
    public void testSetHead() {
        SLL sll = new SLL();
        DNode node = new DNode(1);
        sll.setHead(node);
        assertEquals(node, sll.getHead());
    }

    // Test get head
    @Test
    public void testGetHead() {
        SLL sll = new SLL();
        assertNull(sll.getHead());
    }

    // Test set size
    @Test
    public void testSetSize() {
        SLL sll = new SLL();
        sll.setSize(1);
        assertEquals(1, sll.getSize());
    }

    // Test get size
    @Test
    public void testGetSize() {
        SLL sll = new SLL();
        assertEquals(0, sll.getSize());
    }

    // Test insertHead Method
    @Test
    public void testInsertAtHead() {
        SLL sll = new SLL();
        DNode node = new DNode(1);
        sll.insertHead(node);
        assertEquals(node, sll.getHead());
    }

    // Test insertAtTail Method
    @Test
    public void testInsertAtTail() {
        SLL sll = new SLL();
        DNode node = new DNode(1);
        sll.insertTail(node);
        assertEquals(node, sll.getHead());
    }

    // Test insert node at index method
    @Test
    public void testInsertAtPosition() {
        SLL sll = new SLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(2);
        sll.insertHead(node);
        sll.insert(node2, 1);
        assertEquals(node, sll.getHead());
    }

    // Test sorted insert method
    @Test
    public void testSortedInsert() {
        SLL sll = new SLL();
        DNode node = new DNode(1);
        DNode node3 = new DNode(4);
        sll.insertHead(node3);
        sll.sortedInsert(node);
        assertEquals(node, sll.getHead());
    }

    // Test search method
    @Test
    public void testSearch() {
        SLL sll = new SLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(2);

        // Test search for node in list
        sll.insertHead(node);
        assertEquals(node, sll.search(node));

        // Test search for node not in list
        assertNull(sll.search(node2));
    }

    // Test delete head method
    @Test
    public void testDeleteHead() {
        SLL sll = new SLL();
        DNode node = new DNode(1);

        // Test delete head when list is empty
        sll.insertHead(node);
        sll.deleteHead();
        assertNull(sll.getHead());

        // Test delete head when list is not empty
        sll.insertHead(node);
        DNode node2 = new DNode(2);
        sll.insertTail(node2);
        sll.deleteHead();
        assertEquals(node2, sll.getHead());
    }

    // Test delete tail method
    @Test
    public void testDeleteTail() {
        SLL sll = new SLL();
        DNode node = new DNode(1);

        // Test delete tail when tail is empty
        sll.insertHead(node);
        // sll.insertTail(node);
        if (sll.getTail() != null) {
            sll.deleteTail();
        }
        assertNull(sll.getTail());

        // Test delete tail when list is not empty
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        sll.insertHead(node2);
        sll.insertTail(node3);

        if (sll.getTail() != null) {
            sll.deleteTail();
        }
        assertNull(sll.getTail());

    }

    // Test delete node method
    @Test
    public void testDeleteNode() {
        SLL sll = new SLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);

        sll.insertHead(node);
        sll.insertTail(node2);
        sll.insertHead(node3);
        sll.insertTail(node4);

        // Test delete node when node is head
        if (sll.search(node2) != null) {
            sll.delete(node2);
        }

        assertNull(sll.search(node2));
    }

    // Test sort method
    @Test
    public void testSort() {
        SLL sll = new SLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);

        sll.insertHead(node);
        sll.insertTail(node2);
        sll.insertHead(node3);
        sll.insertTail(node4);

        sll.sort();
        assertEquals(node, sll.getHead());
    }

    // Test clear method
    @Test
    public void testClear() {
        SLL sll = new SLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);

        sll.insertHead(node);
        sll.insertTail(node2);
        sll.insertHead(node3);
        sll.insertTail(node4);

        sll.clear();
        assertNull(sll.getHead());
    }

    // Test print method (unsorted)
    @Test
    public void testPrintUnsorted() {
        SLL sll = new SLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);

        sll.insertHead(node);
        sll.insertTail(node2);
        sll.insertHead(node3);
        sll.insertTail(node4);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        sll.print();

        String expectedOutput = "List size: " + sll.getSize() + "\n" + "Sorted: " + sll.isSorted()
                + "\n" + node3 + "\n" + node + "\n" + node2 + "\n" + node4 + "\n";
        assertEquals(expectedOutput, outContent.toString());

    }

    // Test print method (sorted)
    @Test
    public void testPrintSorted() {
        SLL sll = new SLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);

        sll.insertHead(node);
        sll.insertTail(node2);
        sll.insertHead(node3);
        sll.insertTail(node4);

        sll.sort();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        sll.print();

        String expectedOutput = "List size: " + sll.getSize() + "\n" + "Sorted: " +
                sll.isSorted()
                + "\n" + node + "\n" + node2 + "\n" + node3 + "\n" + node4 + "\n";
        assertEquals(expectedOutput, outContent.toString());

    }

    // Test for sequential insert and delete with different methods
    @Test
    public void testSequentialInsertDelete() {
        SLL sll = new SLL();
        DNode node = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);

        sll.insertHead(node);
        assertEquals(node, sll.getHead());
        sll.insertHead(node2);
        assertEquals(node2, sll.getHead());
        sll.insertHead(node3);
        assertEquals(node3, sll.getHead());
        sll.insertTail(node4);
        assertEquals(node3, sll.getHead());

        sll.deleteHead();
        assertEquals(node2, sll.getHead());
        sll.delete(node2);

        assertEquals(node, sll.getHead());

    }

}
