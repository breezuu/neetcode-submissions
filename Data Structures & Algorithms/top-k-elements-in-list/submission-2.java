class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer>[] buckets = new ArrayList[n+1];      // Initialise with size 'n+1' as index 0 is NOT used
        int[] res = new int[k];

        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {   // Iterate through every entry in HashMap
            int val = e.getKey();
            int freq = e.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<Integer>();       // Create ArrayList for the specific frequency's bucket if NOT created yet
            }

            buckets[freq].add(val);                             // Add a value into the ArrayList
        }

        int idx = 0;

        for (int i = n; i >= 1 && idx < k; i--) {               // Iterate all frequencies starting from the MOST FREQUENT values, then work ur way towards less frequent numbers
            if (buckets[i] != null) {                           // if bucket being looked at is NOT empty,
                for (Integer currVal : buckets[i]) {        
                    if (idx == k) {                             // break when 'k' elements obtained
                        break;
                    } 

                    res[idx] = currVal;
                    idx++;
                }
            }
        }

        return res;
    }
}
