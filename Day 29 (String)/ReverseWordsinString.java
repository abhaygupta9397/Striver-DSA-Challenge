class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        Stack<String> stk = new Stack<>();

        for (String word : s.split(" ")) {
            if (word.length() != 0) {
                stk.push(word);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!stk.isEmpty()) {
            ans.append(stk.pop());

            if (!stk.isEmpty()) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}