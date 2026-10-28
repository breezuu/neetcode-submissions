class Solution {
    public int lengthOfLongestSubstring(String s) {
        int leftPtr = 0;
        int rightPtr = 0;
        int n = s.length();
        HashSet<Character> hs = new HashSet<>();
        char[] sCharArr = s.toCharArray();
        int best = 0;

        if (s == null) {
            return 0;
        }
        
        for (rightPtr = 0; rightPtr < n; rightPtr++) {
            char c = sCharArr[rightPtr];
            while (hs.contains(c)) {
                hs.remove(sCharArr[leftPtr]);
                leftPtr++;
            }
            hs.add(c);
            best = Math.max(best, rightPtr - leftPtr + 1);
        }

        return best;
    }
}
