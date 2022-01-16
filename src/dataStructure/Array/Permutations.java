package dataStructure.Array;

/**
 * Problem Statement#
 * Given a set of distinct numbers, find all of its permutations.
 *
 * Permutation is defined as the re-arranging of the elements of the set.
 * For example, {1, 2, 3} has the following six permutations:
 *     {1, 2, 3}
 *     {1, 3, 2}
 *     {2, 1, 3}
 *     {2, 3, 1}
 *     {3, 1, 2}
 *     {3, 2, 1}
 *
 * If a set has ‘n’ distinct elements it will have n!n!n! permutations.
 *
 * Example 1:
 * Input: [1,3,5]
 * Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution#
 *
 * This problem follows the Subsets pattern and we can follow a similar Breadth First Search (BFS) approach.
 * However, unlike Subsets, every permutation must contain all the numbers.
 *
 * Let’s take the example-1 mentioned above to generate all the permutations. Following a BFS approach,
 * we will consider one number at a time:
 *     - If the given set is empty then we have only an empty permutation set: []
 *     - Let’s add the first element (1), the permutations will be: [1]
 *     - Let’s add the second element (3), the permutations will be: [3,1], [1,3]
 *     - Let’s add the third element (5), the permutations will be: [5,3,1], [3,5,1], [3,1,5], [5,1,3], [1,5,3], [1,3,5]
 *
 * Let’s analyze the permutations in the 3rd and 4th step. How can we generate permutations in the 4th step from
 * the permutations of the 3rd step?
 *
 * If we look closely, we will realize that when we add a new number (5), we take each permutation of the previous
 * step and insert the new number in every position to generate the new permutations. For example,
 * inserting ‘5’ in different positions of [3,1] will give us the following permutations:
 *     - Inserting ‘5’ before ‘3’: [5,3,1]
 *     - Inserting ‘5’ between ‘3’ and ‘1’: [3,5,1]
 *     - Inserting ‘5’ after ‘1’: [3,1,5]
 */

/**
 * public class Permutations {
 *     public static List<List<Integer>> findPermutations(int[] nums) {
 *         List<List<Integer>> result = new ArrayList<>();
 *         Queue<List<Integer>> permutations = new LinkedList<>();
 *         permutations.add(new ArrayList<>());
 *         for (int currentNumber : nums) {
 *             // we will take all existing permutations and add the current number to create new permutations
 *             int n = permutations.size();
 *             for (int i = 0; i < n; i++) {
 *                 List<Integer> oldPermutation = permutations.poll();
 *                 // create a new permutation by adding the current number at every position
 *                 for (int j = 0; j <= oldPermutation.size(); j++) {
 *                     List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
 *                     newPermutation.add(j, currentNumber);
 *                     if (newPermutation.size() == nums.length)
 *                         result.add(newPermutation);
 *                     else
 *                         permutations.add(newPermutation);
 *                 }
 *             }
 *         }
 *         return result;
 *     }
 *
 *     public static void main(String[] args) {
 *         List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
 *         System.out.print("Here are all the permutations: " + result);
 *     }
 * }
 */

/* Recursive Solution */

public class Permutations {

    public static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutationsRecursive(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private static void generatePermutationsRecursive(int[] nums, int index, List<Integer> currentPermutation,
                                                      List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(currentPermutation);
        } else {
            // create a new permutation by adding the current number at every position
            for (int i = 0; i <= currentPermutation.size(); i++) {
                List<Integer> newPermutation = new ArrayList<Integer>(currentPermutation);
                newPermutation.add(i, nums[index]);
                generatePermutationsRecursive(nums, index + 1, newPermutation, result);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = generatePermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}

