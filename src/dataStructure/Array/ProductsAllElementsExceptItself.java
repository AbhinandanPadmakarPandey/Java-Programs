package dataStructure.Array;

// Array of Products of All Elements Except Itself

/**
 * Problem Statement#
 * In this problem, you have to implement the int[] findProduct(int[] arr) method which will modify arr in such a way that in the output, each index i will contain the product of all elements present in arr except the element stored on that index i.
 *
 * Method Prototype#
 * int[] findProduct(int[] arr)
 *
 * Input#
 * An array of integers. This array can be of any (valid) size and elements can be repeated.
 *
 * Output#
 * An array with products stored at each position.
 *
 * Sample Input#
 * arr = {1,2,3,4}
 *
 * Sample Output#
 * arr = {24,12,8,6}
 */

public class ProductsAllElementsExceptItself {

    public static int[] findProduct(int arr[])
    {
        int n = arr.length;
        int i, temp = 1;

        // Allocation of result array
        int result[] = new int[n];

        // Product of elements on left side excluding arr[i]
        for (i = 0; i < n; i++)
        {
            result[i] = temp;
            temp *= arr[i];
        }

        // Initializing temp to 1 for product on right side
        temp = 1;

        // Product of elements on right side excluding arr[i]
        for (i = n - 1; i >= 0; i--)
        {
            result[i] *= temp;
            temp *= arr[i];
        }

        return result;
    }
    public static String arrayToString(int arr[]){
        if (arr.length > 0){
            String result = "";
            for(int i = 0; i < arr.length; i++) {
                result += arr[i] + " ";
            }
            return result;
        }
        else {
            return "Empty Array!";
        }
    }

    public static void main(String args[]) {

        int[] arr = {-1, 2, -3, 4, -5};

        System.out.println("Array before product: " + arrayToString(arr));

        int[] prodArray = findProduct(arr);

        System.out.println("Array after product: " + arrayToString(prodArray));
    }
}
