class Solution {
    List<List<String>> res;
    char[][] board;
    public List<List<String>> solveNQueens(int n) {

        board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) board[i][j] = '.';


        res = new ArrayList<>();

        solve(0, n);

        return res;
    }

    void solve(int r, int n) {
        if (r == board.length) {
            List<String> copy=new ArrayList<>();
            for(char [] row: board)
                copy.add(new String(row));
            res.add(copy);
            return;
        }

        for (int c = 0; c < board.length; c++) {
            if (!isSafe(r,c,n)) {
                continue;
            }
            board[r][c] = 'Q';
            solve(r + 1, n);
            board[r][c] = '.';
        }
    }

    boolean isSafe(int r, int c, int n) {
        // horizontal
        for (int i = 0; i < n; i++) {
            if (board[i][c] == 'Q')
                return false;
        }

        // vertical
        for (int i = 0; i < n; i++) {
            if (board[r][i] == 'Q')
                return false;
        }

        // left diagonal
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        // right diagonal
        for (int i = r, j = c; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }
}
