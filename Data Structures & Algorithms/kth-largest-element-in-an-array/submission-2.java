class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            pq.add(nums[i]);
        }

        while (!pq.isEmpty()) {
            if (pq.size() == k) {
                ans = pq.peek();
                break;
            } else {
                pq.poll();  // get rid of elements until u reach PQ of size k. The NEXT .poll() will return the kth largest element
            }
        }

        return ans;

    }
}