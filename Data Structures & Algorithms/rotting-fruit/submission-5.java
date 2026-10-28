class Solution {
    public int orangesRotting(int[][] g) {
        int maxR = g.length;
        int maxC = g[0].length;
        // int[][] visited = new int[maxR][maxC];
        int[][] dist = new int[maxR][maxC];
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < maxR; r++) {
            for (int c = 0; c < maxC; c++) {
                if (g[r][c] == 2) {
                    dist[r][c] = 0;
                    q.offer(new int[]{r, c});
                } else {
                    dist[r][c] = -1;
                }
            }
        }

        int[] dirR = new int[]{-1, 1, 0, 0};
        int[] dirC = new int[]{0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] currCoords = q.poll();
            int currR = currCoords[0];
            int currC = currCoords[1];
            
            for (int direction = 0; direction < 4; direction++) {
                int newR = currR + dirR[direction];
                int newC = currC + dirC[direction];
                if ((0 <= newR && newR < maxR) && (0 <= newC && newC < maxC)) {
                    if ((g[newR][newC] != 0) && (dist[newR][newC] == -1)) {       // a walkable cell, but NOT visited yet
                        dist[newR][newC] = dist[currR][currC] + 1;
                        q.add(new int[]{newR, newC});
                    }
                }
            }
        }

        int max = 0;
        for (int r = 0; r < maxR; r++) {
            for (int c = 0; c < maxC; c++) {
                max = Math.max(max, dist[r][c]);

                if ((g[r][c] != 0) && (dist[r][c] == -1)) {   // that means a fresh fruit has NOT been touched before
                    return -1;
                }
            }
        }

        return max;
    }
}
