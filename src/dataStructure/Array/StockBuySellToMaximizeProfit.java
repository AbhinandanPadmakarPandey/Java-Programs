package dataStructure.Array;

/**
 * Description#
 *
 * Given a list of daily stock prices (integers for simplicity),
 * return the buy and sell prices for making the maximum profit.
 *
 * We need to maximize the single buy/sell profit. If we can’t make any profit,
 * we’ll try to minimize the loss. For the below examples, buy and sell prices for making
 * a maximum profit are highlighted.
 */

/**
 * Hints#
 *     - Use Kadane’s algorithm.
 */

/**
 * Solution #
 *
 * Runtime complexity #
 * The runtime complexity of this solution is linear, O(n).
 *
 * Memory complexity #
 * The memory complexity of this algorithm is constant, O(1).
 *
 * The values in the array represent the cost of a stock each day. As we can buy and sell the stock only once,
 * we need to find the best buy and sell prices for which our profit is maximized
 * (or loss is minimized) over a given span of time.
 *
 * A naive solution, with runtime complexity of O(n^2), is to find the maximum gain between each element and
 * its succeeding elements.
 *
 * There is a tricky linear solution to this problem that requires maintaining current_buy_price
 * (which is the smallest number seen so far), current_profit, and global_profit as we iterate through
 * the entire array of stock prices. At each iteration, we will compare the current_profit with the
 * global_profit and update the global_profit accordingly.
 */

/**
 * The basic algorithm is as follows:
 ***
 * current profit = INT_MIN
 * current buy = stock_prices[0]
 * global sell = stock_prices[1]
 * global profit = global sell - current buy
 *
 * for i = 1 to stock_prices.length:
 *   current profit = stock_prices[i] - current buy
 *   if current profit is greater than global profit
 *     then update global profit to current profit and update global sell to stock_prices[i]
 *   if stock_prices[i] is less than current buy
 *     then update current buy to stock_prices[i]
 *
 * return global profit and global sell
 ***
 */

class Tuple<X, Y> {
    public X x;
    public Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
}

public class StockBuySellToMaximizeProfit{
    public static Tuple findBuySellStockPrices(int[] array) {
        if(array == null || array.length < 2) {
            return null;
        }

        int current_buy = array[0];
        int global_sell = array[1];
        int global_profit = global_sell - current_buy;

        int current_profit = Integer.MIN_VALUE;

        for(int i=1; i<array.length; i++) {
            current_profit = array[i] - current_buy;

            if(current_profit > global_profit) {
                global_profit = current_profit;
                global_sell = array[i];
            }

            if(current_buy > array[i]) {
                current_buy = array[i];
            }
        }

        Tuple<Integer, Integer> result =
                new Tuple<Integer, Integer>(global_sell - global_profit, global_sell);

        return result;
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 3, 2, 1, 2, 5};
        Tuple result = null;
        result = findBuySellStockPrices(array);
        System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.x, result.y));

        int[] array2 = {8, 6, 5, 4, 3, 2, 1};
        result = findBuySellStockPrices(array2);
        System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.x, result.y));

    }
}
