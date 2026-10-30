class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < n; i++) {
            if (hm.containsKey(target - nums[i])) {
                int complementIdx = hm.get(target - nums[i]);
                res = i < complementIdx ? new int[]{i, complementIdx} : new int[]{complementIdx, i};
            } else {
                hm.put(nums[i], i); // {value, index of value}
            }
        }

        return res;
    }
}
