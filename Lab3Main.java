/*
    Lab 3

    Daniel Amirtharaj

    This assignment demonstrates creating and using the ADTs Singly Linked List, Stack, and Queue
 */

import ObjectOrientedDesign.*;
import SinglyLinkedList.*;
import Stack.Stack;
import Queue.Queue;

public class Lab3Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Hi, I am Daniel Amirtharaj. Welcome to Lab 3.");

        double[] values = new double[] {57.12, 23.44, 87.43, 68.99, 111.22, 44.55, 77.77, 18.36, 543.21, 20.21, 345.67, 36.18, 48.48, 101.00, 11.00, 21.00, 51.00, 1.00, 251.00, 151.00};
        Dollar[] dollars = new Dollar[20];
        for (int i = 0; i < values.length; i++) {
            dollars[i] = new Dollar(values[i]);
        }
        SinglyLinkedList sll = new SinglyLinkedList();
        Stack stack = new Stack();
        Queue queue = new Queue();

        for (int i = 0; i < 7; i++) {
            sll.addCurrency(dollars[i], 0);
        }
//        sll.dosomething();
        System.out.println(sll.printList());
        sll.dosomething();
        System.out.println(sll.printList());
    }
}