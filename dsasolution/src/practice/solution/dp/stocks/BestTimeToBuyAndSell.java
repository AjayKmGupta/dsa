package practice.solution.dp.stocks;

public class BestTimeToBuyAndSell {

    public static void main(String[] args) {

        int[] prices = {7, 1, 3, 5, 6, 4};

        int min = prices[0];
        int maxProfit = 0;
        int n = prices.length;

        for(int i = 0; i < n; i++) {
            int profit = prices[i] - min;
            maxProfit = Math.max(profit, maxProfit);
            min = Math.min(min, prices[i]);
        }

        System.out.println(maxProfit);

    }

}
