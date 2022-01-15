package dataStructure.Array;

/**
 * Problem Statement #
 * In this problem, you have to implement the int findSecondMaximum(int[] arr) method, which will traverse the whole array and return the second largest element present in the array.
 *     Assumption: Array should contain at least two unique elements.
 *
 * Method Prototype #
 * int findSecondMaximum(int[] arr)
 *
 * Output #
 * Second-largest element present in the array.
 *
 * Sample Input #
 * arr = {9,2,3,6}
 *
 * Sample Output #
 * 6
 */


// Solution #1: Traversing the Array Twice

/**
 * public class SecondMaximumValueInAnArray {
 *
 *     public static int findSecondMaximum(int[] arr) {
 *
 *         int max = Integer.MIN_VALUE;;
 *         int secondmax = Integer.MIN_VALUE;
 *
 *         // Find the maximum value in the array by comparing each index with max
 *         // If an element is greater than max then update max to be equal to it
 *         for (int i = 0; i < arr.length; i++) {
 *             if (arr[i] > max)
 *                 max = arr[i];
 *
 *         }//end of for-loop
 *
 *         // Find the second maximum value by comparing each index with secondmax
 *         // If an element is greater than secondmax and not equal to previously
 *         // calculated max, then update secondmax to be equal to that element.
 *         for (int i = 0; i < arr.length; i++) {
 *             if (arr[i] > secondmax && arr[i] < max)
 *                 secondmax = arr[i];
 *
 *         }//end of for-loop
 *
 *         return secondmax;
 *     }
 *
 *     public static String arrayToString(int arr[]){
 *         if (arr.length > 0){
 *             String result = "";
 *             for(int i = 0; i < arr.length; i++) {
 *                 result += arr[i] + " ";
 *             }
 *             return result;
 *         }
 *         else {
 *             return "Empty Array!";
 *         }
 *     }
 *
 *     public static void main(String args[]) {
 *
 *         int[] arr = {-2, -33, -10, -456};
 *
 *         System.out.println("Array: " + arrayToString(arr));
 *
 *         int secMax = findSecondMaximum(arr);
 *
 *         System.out.println("Second maximum: " + secMax);
 *
 *     }
 * }
 */

import java.util.Arrays;

/**
 * The time complexity of the solution is in O(n)O(n)O(n) since the array is traversed twice but in separate loops.
 * Which means O(n+n)⇒O(n)
 */

// Solution #2: Traversing the Array Only Once #
public class SecondMaximumValueInAnArray {

    public static int findSecondMaximum(int[] arr) {

        int max = Integer.MIN_VALUE;;
        int secondmax = Integer.MIN_VALUE;

        // Keep track of Maximum value, whenever the value at an array index is greater
        // than current Maximum value then make that max value 2nd max value and
        // make that index value maximum value
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondmax = max;
                max = arr[i];
            }
            else if (arr[i] > secondmax && arr[i] != max) {
                secondmax = arr[i];
            }
        }//end of for-loop

        return secondmax;
    } //end of findSecondMaximum

    public static void main(String args[]) {

        int[] arr = {-2, -33, -10, -456};

        System.out.println("Array: " + Arrays.toString(arr));

        int secMax = findSecondMaximum(arr);

        System.out.println("Second maximum: " + secMax);

    }
}

// This solution is in O(n) since the list is traversed once only.
