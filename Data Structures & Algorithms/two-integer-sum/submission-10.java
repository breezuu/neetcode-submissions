class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmIntToIndex = new HashMap<>();
        int n = nums.length;
        int leftPtr = 0;
        int rightPtr = n - 1;
        int[] sortedNums;
        int[] res = new int[2];

        for (int i = 0; i < n; i++) {
            if (hmIntToIndex.containsKey(target - nums[i])) {
                int complementIdx = hmIntToIndex.get(target - nums[i]);
                res = i < complementIdx ? new int[]{i, complementIdx} : new int[]{complementIdx, i};
            } else {
                hmIntToIndex.put(nums[i], i);
            }
        }

        return res;
    }
}
