class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int max = -1;
        int area = -1;

        while (left < right) {
            // Calculate area of water
            int minHeight = Math.min(height[left], height[right]);
            area = minHeight * (right - left);

            // Compare best area seen VS current area computed
            if (area > max) {
                max = area;
            }     

            // Since the lower wall of the 2 CANNOT give any better area, move the left pointer inward in hopes of finding a taller wall
            if (minHeight == height[left]) {
                left++;
            } else {
                right--;
            }       
        }

        return max;
    }
}