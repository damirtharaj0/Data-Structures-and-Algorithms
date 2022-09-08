/*
    Lab 4

    Daniel Amirtharaj

    This assignment demonstrates a Binary Search Tree and their methods
 */

package BinarySearchTree;

import ObjectOrientedDesign.Currency;
import Queue.Queue;

public class BST {
    private BSTNode root;

    public BST() {
        this.root = null;
    }

    public BST(BSTNode root) {
        this.root = root;
    }

    // This getter method returns the root node
    public BSTNode getRoot() {
        return root;
    }

    // This setter method sets the root node
    public void setRoot(BSTNode root) {
        this.root = root;
    }

    // This method traverses through the tree breadth first
    public void breadthFirst() {
        BSTNode curNode = root;
        Queue queue = new Queue();
        while (curNode != null) {
            curNode.getData().print();
            System.out.println();
            if (curNode.getLeft() != null) {
                queue.enqueue(curNode.getLeft().getData());
            }
            if (curNode.getRight() != null) {
                queue.enqueue(curNode.getRight().getData());
            }
            if (!queue.isListEmpty()) {
                try {
                    curNode = search(queue.dequeue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                curNode = null;
            }
        }
    }

    // This method returns the count of the tree
    int count(BSTNode root)
    {
        if (root == null)
            return 0;
        else if (count(root.getLeft()) > count(root.getRight()))
            return (count(root.getLeft()) + 1);
        else
            return (count(root.getRight()) + 1);
    }

    // This method traverses through the tree in order
    public void inOrder(BSTNode curNode) {
        if (curNode == null)
            return;
        inOrder(curNode.getLeft());
        curNode.getData().print();
        System.out.println();
        inOrder(curNode.getRight());
    }

    // This method traverses through the tree in pre order
    public void preOrder(BSTNode curNode) {
        if (curNode == null)
            return;
        curNode.getData().print();
        System.out.println();
        preOrder(curNode.getLeft());
        preOrder(curNode.getRight());
    }

    // This method traverses through the tree in post order
    public void postOrder(BSTNode curNode) {
        if (curNode == null)
            return;
        postOrder(curNode.getLeft());
        postOrder(curNode.getRight());
        curNode.getData().print();
        System.out.println();
    }

    // This method checks if the tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // This method prints the elements of the tree
    public void print(BSTNode node) throws Exception {
        if (node == null) {
            return;
        }
        print(node.getLeft());
        node.getData().print();
        System.out.println();
        print(node.getRight());
    }

    // This method searches for a currency in the tree
    public BSTNode search(Currency cur) throws Exception {
        if (root == null) {
            throw new Exception("Tree is empty");
        }
        BSTNode curNode = root;
        while (curNode != null) {
            if (((cur.getCurrencyName().equals(curNode.getData().getCurrencyName()) &&
                    (cur.getFraction() == curNode.getData().getFraction()) &&
                    (cur.getWhole() == curNode.getData().getWhole())))) {
                return curNode;
            } else if (curNode.getData().isGreater(cur)) {
                curNode = curNode.getLeft();
            } else {
                curNode = curNode.getRight();
            }
        }
        return null;
    }

    // This method inserts a node into the tree
    public void insert(Currency cur) throws Exception {
        BSTNode node = new BSTNode(cur);
        if (root == null) {
            root = node;
        } else {
            BSTNode curNode = root;
            while (curNode != null) {
                if (curNode.getData().isGreater(node.getData())) {
                    if (curNode.getLeft() == null) {
                        curNode.setLeft(node);
                        curNode = null;
                    } else {
                        curNode = curNode.getLeft();
                    }
                } else if (node.getData().isGreater(curNode.getData())){
                    if (curNode.getRight() == null) {
                        curNode.setRight(node);
                        curNode = null;
                    } else {
                        curNode = curNode.getRight();
                    }
                } else {
                    return; // duplicate node exists in tree
                }
            }
        }
    }

    // This method deletes a currency from the tree
    public BSTNode delete(Currency cur) throws Exception {
        BSTNode prevNode = null;
        BSTNode curNode = root;
        while (curNode != null) {
            if (((cur.getCurrencyName().equals(curNode.getData().getCurrencyName()) &&
                    (cur.getFraction() == curNode.getData().getFraction()) &&
                    (cur.getWhole() == curNode.getData().getWhole())))) {
                if (curNode.getLeft() == null && curNode.getRight() == null) {
                    if (prevNode == null)
                        root = null;
                    else if (prevNode.getLeft() == curNode)
                        prevNode.setLeft(null);
                    else
                        prevNode.setRight(null);
                } else if (curNode.getRight() == null) {
                    if (prevNode == null)
                        root = curNode.getLeft();
                    else if (prevNode.getLeft() == curNode)
                        prevNode.setLeft(curNode.getLeft());
                    else
                        prevNode.setRight(curNode.getLeft());
                } else if (curNode.getLeft() == null) {
                    if (prevNode == null)
                        root = curNode.getRight();
                    else if (prevNode.getLeft() == curNode)
                        prevNode.setLeft(curNode.getRight());
                    else
                        prevNode.setRight(curNode.getRight());
                } else {
                    BSTNode nextNode = curNode.getRight();
                    while (nextNode.getLeft() != null)
                        nextNode = nextNode.getLeft();
                    Currency nextCur = nextNode.getData().copy();
                    delete(nextNode.getData());
                    curNode.setData(nextCur);
                }
                return curNode;
            } else if (cur.isGreater(curNode.getData())) {
                prevNode = curNode;
                curNode = curNode.getRight();
            } else {
                prevNode = curNode;
                curNode = curNode.getLeft();
            }
        }
        return null;
    }
}
