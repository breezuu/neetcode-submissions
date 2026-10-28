class Solution {
    public boolean isPalindrome(String s) {
        String filtered = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = filtered.length();
        int leftPtr = 0;
        int rightPtr = n - 1;

        for (int i = 0; i < n; i++) {
            // System.out.println(filtered.charAt(leftPtr + i));
            // System.out.println(filtered.charAt(rightPtr - i));

            if (filtered.charAt(leftPtr + i) != filtered.charAt(rightPtr - i)) {
                return false;
            }
        }

        return true;
    }
}
