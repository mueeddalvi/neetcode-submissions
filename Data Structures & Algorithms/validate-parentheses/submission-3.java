class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if (len <= 1)
            return false;
        char charZero = s.charAt(0);

        if (charZero == ')' || charZero == '}' || charZero == ']')
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if (!stack.isEmpty()) {
                char pop = stack.pop();
                if ((c == ')' && pop != '('))
                    return false;
                else if (c == '}' && pop != '{')
                    return false;
                else if (c == ']' && pop != '[')
                    return false;
                else
                    continue;
            }
            else 
                return false;
        }

        if(!stack.isEmpty())
            return false;

        return true;
    }
}
