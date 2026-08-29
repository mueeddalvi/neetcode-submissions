class Solution {
    List<String> res;
    int len;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        int open = 0, closed = 0;
        len = n;

        compute(new StringBuilder(), 0, 0);
        return res;
    }

    public void compute(StringBuilder curr, int open, int closed) {
        if (closed > open) {
            return;
        } else if (curr.length() == 2 * len) {
            res.add(curr.toString());
            return;
        }
        if (open < len) {
            curr.append("(");
            compute(curr, open + 1, closed);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (closed < open) {
            curr.append(")");
            compute(curr, open, closed + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
