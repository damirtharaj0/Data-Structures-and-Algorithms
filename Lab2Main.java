/*
    Lab 2

    Daniel Amirtharaj

    This assignment derives two child classes from the abstract class Currency and demonstrates operations on the objects.
 */

import java.util.Scanner;

import ObjectOrientedDesign.*;

public class Lab2Main {
    public static void main(String[] args) throws Exception {

        Currency[] c = new Currency[2];
        try {
            c[0] = new Pound(0.0);
            c[1] = new Dollar(0.0);
        } catch (Exception e) {
            System.out.printf("Could not create object of specified currency. Got exception : %s", e.getMessage());
            System.exit(-1);
        }

        Scanner scan = new Scanner(System.in);

        while (true) {
            c[0].print();
            c[1].print();
            System.out.println();
            System.out.printf("Enter the operation (press q to quit) -> ");
            String line = scan.nextLine();
            if (line == null || line.length() == 0) {
                System.out.printf("Please type valid input %s\n", line);
                continue;
            }
            if (line.charAt(0) == 'q') {
                break;
            }
            String[] inp = line.split(" ");
            try {
                if (inp.length < 4) {
                    System.out.printf("Wrong input : %s\n", line);
                    continue;
                }
                double value = Double.parseDouble(inp[2]);
                Currency cur;
                if ("p".equals(inp[1])) {
                    cur = c[0];
                }
                else if ("d".equals(inp[1])) {
                    cur = c[1];
                }
                else {
                    System.out.println("Wrong input currency try again. p for pound and d for dollar");
                    continue;
                }

                Currency inptCur;
                if ("pound".equals(inp[3])) {
                    inptCur = new Pound(value);
                }
                else if ("dollar".equals(inp[3])) {
                    inptCur = new Dollar(value);
                } else {
                    System.out.println("Wrong input denomination try again. Should be either pound or dollar");
                    continue;
                }
                if ("a".equals(inp[0]))
                        cur.add(inptCur);
                else if ("s".equals(inp[0]))
                        cur.subtract(inptCur);
                else
                    System.out.println("Wrong input try again");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}