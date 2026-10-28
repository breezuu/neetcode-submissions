class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int leftPtr = 0;
        int rightPtr = n - 1;
        int[] res = new int[2];
        int[][] intToIndex = new int[n][2];

        // Create integer to original index number mapping
        for (int i = 0; i < n; i++) {
            intToIndex[i][0] = nums[i]; // original integer
            intToIndex[i][1] = i;       // index number
        }

        // Custom comparator to allow for sorting of integers, WHILE storing their original index numbers
        Arrays.sort(intToIndex, Comparator.comparingInt(x -> x[0]));    // for each int[] array with integer + index number, sort it by integer in ascending order

        while (leftPtr < rightPtr) {
            int currLeft = intToIndex[leftPtr][0];
            int leftIdx = intToIndex[leftPtr][1];
            int currRight = intToIndex[rightPtr][0];
            int rightIdx = intToIndex[rightPtr][1];

            if (currLeft + currRight > target) {
                rightPtr--;
            } else if (currLeft + currRight < target) {
                leftPtr++;
            } else if (currLeft + currRight == target) {
                res = new int[]{Math.min(leftIdx, rightIdx),
                                Math.max(leftIdx, rightIdx)};
                return res;
            }
        }

        return new int[0];
    }
}
