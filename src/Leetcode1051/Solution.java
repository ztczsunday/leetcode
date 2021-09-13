package Leetcode1051;

public class Solution {
    public static int heightChecker(int[] heights) {
        int count=0;
        int[] fre=new int[101];
        for (int a:heights
             ) {
            fre[a]++;
        }
        for (int i=1;i<99;i++){
            fre[i]=fre[i]+fre[i-1];
        }
        for (int i=0;i<heights.length;i++){
            if (i<fre[heights[i]]&&i>=fre[heights[i]-1]){
                continue;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] heights={1,3,5,1,2,4};
        heightChecker(heights);
    }
}
