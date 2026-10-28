class Solution {
    static ArrayList<ArrayList<Integer>> AL;
    static ArrayList<Integer> visited;
    static boolean backEdgeExists;

    public void dfs(Integer u) {
        visited.set(u, 1);          // partially visited

        for (Integer neighbour : AL.get(u)) {
            if (visited.get(neighbour) == 0) {             // if this neighbour has NOT been visited before, proceed DFS as per normal
               dfs(neighbour); 
            } else if (visited.get(neighbour) == 1) {      // if this neighbour HAS been visited before, means there is a back edge
                backEdgeExists = true;
            }
        }

        visited.set(u, 2);          // once ALL neighbours have been visited completely, set the 'visited' status for this integer to '2' (FULLY VISITED)
    }

    public boolean canFinish(int n, int[][] EL) {
        AL = new ArrayList<>();
        visited = new ArrayList<>(Collections.nCopies(n, 0));       // set ALL integer's 'visited' status to '0' by default

        for (int i = 0; i < n; i++) {
            AL.add(new ArrayList<>());
        }

        // Populate the adjacency list to find out each course's neighbours
        for (int[] pair : EL) {
            int a = pair[0];
            int b = pair[1];
            AL.get(b).add(a);       // take course b THEN can take course a
        }

        backEdgeExists = false;

        for (int src = 0; src < n; src++) {
            dfs(src);
        }

        return !backEdgeExists;
    }
}
