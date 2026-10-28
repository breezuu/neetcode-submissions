class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // find how many rows u passed: mid // n (Math.floor(m / n)), tells u how many rows u have passed
        // find what column u shld be at: mid % n, tells u which index/column to be at that row

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = (m * n) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = (int) Math.floor(mid / n);
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else if (matrix[row][col] > target) {
                high = mid - 1;
            }
        }

        return false;
    }
}
