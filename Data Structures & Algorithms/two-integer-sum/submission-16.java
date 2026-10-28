class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[2];

        HashMap<Integer, Integer> hmIntToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
           if (hmIntToIndex.containsKey(target - nums[i])) {
                int complementIdx = hmIntToIndex.get(target - nums[i]);
                res = i < complementIdx ? new int[]{i, complementIdx} : new int[]{complementIdx, i};
           }

           else {
            hmIntToIndex.put(nums[i], i);
           }
        }

        return res;
    }
}
