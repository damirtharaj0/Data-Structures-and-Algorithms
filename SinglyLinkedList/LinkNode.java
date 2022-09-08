/*
    Lab 3

    Daniel Amirtharaj

    This assignment demonstrates creating and using the ADTs Singly Linked List, Stack, and Queue
 */

package SinglyLinkedList;

import ObjectOrientedDesign.*;

public class LinkNode {
    private Currency data;
    private LinkNode next;


    LinkNode() {
        data = null;
        next = null;
    }

    public LinkNode(Currency data, LinkNode next) {
        this.data = data;
        this.next = next;
    }
    LinkNode(Currency data) {
        this.data = data;
        this.next = null;
    }

    public Currency getData() {
        return data;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setData(Currency data) {
        this.data = data;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }
}
