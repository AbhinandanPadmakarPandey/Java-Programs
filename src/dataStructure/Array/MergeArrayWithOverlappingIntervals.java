package dataStructure.Array;

/**
 * Description #
 *
 * You are given an array (list) of interval pairs as input where each interval has a start and end timestamp.
 * The input array is sorted by starting timestamps. You are required to merge overlapping intervals and
 * return a new output array.
 *
 * Consider the input array below. Intervals (1, 5), (3, 7), (4, 6), (6, 8) are overlapping
 * so they should be merged to one big interval (1, 8). Similarly, intervals (10, 12) and (12, 15)
 * are also overlapping and should be merged to (10, 15).
 */

/**
 * Hints #
 *     - Try the linear scan.
 *     - Use the pair class defined in the exercise to handle pairs of time stamps.
 */

import java.util.ArrayList;

/**
 * Solution #
 *
 * Runtime complexity #
 * The runtime complexity of this solution is linear, O(n).
 *
 * Memory complexity #
 * The memory complexity of this solution is linear, O(n).
 *
 *     - This is the worst case when there are non-overlapping elements in the array.
 *
 * This problem can be solved in a simple linear scan algorithm. We know that input is sorted by starting timestamps.
 * Here is the approach we are following:
 *     - List of input intervals is given, and we’ll keep merged intervals in the output list.
 *     - For each interval in the input list:
 *         - If the input interval is overlapping with the last interval in output list then we’ll merge these two intervals and update the last interval of output list with merged interval.
 *         - Otherwise, we’ll add an input interval to the output list.
 */

class Pair{
    public int first;
    public int second;

    public Pair(int x, int y){
        this.first = x;
        this.second = y;
    }
}

public class MergeArrayWithOverlappingIntervals{
    static ArrayList<Pair> mergeIntervals(ArrayList<Pair> v) {

        if(v == null || v.size() == 0) {
            return null;
        }

        ArrayList<Pair> result = new ArrayList<Pair>();

        result.add(new Pair(v.get(0).first, v.get(0).second));

        for(int i = 1 ; i < v.size(); i++) {
            int x1 = v.get(i).first;
            int y1 = v.get(i).second;
            int x2 = result.get(result.size() - 1).first;
            int y2 = result.get(result.size() - 1).second;

            if(y2 >= x1) {
                result.get(result.size() - 1).second = Math.max(y1, y2);
            } else {
                result.add(new Pair(x1, y1));
            }
        }

        return result;
    }
    public static void main(String[] args) {
        ArrayList<Pair> v = new ArrayList<Pair>();

        v.add(new Pair(1, 5));
        v.add(new Pair(3, 7));
        v.add(new Pair(4, 6));
        v.add(new Pair(6, 8));
        v.add(new Pair(10, 12));
        v.add(new Pair(11, 15));

        ArrayList<Pair> result = mergeIntervals(v);

        for(int i=0; i<result.size(); i++){
            System.out.print(String.format("[%d, %d] ", result.get(i).first, result.get(i).second));
        }
    }
}
