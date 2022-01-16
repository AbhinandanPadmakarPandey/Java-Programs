package dataStructure.Array;

/**
 * Description #
 * Search for a given number in a sorted array, with unique elements, that has been rotated by some arbitrary number.
 * Return -1 if the number does not exist.
 *
 * Assume that the array does not contain duplicates.
 */

/**
 * Solution 1: recursive #
 *
 * Runtime complexity #
 * The runtime complexity of this solution is logarithmic, O(log n).
 *
 * Memory complexity #
 * The memory complexity of this solution is logarithmic, O(log n).
 *
 * The solution is essentially a binary search but with some modifications.
 * If we look at the array in the example closely, we notice that at least one half
 * of the array is always sorted. We can use this property to our advantage. If the number n
 * lies within the sorted half of the array, then our problem is a basic binary search.
 * Otherwise, discard the sorted half and keep examining the unsorted half.
 * Since we are partitioning the array in half at each step, this gives us O(log n) runtime complexity.
 */

/**
 * public class SearchRotatedArray {
 *     public static int binarySearch(int[] arr, int start, int end, int key) {
 *         // assuming all the keys are unique.
 *
 *         if (start > end) {
 *             return -1;
 *         }
 *
 *         int mid = start + (end - start) / 2;
 *
 *         if (arr[mid] == key) {
 *             return mid;
 *         }
 *
 *         if (arr[start] <= arr[mid] && key <= arr[mid] && key >= arr[start]) {
 *             return binarySearch(arr, start, mid - 1, key);
 *         }
 *
 *         else if (arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end]) {
 *             return binarySearch(arr, mid + 1, end, key);
 *         }
 *
 *         else if (arr[end] <= arr[mid]) {
 *             return binarySearch(arr, mid + 1, end, key);
 *         }
 *
 *         else if (arr[start] >= arr[mid]) {
 *             return binarySearch(arr, start, mid - 1, key);
 *         }
 *
 *         return -1;
 *     }
 *
 *     static int binarySearchRotated(int[] arr, int key) {
 *         return binarySearch(arr, 0, arr.length - 1, key);
 *     }
 *
 *     public static void main(String []args){
 *         int[] v1 = {6, 7, 1, 2, 3, 4, 5};
 *         System.out.println("Key(3) found at: " + binarySearchRotated(v1, 3));
 *         System.out.println("Key(6) found at: " + binarySearchRotated(v1, 6));
 *
 *         int[] v2 = {4, 5, 6, 1, 2, 3};
 *         System.out.println("Key(3) found at: " + binarySearchRotated(v2, 3));
 *         System.out.println("Key(6) found at: " + binarySearchRotated(v2, 6));
 *     }
 * }
 */

/**
 * Solution 2: iterative #
 * This is an alternate solution.
 *
 * Runtime complexity #
 * The runtime complexity of this solution is logarithmic, O(log n).
 *
 * Memory complexity #
 * The memory complexity of this solution is constant, O(1).
 */


public class SearchRotatedArray {
    static int binarySearchRotated(int[] arr, int key) {
        int start = 0;
        int mid = 0;
        int end = arr.length - 1;

        if (start > end)
            return -1;

        while (start <= end){
            mid = start + (end - start) / 2;

            if (arr[mid] == key)
                return mid;
            if (arr[start] <= arr[mid] && key <= arr[mid] && key >= arr[start])
                end = mid - 1;
            else if (arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end])
                start = mid + 1;
            else if (arr[start] <= arr[mid] && arr[mid] <= arr[end] && key > arr[end])
                start = mid + 1;
            else if (arr[end] <= arr[mid])
                start = mid + 1;
            else if (arr[start] >= arr[mid])
                end = mid - 1;
            else
                return -1;
        }
        return -1;
    }

    public static void main(String []args){
        int[] v1 = {6, 7, 1, 2, 3, 4, 5};
        System.out.println("Key(3) found at: "+binarySearchRotated(v1, 3));
        System.out.println("Key(6) found at: "+binarySearchRotated(v1, 6));
        int[] v2 = {4, 5, 6, 1, 2, 3};
        System.out.println("Key(3) found at: "+binarySearchRotated(v2, 3));
        System.out.println("Key(6) found at: "+binarySearchRotated(v2, 6));
    }
}
