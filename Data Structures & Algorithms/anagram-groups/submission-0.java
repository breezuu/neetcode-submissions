class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            char[] strInChars = s.toCharArray();
            Arrays.sort(strInChars);
            String signature = new String(strInChars);  // anagram signature

            groups.computeIfAbsent(signature, (k) -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }
}
