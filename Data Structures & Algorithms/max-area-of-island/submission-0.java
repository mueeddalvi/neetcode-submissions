class Solution {
    int res=0;
    public int maxAreaOfIsland(int[][] grid) {

        int row=grid.length;
        int col=grid[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    res=Math.max(dfs(i,j,grid),res);
                }
            }
        }

        return res;
        
    }

    public int dfs(int r, int c, int [][] grid){
        if(r>=grid.length || c>=grid[0].length || r<0 || c<0 || grid[r][c]==0)
            return 0;
        grid[r][c]=0;
        return 1+dfs(r+1,c,grid)+
        dfs(r-1,c,grid)+
        dfs(r,c+1,grid)+
        dfs(r,c-1,grid);
    }
}