package dataStructure.Array;

// Merge Two Sorted Array

/**
 * Problem Statement #
 * In this problem, given two sorted arrays, you have to implement the int[] mergeArrays(int[] arr1, int[] arr2) method, which returns an array consisting of all elements of both arrays in a sorted way.
 *
 * Method Prototype #
 * int[] mergeArrays(int[] arr1, int[] arr2)
 *
 * Here arr1 and arr2 are sorted already.
 *
 * Output #
 * Merged array consisting of all elements of both arrays in a sorted way.
 *
 * Sample Input #
 * arr1 = {1, 3, 4, 5}
 * arr2 = {2, 6, 7, 8}
 *
 * Sample Output #
 * arr = {1, 2, 3, 4, 5, 6, 7, 8}
 */

public class MergeSortedArray {

    // Merge arr1 and arr2 into resultantArray

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int s1 = arr1.length;
        int s2 = arr2.length;
        int[] resultantArray = new int[s1+s2];
        int i = 0, j = 0, k = 0;

        // Traverse both array
        while (i < s1 && j < s2) {
            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            if (arr1[i] < arr2[j])
                resultantArray[k++] = arr1[i++];
            else
                resultantArray[k++] = arr2[j++];
        }

        // Store remaining elements of first array
        while (i < s1)
            resultantArray[k++] = arr1[i++];

        // Store remaining elements of second array
        while (j < s2)
            resultantArray[k++] = arr2[j++];

        return resultantArray;
    }

    public static void main(String[] args) {

        int[] arr1 = {1,12,14,17,23}; // creating a sorted array called arr1
        int[] arr2 = {11,19,27};  // creating a sorted array called arr2

        int[] resultantArray = mergeArrays(arr1, arr2); // calling mergeArrays

        System.out.print("Arrays after merging: ");
        for(int i = 0; i < arr1.length + arr2.length; i++) {
            System.out.print(resultantArray[i] + " ");
        }
    }
}
