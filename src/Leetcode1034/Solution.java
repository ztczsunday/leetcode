package Leetcode1034;

class Solution {
    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        if(grid==null){
            return null;
        }
        int maxRow=grid.length;
        int maxCol=grid[0].length;
        colorRun(grid,row,col,grid[row][col],maxRow,maxCol);
        for (int i=0;i<maxRow;i++){
            for (int j=0;j<maxCol;j++){
                if (grid[i][j]<0){
                    grid[i][j]=color;
                }
            }
        }
        return grid;
    }

    private static void colorRun(int[][] grid, int row, int col, int oldColor, int maxRow, int maxCol) {
        if (row>=maxRow||col>=maxCol||row<0||col<0||grid[row][col]!=oldColor){
            return;
        }
        grid[row][col]=-oldColor;
        colorRun(grid,row+1,col,oldColor,maxRow,maxCol);
        colorRun(grid,row-1,col,oldColor,maxRow,maxCol);
        colorRun(grid,row,col+1,oldColor,maxRow,maxCol);
        colorRun(grid,row,col-1,oldColor,maxRow,maxCol);
        if (row<maxRow-1
                &&row>0
                &&col<maxCol-1
                &&col>0
                &&(grid[row-1][col]==oldColor||grid[row-1][col]==-oldColor)
                &&(grid[row+1][col]==oldColor||grid[row+1][col]==-oldColor)
                &&(grid[row][col-1]==oldColor||grid[row][col-1]==-oldColor)
                &&(grid[row][col+1]==oldColor||grid[row][col+1]==-oldColor)){
            grid[row][col]=oldColor;
        }
    }

    public static void main(String[] args) {
        int[][] a={{2,1,3,2,1,1,2},{1,2,3,1,2,1,2},{1,2,1,2,2,2,2},{2,1,2,2,2,2,2},{2,3,3,3,2,1,2}};
        colorBorder(a,4,4,3);
    }
}