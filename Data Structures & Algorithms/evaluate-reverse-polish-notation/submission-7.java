class Solution {
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<Integer> s = new Stack<Integer>();

        for (int i = 0; i < len; i++) {
            String c = tokens[i];

            if (c.equals("+")) {
                s.push(s.pop() + s.pop());
            } else if (c.equals("-")) {
                int m = s.pop();
                int n = s.pop();
                s.push(n - m);
            } else if (c.equals("*")) {
                s.push(s.pop() * s.pop());
            } else if (c.equals("/")) {
                int m = s.pop();
                int n = s.pop();
                s.push(n / m);
            } else {
                s.push(Integer.parseInt(c));
            }
        }

        return s.pop();
    }
}
