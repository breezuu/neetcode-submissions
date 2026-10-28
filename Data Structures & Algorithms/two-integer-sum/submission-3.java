class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmPrevInt = new HashMap<>();
        int n = nums.length;
        int leftPtr = 0;
        int rightPtr = n - 1;
        int[] sortedNums;
        int[] res = new int[2];

        for (int i = 0; i < n; i++) {
            if (hmPrevInt.containsKey(target - nums[i])) {
                int complementIdx = hmPrevInt.get(target - nums[i]);
                res = i < complementIdx ? new int[]{i, complementIdx} : new int[]{complementIdx, i};
            } else {
                hmPrevInt.put(nums[i], i);  // put the previous integers found as the program iterates the int array 'nums'.
            }
        }

        return res;
    }
}
