package Leetcode64;

class Solution {
    public int minPathSum(int[][] grid) {
        int maxRow=grid.length,maxCol= grid[0].length;
        for (int i=1;i<maxRow;i++){
            grid[i][0]+=grid[i-1][0];
        }
        for (int i=1;i<maxCol;i++){
            grid[0][i]+=grid[0][i-1];
        }
        for (int row=1;row<maxRow;row++){
            for (int col=1;col<maxCol;col++){
                grid[row][col]+=min(grid[row-1][col],grid[row][col-1]);
            }
        }
        return grid[maxRow-1][maxCol-1];
    }
    private int min(int a,int b){
        return a>b ? b:a;
    }
}