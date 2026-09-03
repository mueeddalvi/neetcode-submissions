class Solution {
    int l, w;
    public boolean exist(char[][] board, String word) {
        int length = word.length();
        w = board[0].length;
        l = board.length;

        for (int i = 0; i < l; i++)
            for (int j = 0; j < w; j++)
                if (dfs(board, word, i, j, 0))
                    return true;
        return false;
    }

    boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (i == word.length())
            return true;
        if (r < 0 || c < 0 || r >= l || c >= w || board[r][c] != word.charAt(i)
            || board[r][c] == '#')
            return false;

        board[r][c] = '#';

        boolean res = dfs(board, word, r + 1, c, i + 1) || dfs(board, word, r - 1, c, i + 1)
            || dfs(board, word, r, c + 1, i + 1) || dfs(board, word, r, c - 1, i + 1);

        board[r][c] = word.charAt(i);

        return res;
    }
}
