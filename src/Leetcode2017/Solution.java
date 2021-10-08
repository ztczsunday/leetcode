package Leetcode2017;

class Solution {
    public static long gridGame(int[][] grid) {
        int n=grid[0].length;
        int flag=0;
        grid[0][1]+=grid[0][0];
        for (int i=1;i<n-1;i++){
            grid[0][i]+=grid[0][i-1];
            if (grid[0][i]>grid[1][i-1]){
                grid[1][i]+=grid[0][i];
                flag=i;
            }else {
                grid[1][i]+=grid[1][i-1];
            }
        }
        System.out.println(flag);
        return 0;
    }

    public static void main(String[] args) {
        int[][] a={{1,2,4,5,6},{1,2,1,2,1}};
        gridGame(a);
    }
}