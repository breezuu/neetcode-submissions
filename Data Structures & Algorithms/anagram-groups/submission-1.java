class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {     // for each String in the String array 'strs',
            char[] schar = s.toCharArray();
            Arrays.sort(schar);
            // String signature = schar.toString();
            String signature = new String(schar);       // Convert char[] array into String

            groups.computeIfAbsent(signature, (k) -> new ArrayList<>()).add(s); // If signature has NOT been seen before, create an ArrayList for it. Then, add the current String to it
                                                                                // If signature has been seen before, then just add the current String to it without creating a new ArrayList
        }

        List<List<String>> res = new ArrayList<>(groups.values());

        return res;
    }
}
