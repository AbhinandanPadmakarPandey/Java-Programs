package dataStructure.Array;

import java.util.Arrays;

/**
 * Problem Statement #
 * In this problem, you have to implement the int findFirstUnique(int[] arr) method that will look for a first unique integer, which appears only once in the whole array. The function returns -1 if no unique number is found.
 *
 * Method Prototype #
 * int findFirstUnique(int[] arr)
 *
 * Output #
 * The first unique element in the array.
 *
 * Sample Input #
 * arr = {9, 2, 3, 2, 6, 6}
 *
 * Sample Output #
 * 9
 */

// Returns first unique integer from array

public class FirstNonRepeatingIntegerInArray {

    public static int findFirstUnique(int[] arr) {
        //Inside Inner Loop Check Each index of outerLoop If it's repeated in array
        //If it's not repeated then return this as first unique Integer
        boolean isRepeated = false;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                if (arr[i] == arr[j] && i != j) {
                    isRepeated = true;
                    break;
                }
            } //end of InnerLoop

            if (isRepeated == false) {
                return arr[i];
            }
            else {
                isRepeated = false;
            }

        } //end of OuterLoop
        return - 1;
    }

    public static void main(String args[]) {

        int[] arr = {2, 54, 7, 2, 6, 54};

        System.out.println("Array: " + Arrays.toString(arr));

        int unique = findFirstUnique(arr);
        System.out.print("First Unique in an Array: " + unique);

    }
}