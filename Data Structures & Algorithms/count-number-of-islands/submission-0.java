class Solution {
    int[][] visited;
    int islands;

    public void bfs(char[][] grid, int maxR, int maxC, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        int[] dirR = new int[]{-1, 1, 0, 0};        // move in NSEW direction, respective changes for row value
        int[] dirC = new int[]{0, 0, 1, -1};        // move in NSEW direction, respective changes for column value

        visited[r][c] = 1;
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] currCoords = q.poll();
            int currR = currCoords[0];
            int currC = currCoords[1];

            for (int direction = 0; direction < 4; direction++) {
                int newR = currR + dirR[direction];
                int newC = currC + dirC[direction];

                if ((0 <= newR && newR < maxR) && (0 <= newC && newC < maxC)) {     // set boundaries in case value is outside of grid boundaries
                    if ((grid[newR][newC] != '0' && visited[newR][newC] != 1)) {
                        visited[newR][newC] = 1;
                        q.add(new int[]{newR, newC});
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int maxR = grid.length;
        int maxC = grid[0].length;
        islands = 0;
        visited = new int[maxR][maxC];

        for (int currR = 0; currR < maxR; currR++) {
            for (int currC = 0; currC < maxC; currC++) {
                if (grid[currR][currC] == '1') {
                    visited[currR][currC] = -1;
                } else if (grid[currR][currC] != '1') {
                    visited[currR][currC] = -1;
                }
            }
        }

        for (int currR = 0; currR < maxR; currR++) {
            for (int currC = 0; currC < maxC; currC++) {
                if ((grid[currR][currC] == '1') && (visited[currR][currC] == -1)) {      // need to visit, BUT not visited before
                    bfs(grid, maxR, maxC, currR, currC);
                    islands++;
                }
            }
        }
        
        return islands;
    }
}
