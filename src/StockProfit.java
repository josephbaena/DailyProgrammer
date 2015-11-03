//You are given the prices of a given stock for some days.
// You were allowed to own at most one stock at any time and you must not hold any stock at the end of that period.
// Find out the maximum profit that you could have.
public class StockProfit {
    static int[] prices = { 400, 402, 435, 398, 378, 400, 432, 432, 402 };

    public static void main(String[] args) {
        // start from right, move left, and find local maximum
        int sellIndex = -1;
        int sellPrice = -1;

        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > sellPrice) {
                sellIndex = i;
                sellPrice = prices[i];
            } else {
                break;
            }
        }

        if (sellIndex == 0) {
            System.out.println("No way to make money on this stock");
            return;
        }

        int buyIndex = -1;
        int maxProfit = -1;
        for (int i = sellIndex-1; i >= 0; i--) {
            if ((sellPrice - prices[i]) > maxProfit) {
                buyIndex = i;
                maxProfit = sellPrice - prices[i];
            }
        }

        if (sellIndex == -1) {
            System.out.println("No way to make money on this stock");
            return;
        }

        System.out.println("Buy on day " + buyIndex + " and sell on day " + sellIndex
            + " for profit of $" + maxProfit);

    }

}
