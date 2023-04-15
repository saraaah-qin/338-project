package main.java.mylib.test;

import main.java.mylib.datastructures.trees.BST;
import main.java.mylib.datastructures.nodes.TNode;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BST_test {

    // Test default constructor
    @Test
    public void testConstructor() {
        BST bst = new BST();
        assertNull(bst.getRoot());
    }

    // Test constructor with integer value
    @Test
    public void testConstructorWithVal() {
        BST bst = new BST(50);
        assertEquals(50, bst.getRoot().getData());
    }

    // Test constructor with node
    @Test
    public void testConstructorWithNode() {
        TNode node = new TNode();
        node.setData(50);
        BST bst = new BST(node);
        assertEquals(50, bst.getRoot().getData());
    }

    // Test setRoot
    @Test
    public void testSetRoot() {
        BST bst = new BST();
        TNode node = new TNode();
        node.setData(50);
        bst.setRoot(node);
        assertEquals(50, bst.getRoot().getData());
    }

    // Test getRoot
    @Test
    public void testGetRoot() {
        BST bst = new BST();
        TNode node = new TNode();
        node.setData(50);
        bst.setRoot(node);
        assertEquals(50, bst.getRoot().getData());
    }

    // Test insert with integer value
    @Test
    public void testInsertVal() {
        BST bst1 = new BST();
        bst1.Insert(50);
        bst1.Insert(30);
        bst1.Insert(70);
        bst1.Insert(20);
        bst1.Insert(40);
        bst1.Insert(60);
        bst1.Insert(80);
        assertEquals(50, bst1.Search(50).getData());
        assertEquals(30, bst1.Search(30).getData());
        assertEquals(70, bst1.Search(70).getData());
        assertEquals(20, bst1.Search(20).getData());
        assertEquals(40, bst1.Search(40).getData());
        assertEquals(60, bst1.Search(60).getData());
        assertEquals(80, bst1.Search(80).getData());
    }

    // Test insert with node
    @Test
    public void testInsertNode() {
        BST bst2 = new BST();
        TNode node1 = new TNode();
        node1.setData(50);
        bst2.Insert(node1);
        assertNull(bst2.Search(50).getParent());
    }

    // Test search
    @Test
    public void testSearch() {
        BST bst3 = new BST();
        bst3.Insert(50);
        bst3.Insert(30);
        bst3.Insert(70);
        assertNull(bst3.Search(90));
    }

    // Test delete with integer value
    @Test
    public void testDelete() {
        BST bst4 = new BST();
        bst4.Insert(50);
        bst4.Insert(30);
        bst4.Insert(70);
        bst4.Insert(20);
        bst4.Insert(40);
        bst4.Insert(60);
        bst4.Insert(80);
        bst4.Delete(30);
        assertNull(bst4.Search(30));
    }

    // Test delete with node
    @Test
    public void testDelete2() {
        BST bst5 = new BST();
        bst5.Insert(50);
        bst5.Insert(30);
        bst5.Insert(70);
        String result = bst5.Delete(90);
        assertEquals("Node not found", result);
    }

    // Test printInOrder
    @Test
    public void testPrintInOrder() {
        BST bst = new BST();
        bst.Insert(50);
        bst.Insert(30);
        bst.Insert(20);
        bst.Insert(40);
        bst.Insert(70);
        bst.Insert(60);
        bst.Insert(80);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.printInOrder();

        String expectedOutput = "20 30 40 50 60 70 80 ";
        assertEquals(expectedOutput, outContent.toString());
    }

    // Test printPreOrder
    @Test
    public void testPrintBF() {
        BST bst = new BST();
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

        String expectedOutput = "50 \n30 70 \n20 40 60 80 \n";
        assertEquals(expectedOutput, outContent.toString());
    }

    // Test sequential insert and delete
    @Test
    public void sequentialInsertDelete() {
        BST bst = new BST();

        // Check that the root is null before any insertions
        assertNull(bst.getRoot());

        // Insert 7 nodes
        bst.Insert(5);
        assertEquals(5, bst.Search(5).getData());
        bst.Insert(3);
        assertEquals(3, bst.Search(3).getData());
        bst.Insert(2);
        assertEquals(2, bst.Search(2).getData());
        bst.Insert(4);
        assertEquals(4, bst.Search(4).getData());
        bst.Insert(7);
        assertEquals(7, bst.Search(7).getData());
        bst.Insert(6);
        assertEquals(6, bst.Search(6).getData());
        bst.Insert(8);
        assertEquals(8, bst.Search(8).getData());

        bst.Delete(8);
        assertNull(bst.Search(8));
        bst.Delete(6);
        assertNull(bst.Search(6));
        bst.Delete(7);
        assertNull(bst.Search(7));
        bst.Delete(4);
        assertNull(bst.Search(4));
        bst.Delete(2);
        assertNull(bst.Search(2));
        bst.Delete(3);
        assertNull(bst.Search(3));
        bst.Delete(5);
        assertNull(bst.Search(5));

        // Check that the root is null after all deletions
        assertNull(bst.getRoot());

        // Check insertion after deletion
        bst.Insert(15);
        assertEquals(15, bst.Search(15).getData());
    }
}
