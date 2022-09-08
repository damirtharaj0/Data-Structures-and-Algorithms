/*
    Lab 4

    Daniel Amirtharaj

    This assignment demonstrates a Binary Search Tree and their methods
 */

package BinarySearchTree;
import ObjectOrientedDesign.Currency;

public class BSTNode {
    private Currency data;
    private BSTNode left;
    private BSTNode right;

    public BSTNode() {
        data = null;
        left = null;
        right = null;
    }

    public BSTNode(Currency data) {
        this.data = data;
        left = null;
        right = null;
    }

    public BSTNode(Currency data, BSTNode left, BSTNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Currency getData() {
        return data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setData(Currency data) {
        this.data = data;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
}
