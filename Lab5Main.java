/*
    Lab 5

    Daniel Amirtharaj

    This assignment demonstrates a hash table with the inert and search functionality.
 */

import java.util.Scanner;

import HashTable.*;
import ObjectOrientedDesign.*;

public class Lab5Main {
    public static void main(String[] args) throws Exception {
        final int hashTableSize = 29;
        HashTable hashTable = new HashTable(hashTableSize);
        double[] values = new double[] { 57.12, 23.44, 87.43, 68.99, 111.22, 44.55, 77.77, 18.36, 543.21, 20.21, 345.67,
                36.18, 48.48, 101.00, 11.00, 21.00, 51.00, 1.00, 251.00, 151.00 };
        int numCollisions = 0;
        for (int i = 0; i < values.length; i++) {
            numCollisions += hashTable.insert(new Dollar(values[i]));
        }
        System.out.println("Data Items Loaded = " + hashTable.numItems());
        System.out.printf("Load Factor = %f\n", hashTable.loadFactor());
        System.out.println("Number of Collisions = " + numCollisions);

        Scanner scan = new Scanner(System.in);
        String input = "";
        do {
            System.out.print(
                    "Enter the dollar amount (double) you want to search for (ex. 1.12) or enter 'quit' to exit the program --> ");
            input = scan.nextLine();
            if (!"quit".equals(input.toLowerCase())) {
                try {
                    Currency dol = new Dollar(Double.parseDouble(input));
                    double searchRes = hashTable.search(dol);
                    if (searchRes != -1) {
                        dol.print();
                        System.out.printf("was found at index %d\n", hashTable.search(dol));
                    } else {
                        System.out.println("Invalid Data");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid Data");
                }
            }
        } while (!"quit".equals(input.toLowerCase()));
        scan.close();
    }
}