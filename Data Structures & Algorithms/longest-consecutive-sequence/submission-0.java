class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int best = 1;
        int res = 1;

        HashSet<Integer> hs = new HashSet<>();      // gets rid of duplicate integers

        for (int i = 0; i < n; i++) {
            hs.add(nums[i]);
        }

        if (hs.isEmpty()) {
            return 0;
        }

        for (Integer i : hs) {
            if (hs.contains(i - 1)) {       // if current value is in the middle of a run, skip it.
                                            // let the first value in the run count ALL of the values in its run.
                continue;
            }

            // vvvvvvvv Any integer executing this 'while' loop == start of a run vvvvvvvv
            int len = 1;
            while (hs.contains(i + len)) {   // if curr. value = start of run, count itself + ALL other consecutive elements in the run
                best++;
                res = Math.max(res, best);
                len++;
            }

            best = 1;
        }

        return res;
    }
}