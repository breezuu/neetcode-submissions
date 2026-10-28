class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer>[] buckets = new ArrayList[n+1];  // {frequency count -> respective array of numbers that have that frequency}
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] topK = new int[k];

        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            int val = e.getKey();
            int freq = e.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<Integer>();
            }
            buckets[freq].add(val);    // store the integers in ArrayList<Integer>, indexed by its frequency count 
        }

        int idx = 0;
        for (int i = n; i >= 1 && idx < k; i--) {      // count from biggest n (most frequent) to 1
            if (buckets[i] != null) {
                for (Integer currInt : buckets[i]) {
                    if (idx == k) {
                        break;
                    }
                    topK[idx] = currInt;
                    idx++;
                }
            }
        }

        return topK;
    }
}
