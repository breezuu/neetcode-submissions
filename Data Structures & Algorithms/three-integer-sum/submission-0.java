class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);                                  // sort array, to keep duplicates together

        for (int i = 0; i < n; i++) {
            int target = -(nums[i]);                        // target number will be the complement of the first number chosen
            int left = i + 1;
            int right = n - 1;

            if ((i > 0) && (nums[i] == nums[i - 1])) {      // only check from the 2nd iteration onwards (thus the 'i > 0') condition,
                continue;                                   // when 'i == 0', nums[i] don't have previous element before it, so it is not a duplicate
            }

            while (left < right) {
                sum = nums[left] + nums[right];

                if (sum == target) {
                    List<Integer> il = new ArrayList<>(List.of(nums[i], nums[left], nums[right]));
                    res.add(il);

                    while ((left < right) && (nums[left + 1] == nums[left])) {          // skip duplicate values
                        left++;
                    }
                    
                    while ((left < right) && (nums[right - 1] == nums[right])) {        // skip duplicate values
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < target) {      // find a larger sum 
                    left++;
                } else if (sum > target) {      // find a smaller sum
                    right--;
                }
            }
        }

        return res;
    }
}