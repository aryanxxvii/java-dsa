package Medium;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4}; // Output: 5
        int[] arr2 = {7,6,4,3,1};
        System.out.println(optimal(arr));
        System.out.println(optimal(arr2));


    }

    public static int optimal(int[] arr) {
        // For each day, think of when you would have bought the stock to sell on that day
        // If selling on Day-X, would have bought on Day-Y where Day-Y is minimum price on left

        int max_profit = 0;
        int current_min_price = arr[0];
        for (int i : arr) {
            current_min_price = Math.min(current_min_price, i);
            max_profit = Math.max(max_profit, (i - current_min_price));
        }

        return max_profit;
    }



}
