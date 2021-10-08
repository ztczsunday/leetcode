package Leetcode200;

class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length==0){
            return 0;
        }
        int m=grid.length,n=grid[0].length;
        int result=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]=='1'){
                    colorRun(grid,i,j,m,n);
                    result++;
                }
            }
        }
        return result;
    }
    private void colorRun(char[][] grid, int row, int col, int maxRow, int maxCol) {
        if (row>=maxRow||col>=maxCol||row<0||col<0||grid[row][col]=='#'||grid[row][col]=='0'){
            return;
        }
        grid[row][col]='#';
        colorRun(grid,row+1,col,maxRow,maxCol);
        colorRun(grid,row-1,col,maxRow,maxCol);
        colorRun(grid,row,col+1,maxRow,maxCol);
        colorRun(grid,row,col-1,maxRow,maxCol);
    }

}