/*
    Lab 1

    Daniel Amirtharaj

    this assignment searches through an array and determines if all the numbers in the array are prime or not using iteration and recursion.
 */

package Recursion;

import java.util.Scanner;

public class PrimeArray {

    public static void main(String[] args) {
        final int SORT_MAX_SIZE = 16;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter size of array");
        int arrSze = scan.nextInt();
        if(arrSze > SORT_MAX_SIZE) {
            arrSze = SORT_MAX_SIZE;
        }
        scan.nextLine();

        int[] arr = new int[arrSze];
        System.out.println("Enter numbers in the array separated by space");
        for (int i = 0; i < arrSze; i++) {
            arr[i] = scan.nextInt();
        }
        if (isArrayPrimeIter(arr, arrSze)) {
            System.out.println("\nPrime Array using iteration\n");
        } else {
            System.out.println("\nNot a Prime Array using iteration\n");
        }

        if(isArrayPrimeRecur(arr, arrSze)) {
            System.out.println("\nPrime Array using recursion\n");
        } else {
            System.out.println("\nNot a Prime Array using recursion\n");
        }
    }

    /*
    isArrayPrimeIter( arr, inptSze )

        This method checks if every single element of an array is prime using iteration.

        Pre: arr - array of integers
             inptSze - size of the array
        Post: returns true if all elements are prime or returns false if at least one element is false
        Return: true or false

        loop ( i < inptSze )
            if ( arr[i] equals 0 or 1 )
                return false
            end if
            loop ( j < arr[i]/j )
                if ( arr[i] is divisible by j )
                    return false
                end if
            end loop
        end loop
        return true
    end isArrayPrimeIter
    */
    public static boolean isArrayPrimeIter(int[] arr, int inptSze) {
        System.out.println("Entering IsArrayPrimeIter");
        for(int i = 0; i < inptSze; i++){
            if(arr[i] == 1 || arr[i] == 0){
                System.out.println("Leaving IsArrayPrimeIter");
                return false;
            }
            for(int j = 2; j <= arr[i]/j; j++){
                if(arr[i] % j == 0){
                    System.out.println("Leaving IsArrayPrimeIter");
                    return false;
                }
            }
        }
        System.out.println("Leaving IsArrayPrimeIter");
        return true;
    }

    /*
    isArrayPrimeRecur( arr, inptSze )

        This method calls isPrimeRecur for every element in the given array using recursion. It returns false if
        isPrimeRecur returns false and true if inptSze is 0

        Pre: arr - array of integers
             inptSze - size of the array
        Post: returns false if isPrimeRecur returns false and returns true if inptSze is 0
        Return: true or false

        if ( inptSze equals 0 )
            return true
        end if
        if ( return value of isPrimeRecur is true )
            return true
        end if
        return false
    end isArrayPrimeRecur
    */
    public static boolean isArrayPrimeRecur(int[] arr, int inptSze) {
        System.out.println("Entering IsArrayPrimeRecur");
        if(inptSze == 0){
            System.out.println("Leaving IsArrayPrimeRecur");
            return true;
        }
        if(isPrimeRecur(arr[inptSze - 1], 2)){
            boolean retVal = isArrayPrimeRecur(arr, inptSze - 1);
            System.out.println("Leaving IsArrayPrimeRecur");
            return retVal;
        }
        System.out.println("Leaving IsArrayPrimeRecur");
        return false;
    }

    /*
    isArrayPrime( num, i )

        This method checks if a number is prime using recursion. It returns true if the number is prime and false if
        the number is not prime

        Pre: num - number to check
             i - the divisor of num to check if num is prime
        Post: returns true if the number is prime and returns false if the number is not prime
        Return: true or false

        if ( num is less than or equal to 1 )
            return false
        end if
        if ( num is equal to 2 )
            return true
        end if
        if ( i is greater than num/i )
            return true
        end if
        if ( remainder of num/i is 0 )
            return false
        end if
        return value of isPrimeRecur
    end isArrayPrime
    */
    private static boolean isPrimeRecur(int num, int i) {
        System.out.println("Entering isPrimeRecur");
        if(num <= 1) {
            System.out.println("Leaving isPrimeRecur");
            return false;
        }
        if(num == 2) {
            System.out.println("Leaving isPrimeRecur");
            return true;
        }
        if (i > num/i) {
            System.out.println("Leaving isPrimeRecur");
            return true;
        }
        if(num % i == 0) {
            System.out.println("Leaving isPrimeRecur");
            return false;
        }
        boolean retVal =  isPrimeRecur(num, i + 1);
        System.out.println("Leaving isPrimeRecur");
        return retVal;
    }
}
