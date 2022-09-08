/*
    Lab 4

    Daniel Amirtharaj

    This assignment demonstrates a Binary Search Tree and their methods
 */

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

import BinarySearchTree.*;
import ObjectOrientedDesign.*;

public class Lab4Main {

    public static void main(String[] args) throws Exception {



        double[] values = new double[] {57.12, 23.44, 87.43, 68.99, 111.22, 44.55, 77.77, 18.36, 543.21, 20.21, 345.67, 36.18, 48.48, 101.00, 11.00, 21.00, 51.00, 1.00, 251.00, 151.00};
        Currency[] dollars = new Currency[20];
        BST tree = new BST();
        for (int i = 0; i < values.length; i++) {
            dollars[i] = new Dollar(values[i]);
            tree.insert(dollars[i]);
        }

        PrintStream stream = new PrintStream(new File("output.txt"));
        PrintStream console = System.out;


        System.out.println("Breadth First Traversal:");
        tree.breadthFirst();
        System.out.println("\n");
        System.out.println("In Order Traversal:");
        tree.inOrder(tree.getRoot());
        System.out.println("\n");
        System.out.println("Pre Order Traversal:");
        tree.preOrder(tree.getRoot());
        System.out.println("\n");
        System.out.println("Post Order Traversal:");
        tree.postOrder(tree.getRoot());

        System.setOut(stream);
        System.out.println("Breadth First Traversal:");
        tree.breadthFirst();
        System.out.println("\n");
        System.out.println("In Order Traversal:");
        tree.inOrder(tree.getRoot());
        System.out.println("\n");
        System.out.println("Pre Order Traversal:");
        tree.preOrder(tree.getRoot());
        System.out.println("\n");
        System.out.println("Post Order Traversal:");
        tree.postOrder(tree.getRoot());
        System.setOut(console);


        Scanner scan = new Scanner(System.in);
        String input = "";
        String operation = "";
        double num = 0;
        System.out.println("\n");
        while (!"-1".equals(input)) {
            System.out.print("Type 'A' to add, 'S' to search, 'D' to delete followed by a space and the data value or press 'P' to print tree in all traversal methods (ex. A 2.54) type -1 to quit --> ");
            input = scan.nextLine();
            try {
                String[] arrayoperation = input.split(" ");
                operation = arrayoperation[0];
                if (arrayoperation.length > 1) {
                    num = Double.parseDouble(arrayoperation[1]);
                }
            } catch (Exception e) {
                System.out.println("invalid input");
            }
            switch (operation.toLowerCase()) {
                case "a" -> {
                    if (num > 0)
                    tree.insert(new Dollar(num));
                    System.out.printf("Added the value %.2f to tree\n", num);
                }
                case "s" -> {
                    BSTNode val = tree.search(new Dollar(num));
                    if (val != null) {
                        System.out.print("found node '");
                        val.getData().print();
                        System.out.println("' in tree");
                    } else {
                        System.out.println("could not find node" + num + "in tree");
                    }
                }
                case "d" -> {
                    if (tree.delete(new Dollar(num)) == null) {
                        System.out.printf("Could not delete %.2f from tree", num);
                    }
                    System.out.printf("Deleted %.2f to tree\n", num);
                }
                case "p" -> {
                    System.setOut(stream);

                    System.out.println("\nBreadth First Traversal:");
                    tree.breadthFirst();
                    System.out.println("\n");
                    System.out.println("In Order Traversal:");
                    tree.inOrder(tree.getRoot());
                    System.out.println("\n");
                    System.out.println("Pre Order Traversal:");
                    tree.preOrder(tree.getRoot());
                    System.out.println("\n");
                    System.out.println("Post Order Traversal:");
                    tree.postOrder(tree.getRoot());

                    System.setOut(console);

                    System.out.println("Breadth First Traversal:");
                    tree.breadthFirst();
                    System.out.println("\n");
                    System.out.println("In Order Traversal:");
                    tree.inOrder(tree.getRoot());
                    System.out.println("\n");
                    System.out.println("Pre Order Traversal:");
                    tree.preOrder(tree.getRoot());
                    System.out.println("\n");
                    System.out.println("Post Order Traversal:");
                    tree.postOrder(tree.getRoot());
                }
            }
        }
        stream.close();
    }
}
