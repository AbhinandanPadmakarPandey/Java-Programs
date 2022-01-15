package dataStructure.Array;

/**
 * Problem Statement#
 * In this problem, you have to implement the int[] findSum(int[] arr, int n) method,
 * which will take a number n, and an array arr as input and returns an array of two integers that add up to n in an array.
 * You are required to return only one such pair. If no such pair is found then simply return the array.
 *
 * Method Prototype#
 * int[] findSum(int[] arr, int n)
 *
 * Output#
 * An array with two integers a and b that add up to a given number or the original array in case a pair is not found.
 *
 * Sample Input#
 * arr = {1, 21, 3, 14, 5, 60, 7, 6}
 * value = 27
 *
 * Sample Output#
 * arr = {21, 6} or {6, 21}
 */

/** Solution #1: Brute Force
 *
 * public class TwoNoSumN {
 *     public static int[] findSum(int[] arr, int n)
 *     {
 *         int[] result = new int[2]; // to store the pair of values.
 *
 *         for (int i = 0; i < arr.length; i++) { //traverse arr
 *             for (int j = i + 1; j < arr.length; j++) { //traverse arr again
 *                 if (arr[i] + arr[j] == n) { // find where sum is equal to n
 *                     result[0] = arr[i];
 *                     result[1] = arr[j];
 *                     return result; // return the pair of numbers
 *                 }
 *             }
 *         }
 *         return arr;
 *     }
 *
 *     public static void main(String args[]) {
 *
 *         int n = 9;
 *         int[] arr1 = {2, 4, 5, 7, 8};
 *         if(arr1.length > 0){
 *             int[] arr2 = findSum(arr1, n);
 *             int num1 = arr2[0];
 *             int num2 = arr2[1];
 *
 *             if((num1 + num2) != n)
 *                 System.out.println("Not Found");
 *             else {
 *                 System.out.println("Number 1 = " + num1);
 *                 System.out.println("Number 2 = " + num2);
 *                 System.out.println("Sum = " +  (n) );
 *
 *             }
 *         } else {
 *             System.out.println("Input Array is Empty!");
 *         }
 *     }
 * }
 */

// Solution #2: Sorting the array

public class TwoNoSumN{

    //Helper Function to sort given Array (Quick Sort)
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is <= to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    //Return 2 elements of arr that sum to the given value
    public static int[] findSum(int[] arr, int n) {
        //Helper sort function that uses the Quicksort Algorithm
        sort(arr, 0, arr.length - 1);   //Sort the array in Ascending Order

        int Pointer1 = 0;    //Pointer 1 -> At Start
        int Pointer2 = arr.length - 1;   //Pointer 2 -> At End

        int[] result = new int[2];
        int sum = 0;

        while (Pointer1 != Pointer2) {

            sum = arr[Pointer1] + arr[Pointer2];  //Calulate Sum of Pointer 1 and 2

            if (sum < n)
                Pointer1++;  //if sum is less than given value => Move Pointer 1 to Right
            else if (sum > n)
                Pointer2--;
            else {
                result[0] = arr[Pointer1];
                result[1] = arr[Pointer2];
                return result; // containing 2 number
            }
        }
        return arr;
    }

    public static void main(String args[]) {

        int n = 9;
        int[] arr1 = {1,2,3,4,5};
        if(arr1.length > 0){
            int[] arr2 = findSum(arr1, n);
            int num1 = arr2[0];
            int num2 = arr2[1];

            if((num1 + num2) != n)
                System.out.println("Not Found");
            else {
                System.out.println("Number 1 = " + num1);
                System.out.println("Number 2 = " + num2);
                System.out.println("Sum = " +  (n) );

            }
        } else {
            System.out.println("Input Array is Empty!");
        }
    }
}
