class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int best = 0;
        int n = prices.length;

        while (r < n) {
            if (prices[r] < prices[l]) {
                l = r;
            }

            if (prices[r] > prices[l]) {  // selling price > buy price
                best = Math.max(best, prices[r] - prices[l]);
            }

            r++;
        }

        return best;
    }
}
