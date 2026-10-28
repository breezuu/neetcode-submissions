class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put(')', '(');
        hm.put('}', '{');
        hm.put(']', '['); 

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (hm.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == hm.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);      // push into stack to wait for closing brackets
            }
        }

        // if stack is empty, it means that all the open brackets are matched to closing brackets successfully
        return stack.isEmpty();
    }
}
