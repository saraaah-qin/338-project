package main.java.mylib.test;

import main.java.mylib.datastructures.trees.AVL;
import main.java.mylib.datastructures.nodes.TNode;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;

public class AVL_Test {
    private AVL avl;

    @Before
    public void setUp() {
        avl = new AVL();
        // Insert values into the AVL tree
        avl.Insert(5);
        avl.Insert(3);
        avl.Insert(7);
        avl.Insert(2);
        avl.Insert(4);
        avl.Insert(6);
        avl.Insert(8);
    }

    // Test for default constructor
    @Test
    public void testConstructor() {
        AVL avl2 = new AVL();
        // Check if the root is null
        assertNull(avl2.getRoot());
    }

    // Test for constructor with integer value
    @Test
    public void testConstructorWithVal() {
        AVL avl2 = new AVL(5);
        // Check if the tree contains the inserted values
        assertTrue(avlContains(avl2.getRoot(), 5));
    }

    // Test for constructor with node
    @Test
    public void testConstructorWithNode() {
        AVL avl2 = new AVL(avl.getRoot());
        // Check if the tree contains the inserted values
        assertTrue(avlContains(avl2.getRoot(), 5));
    }

    // Tests setRoot Method
    @Test
    public void testSetRoot() {
        // Check if the root is set correctly
        TNode root = new TNode();
        root.setData(10);
        avl.setRoot(root);
        assertEquals(10, avl.getRoot().getData());
    }

    // Tests getRoot Method
    @Test
    public void testGetRoot() {
        // Check if the root is correct
        assertEquals(5, avl.getRoot().getData());
    }

    // Tests insert with integer value
    @Test
    public void testInsertVal() {
        // Check if the tree contains the inserted values
        assertTrue(avlContains(avl.getRoot(), 5));
        assertTrue(avlContains(avl.getRoot(), 3));
        assertTrue(avlContains(avl.getRoot(), 7));
        assertTrue(avlContains(avl.getRoot(), 2));
        assertTrue(avlContains(avl.getRoot(), 4));
        assertTrue(avlContains(avl.getRoot(), 6));
        assertTrue(avlContains(avl.getRoot(), 8));

        // Check if the tree does not contain values that were not inserted
        assertFalse(avlContains(avl.getRoot(), 1));
        assertFalse(avlContains(avl.getRoot(), 9));
    }

    // Tests insert with node
    @Test
    public void testInsertNode() {
        AVL avl2 = new AVL();
        avl2.Insert(avl.getRoot());
        // Check if the tree contains the inserted values
        assertTrue(avlContains(avl2.getRoot(), 5));
    }

    // Tests Search method
    @Test
    public void testSearch() {
        // Check if the tree contains the inserted values
        assertTrue(avl.Search(5));
        assertTrue(avl.Search(3));
        assertTrue(avl.Search(7));
        assertTrue(avl.Search(2));
        assertTrue(avl.Search(4));
        assertTrue(avl.Search(6));

        // Check if the tree does not contain values that were not inserted
        assertFalse(avl.Search(1));
        assertFalse(avl.Search(9));

    }

    // Tests printInorder method
    @Test
    public void testInOrder() {
        // Check if the tree is traversed in order

        AVL avl3 = new AVL();
        avl3.Insert(50);
        avl3.Insert(30);
        avl3.Insert(20);
        avl3.Insert(40);
        avl3.Insert(70);
        avl3.Insert(60);
        avl3.Insert(80);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        avl3.printInorder();

        String expectedOutput = "20 30 40 50 60 70 80 ";
        assertEquals(expectedOutput, outContent.toString());
    }

    // Tests printBF method
    @Test
    public void testPrintBF() {
        AVL bst = new AVL();
        bst.Insert(50);
        bst.Insert(30);
        bst.Insert(20);
        bst.Insert(40);
        bst.Insert(70);
        bst.Insert(60);
        bst.Insert(80);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.printBF();

        String expectedOutput = "50 30 70 20 40 60 80 \n";
        assertEquals(expectedOutput, outContent.toString());
    }

    // Sequential insertion with default constructor
    @Test
    public void sequentialInsertDelete() {
        AVL avl2 = new AVL();
        // Check if the root is null
        assertNull(avl2.getRoot());

        // Insert values into the AVL tree
        avl2.Insert(5);
        assertTrue(avlContains(avl2.getRoot(), 5));
        avl2.Insert(3);
        assertTrue(avlContains(avl2.getRoot(), 3));
        avl2.Insert(7);
        assertTrue(avlContains(avl2.getRoot(), 7));
        avl2.Insert(2);
        assertTrue(avlContains(avl2.getRoot(), 2));
        avl2.Insert(4);
        assertTrue(avlContains(avl2.getRoot(), 4));
        avl2.Insert(6);
        assertTrue(avlContains(avl2.getRoot(), 6));
        avl2.Insert(8);
        assertTrue(avlContains(avl2.getRoot(), 8));

        // Sequentially delete values from the AVL tree
        avl2.Delete(2);
        assertFalse(avlContains(avl2.getRoot(), 2));
        avl2.Delete(3);
        assertFalse(avlContains(avl2.getRoot(), 3));
        avl2.Delete(5);
        assertFalse(avlContains(avl2.getRoot(), 5));
        avl2.Delete(7);
        assertFalse(avlContains(avl2.getRoot(), 7));
        avl2.Delete(4);
        assertFalse(avlContains(avl2.getRoot(), 4));
        avl2.Delete(6);
        assertFalse(avlContains(avl2.getRoot(), 6));
        avl2.Delete(8);
        assertFalse(avlContains(avl2.getRoot(), 8));

        // Check if the root is null after deletion of all values
        assertNull(avl2.getRoot());

        // insertion after deletion
        avl2.Insert(5);
        assertTrue(avlContains(avl2.getRoot(), 5));
    }

    // Sequential insertion with val constructor
    @Test
    public void sequentialInsertDeleteVal() {
        AVL avl2 = new AVL(5);
        // Check if the root is correct
        assertEquals(5, avl2.getRoot().getData());

        // Insert values into the AVL tree
        avl2.Insert(3);
        assertTrue(avlContains(avl2.getRoot(), 3));
        avl2.Insert(7);
        assertTrue(avlContains(avl2.getRoot(), 7));
        avl2.Insert(2);
        assertTrue(avlContains(avl2.getRoot(), 2));
        avl2.Insert(4);
        assertTrue(avlContains(avl2.getRoot(), 4));
        avl2.Insert(6);
        assertTrue(avlContains(avl2.getRoot(), 6));
        avl2.Insert(8);
        assertTrue(avlContains(avl2.getRoot(), 8));

        // Sequentially delete values from the AVL tree
        avl2.Delete(2);
        assertFalse(avlContains(avl2.getRoot(), 2));
        avl2.Delete(3);
        assertFalse(avlContains(avl2.getRoot(), 3));
        avl2.Delete(5);
        assertFalse(avlContains(avl2.getRoot(), 5));
        avl2.Delete(7);
        assertFalse(avlContains(avl2.getRoot(), 7));
        avl2.Delete(4);
        assertFalse(avlContains(avl2.getRoot(), 4));
        avl2.Delete(6);
        assertFalse(avlContains(avl2.getRoot(), 6));
        avl2.Delete(8);
        assertFalse(avlContains(avl2.getRoot(), 8));

        // Check if the root is null after deletion of all values
        assertNull(avl2.getRoot());

        // insertion after deletion
        avl2.Insert(5);
        assertTrue(avlContains(avl2.getRoot(), 5));
    }

    // // Sequential insertion with node constructor
    @Test
    public void sequentialInsertDeleteNode() {
        AVL avl2 = new AVL(new TNode(5, 0, null, null, null));
        // Check if the root is correct
        assertEquals(5, avl2.getRoot().getData());

        // Insert values into the AVL tree
        avl2.Insert(3);
        assertTrue(avlContains(avl2.getRoot(), 3));
        avl2.Insert(7);
        assertTrue(avlContains(avl2.getRoot(), 7));
        avl2.Insert(2);
        assertTrue(avlContains(avl2.getRoot(), 2));
        avl2.Insert(4);
        assertTrue(avlContains(avl2.getRoot(), 4));
        avl2.Insert(6);
        assertTrue(avlContains(avl2.getRoot(), 6));
        avl2.Insert(8);
        assertTrue(avlContains(avl2.getRoot(), 8));

        // Sequentially delete values from the AVL tree
        avl2.Delete(2);
        assertFalse(avlContains(avl2.getRoot(), 2));
        avl2.Delete(3);
        assertFalse(avlContains(avl2.getRoot(), 3));
        avl2.Delete(5);
        assertFalse(avlContains(avl2.getRoot(), 5));
        avl2.Delete(7);
        assertFalse(avlContains(avl2.getRoot(), 7));
        avl2.Delete(4);
        assertFalse(avlContains(avl2.getRoot(), 4));
        avl2.Delete(6);
        assertFalse(avlContains(avl2.getRoot(), 6));
        avl2.Delete(8);
        assertFalse(avlContains(avl2.getRoot(), 8));

        // Check if the root is null after deletion of all values
        assertNull(avl2.getRoot());

        // insertion after deletion
        avl2.Insert(5);
        assertTrue(avlContains(avl2.getRoot(), 5));
    }

    // Sequential insertion Node with default constructor
    @Test
    public void sequentialNodeInsertDelete() {
        AVL avl2 = new AVL();

        // Check if the root is null
        assertNull(avl2.getRoot());

        // Insert values into the AVL tree
        avl2.Insert(new TNode(3, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 3));
        avl2.Insert(new TNode(7, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 7));
        avl2.Insert(new TNode(2, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 2));
        avl2.Insert(new TNode(4, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 4));
        avl2.Insert(new TNode(6, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 6));
        avl2.Insert(new TNode(8, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 8));

        // Sequentially delete values from the AVL tree
        avl2.Delete(2);
        assertFalse(avlContains(avl2.getRoot(), 2));
        avl2.Delete(3);
        assertFalse(avlContains(avl2.getRoot(), 3));
        avl2.Delete(5);
        assertFalse(avlContains(avl2.getRoot(), 5));
        avl2.Delete(7);
        assertFalse(avlContains(avl2.getRoot(), 7));
        avl2.Delete(4);
        assertFalse(avlContains(avl2.getRoot(), 4));
        avl2.Delete(6);
        assertFalse(avlContains(avl2.getRoot(), 6));
        avl2.Delete(8);
        assertFalse(avlContains(avl2.getRoot(), 8));

        // Check if the root is null after deletion of all values
        assertNull(avl2.getRoot());

        // insertion after deletion
        avl2.Insert(new TNode(5, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 5));
    }

    // Sequential insertion Node with val constructor
    @Test
    public void sequentialNodeInsertDeleteVal() {
        AVL avl2 = new AVL(5);
        // Check if the root is correct
        assertEquals(5, avl2.getRoot().getData());

        // Insert values into the AVL tree
        avl2.Insert(new TNode(3, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 3));
        avl2.Insert(new TNode(7, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 7));
        avl2.Insert(new TNode(2, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 2));
        avl2.Insert(new TNode(4, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 4));
        avl2.Insert(new TNode(6, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 6));
        avl2.Insert(new TNode(8, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 8));

        // Sequentially delete values from the AVL tree
        avl2.Delete(2);
        assertFalse(avlContains(avl2.getRoot(), 2));
        avl2.Delete(3);
        assertFalse(avlContains(avl2.getRoot(), 3));
        avl2.Delete(5);
        assertFalse(avlContains(avl2.getRoot(), 5));
        avl2.Delete(7);
        assertFalse(avlContains(avl2.getRoot(), 7));
        avl2.Delete(4);
        assertFalse(avlContains(avl2.getRoot(), 4));
        avl2.Delete(6);
        assertFalse(avlContains(avl2.getRoot(), 6));
        avl2.Delete(8);
        assertFalse(avlContains(avl2.getRoot(), 8));

        // Check if the root is null after deletion of all values
        assertNull(avl2.getRoot());

        // insertion after deletion
        avl2.Insert(new TNode(3, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 3));
    }

    // Sequential insertion Node with node constructor
    @Test
    public void sequentialNodeInsertDeleteNode() {
        AVL avl2 = new AVL(new TNode(5, 0, null, null, null));
        // Check if the root is correct
        assertEquals(5, avl2.getRoot().getData());

        // Insert values into the AVL tree
        avl2.Insert(new TNode(3, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 3));
        avl2.Insert(new TNode(7, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 7));
        avl2.Insert(new TNode(2, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 2));
        avl2.Insert(new TNode(4, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 4));
        avl2.Insert(new TNode(6, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 6));
        avl2.Insert(new TNode(8, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 8));

        // Sequentially delete values from the AVL tree
        avl2.Delete(2);
        assertFalse(avlContains(avl2.getRoot(), 2));
        avl2.Delete(3);
        assertFalse(avlContains(avl2.getRoot(), 3));
        avl2.Delete(5);
        assertFalse(avlContains(avl2.getRoot(), 5));
        avl2.Delete(7);
        assertFalse(avlContains(avl2.getRoot(), 7));
        avl2.Delete(4);
        assertFalse(avlContains(avl2.getRoot(), 4));
        avl2.Delete(6);
        assertFalse(avlContains(avl2.getRoot(), 6));
        avl2.Delete(8);
        assertFalse(avlContains(avl2.getRoot(), 8));

        // Check if the root is null after deletion of all values
        assertNull(avl2.getRoot());

        // insertion after deletion
        avl2.Insert(new TNode(3, 0, null, null, null));
        assertTrue(avlContains(avl2.getRoot(), 3));
    }

    // BONUS DELETE TEST
    @Test
    public void testDelete() {
        // Check if the tree contains the inserted values
        assertTrue(avlContains(avl.getRoot(), 5));
        assertTrue(avlContains(avl.getRoot(), 3));
        assertTrue(avlContains(avl.getRoot(), 7));
        assertTrue(avlContains(avl.getRoot(), 2));
        assertTrue(avlContains(avl.getRoot(), 4));
        assertTrue(avlContains(avl.getRoot(), 6));
        assertTrue(avlContains(avl.getRoot(), 8));

        // Check if the tree does not contain values that were not inserted
        assertFalse(avlContains(avl.getRoot(), 1));
        assertFalse(avlContains(avl.getRoot(), 9));

        // Delete a node with no children
        avl.Delete(2);
        // Check if the tree does not contain the deleted value
        assertFalse(avlContains(avl.getRoot(), 2));

        // Delete a node with one child
        avl.Delete(3);
        // Check if the tree does not contain the deleted value
        assertFalse(avlContains(avl.getRoot(), 3));

        // Delete a node with two children
        avl.Delete(5);
        // Check if the tree does not contain the deleted value
        assertFalse(avlContains(avl.getRoot(), 5));
    }

    private boolean avlContains(TNode node, int val) {
        if (node == null) {
            return false;
        }

        if (node.getData() == val) {
            return true;
        } else if (val < node.getData()) {
            return avlContains(node.getLeft(), val);
        } else {
            return avlContains(node.getRight(), val);
        }
    }
}
