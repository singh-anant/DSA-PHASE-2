class Solution {
    int countRev (String s)
    {
         {
            if (s.length() % 2 != 0) {
            return -1;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        int unbalancedCount = stack.size();
        int openCount = 0;
        int closeCount = 0;
        while (!stack.isEmpty()) {
            if (stack.pop() == '{') {
                openCount++;
            } else {
                closeCount++;
            }
        }
        int reversals = unbalancedCount / 2 + openCount % 2;
        return reversals;
}
    }