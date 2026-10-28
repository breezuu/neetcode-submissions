class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;        // set to 1 to avoid 'division by zero' issue
        int mid = 0;

        int maxBananas = 0;
        for (int i : piles) {
            maxBananas = Math.max(maxBananas, i);
        }

        int high = maxBananas;
        int largestK = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;       // value of k, #bananas eaten per hour
            long totalHrs = 0;

            for (int i = 0; i < n; i++) {
                totalHrs += Math.ceil(piles[i] / (double) mid);
            }

            if (totalHrs <= h) {
                largestK = mid;
                high = mid - 1;
            } else if (totalHrs > h) {
                low = mid + 1;
            }
        }

        return largestK;
    }
}
