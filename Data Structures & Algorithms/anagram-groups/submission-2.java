class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            char[] sCharArr = s.toCharArray();
            Arrays.sort(sCharArr);
            String signature = new String(sCharArr);
            
            groups.computeIfAbsent(signature, (k) -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }
}
