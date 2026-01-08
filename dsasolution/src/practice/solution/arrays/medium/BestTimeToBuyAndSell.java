package practice.solution.arrays.medium;


public class BestTimeToBuyAndSell {

    public static void main(String[] args) {

        int[] arr = {10, 7, 5, 8, 11, 9};

        //Profit should be maximum

        //brute force method
        int profit = buyAndSellStock(arr);
        System.out.println("Profit: " + profit);

        //optimised method
        profit = buyAndSellStockOptimum(arr);
        System.out.println("Profit: " + profit);

    }

    private static int buyAndSellStockOptimum(int[] arr) {

        int min = arr[0];
        int profit = 0;

        for(int i = 1; i < arr.length; i++) {
            int currentProfit = arr[i] - min;
            profit = Math.max(profit, currentProfit);
            min = Math.min(min, arr[i]);
        }

        return profit;
    }

    private static int buyAndSellStock(int[] arr) {

        int maxProffit = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                int profit = arr[j] - arr[i];
                maxProffit = Math.max(maxProffit, profit);
            }
        }
        return maxProffit;
    }

}
