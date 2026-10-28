class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            hs.add(nums[i]);
        }

        if (hs.size() != nums.length) {
            return true;
        }

        return false;
    }
}