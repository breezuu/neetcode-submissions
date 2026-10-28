class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();

        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();

        // if (s.length() == t.length()) {
        //     for (int i = 0; i < s.length(); i++) {
        //         hm1.put(sCharArr[i], hm1.getOrDefault(sCharArr[i], 0) + 1);
        //         hm2.put(tCharArr[i], hm2.getOrDefault(tCharArr[i], 0) + 1);
        //     }
        // }
        
        Arrays.sort(sCharArr);
        Arrays.sort(tCharArr);
        return Arrays.equals(sCharArr, tCharArr);
    }
}
