class KthLargest {
    PriorityQueue<Integer> pq;
    int kLargest;
    int n;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        n = nums.length;
        kLargest = k;
        for (int i : nums) {
            pq.add(i);
        }
    }
    
    public int add(int val) {
        pq.add(val);

        while (pq.size() > kLargest) {
            pq.poll();
        }

        return pq.peek();
    }
}
