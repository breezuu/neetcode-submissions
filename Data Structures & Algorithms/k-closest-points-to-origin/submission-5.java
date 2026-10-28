class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>(
                                                                (a, b) -> Double.compare(b[2], a[2])
                                                                );     // should sort by the 3rd value in each array
        
        int n = points.length;
        int[][] ans = new int[k][2];    // declaring the int[] array as 'new int[n][2]' WILL result in k entries as having xCoord and yCoord, and (n - k) entries as [0, 0]!!!

        for (int i = 0; i < n; i++) {
            double xCoord = points[i][0];
            double yCoord = points[i][1];
            double eucliDist = Math.sqrt(
                                Math.pow((xCoord - 0), 2) 
                                + 
                                Math.pow((yCoord - 0), 2)
                            );
            pq.add(new double[]{xCoord, yCoord, eucliDist});
            while (pq.size() > k) {     // get rid of unnecessary elements
                pq.poll();
            }
        }

        int count = 0;
        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            int xCoord = (int) curr[0];
            int yCoord = (int) curr[1];

            ans[count] = new int[]{xCoord, yCoord}; 
            count++;
        }

        return ans;

        // return Arrays.copyOfRange(ans, 0, count);            // in case you accidentally initialized the answer array as 'new int[n][2]' instead of 'new int[k][2]'
    }
}
