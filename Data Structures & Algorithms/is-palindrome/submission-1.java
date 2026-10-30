class Solution {
    public boolean isPalindrome(String s) {
        boolean res = true;

        String cleaned = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        char[] sCharArr = cleaned.toCharArray();
        int n = cleaned.length();

        int leftPtr = 0;
        int rightPtr = n - 1;

        for (int i = 0; i < n; i++) {
            if (leftPtr <= rightPtr) {
                if (sCharArr[leftPtr] != sCharArr[rightPtr]) {
                    System.out.println(sCharArr[leftPtr]);
                    System.out.println(sCharArr[rightPtr]);
                    res = false;
                }
            }
            leftPtr++;
            rightPtr--;
        }

        return res;
    }
}
