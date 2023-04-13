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

    @Test
    public void testConstructor() {
        AVL avl2 = new AVL();
        // Check if the root is null
        assertNull(avl2.getRoot());
    }

    @Test
    public void testConstructorWithVal() {
        AVL avl2 = new AVL(5);
        // Check if the tree contains the inserted values
        assertTrue(avlContains(avl2.getRoot(), 5));
    }

    @Test
    public void testConstructorWithNode() {
        AVL avl2 = new AVL(avl.getRoot());
        // Check if the tree contains the inserted values
        assertTrue(avlContains(avl2.getRoot(), 5));
    }

    @Test
    public void testSetRoot() {
        // Check if the root is set correctly
        TNode root = new TNode();
        root.setData(10);
        avl.setRoot(root);
        assertEquals(10, avl.getRoot().getData());
    }

    @Test
    public void testGetRoot() {
        // Check if the root is correct
        assertEquals(5, avl.getRoot().getData());
    }

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

    @Test
    public void testInsertNode() {
        AVL avl2 = new AVL();
        avl2.Insert(avl.getRoot());
        // Check if the tree contains the inserted values
        assertTrue(avlContains(avl2.getRoot(), 5));
    }

    // @Test
    // public void testBalance() {
    // // Check if the tree is balanced
    // assertTrue(isBalanced(avl.getRoot()));
    // }

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

    // private boolean isBalanced(TNode node) {
    // if (node == null) {
    // return true;
    // }

    // int balanceFactor = Math.abs((avl.getHeight(node.getLeft())) -
    // avl.getHeight(node.getRight()));
    // if (balanceFactor > 1) {
    // return false;
    // }

    // return isBalanced(node.getLeft()) && isBalanced(node.getRight());
    // }
}
