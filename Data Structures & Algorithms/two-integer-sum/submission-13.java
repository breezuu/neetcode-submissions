class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] intToIndex = new int[n][2];

        int ptr1 = 0;
        int ptr2 = nums.length - 1;

        int sum = -1;

        int val1 = -1;
        int val2 = -1;

        for (int i = 0; i < nums.length; i++) {
            intToIndex[i][0] = nums[i];         // Value
            intToIndex[i][1] = i;               // Original index number of value
        }

        Arrays.sort(intToIndex, Comparator.comparingInt(x -> x[0])); // Sort by the integer value

        while (ptr1 < ptr2) {
            sum = intToIndex[ptr1][0] + intToIndex[ptr2][0];

            if (sum == target) {
                val1 = Math.min(intToIndex[ptr1][1], intToIndex[ptr2][1]);
                val2 = Math.max(intToIndex[ptr1][1], intToIndex[ptr2][1]);
                break;
            }

            if (sum > target) {
                ptr2--;
            }

            else if (sum < target) {
                ptr1++;
            }
        }

        return new int[]{val1, val2};
    }
}
