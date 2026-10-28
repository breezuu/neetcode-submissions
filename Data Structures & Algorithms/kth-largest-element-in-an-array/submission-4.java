class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder()); // max-heap

        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            pq.add(nums[i]);
        }

        int count = 0;
        while (!pq.isEmpty()) {
            count++;                // increment BEFORE checking the i-th element in the PQ

            if (count != k) {
                pq.poll();
            } else if (count == k) {
                ans = pq.peek();
                break;
            }
        }

        return ans;

    }
}