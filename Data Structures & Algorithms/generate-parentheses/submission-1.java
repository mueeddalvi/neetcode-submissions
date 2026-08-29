class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();

        solve(n, n, "");

        return res;
    }

    public void solve(int o, int c, String curr) {
        if (o == 0 && c == 0) {
            res.add(curr);
            return;
        }
        if (o == c) {
            solve(o - 1, c, curr + "(");
        } else if (o == 0 && c > 0) {
            solve(o, c - 1, curr + ")");
        } else {
            solve(o, c - 1, curr + ")");
            solve(o - 1, c, curr + "(");
        }
    }
}
