package Leetcode1504;

class Solution {
    public static int numSubmat(int[][] mat) {
        if (mat.length==0){
            return 0;
        }
        int left=0,tempCol=0,result=0;
        int maxRow=mat.length;
        int maxCol=mat[0].length;
        int[][] matLeft=new int[maxRow][maxCol];
        for (int row=0;row<maxRow;row++){
            left=0;
            for (int col=0;col<maxCol;col++){
                if (mat[row][col]==1){
                    left++;
                }else {
                    left=0;
                }
                matLeft[row][col]=left;
            }
        }
        for (int row=0;row<maxRow;row++){
            for (int col=0;col<maxCol;col++){
                tempCol=matLeft[row][col];
                for (int tempRow=row;tempRow>=0;tempRow--){
                    if (matLeft[tempRow][col]==0){
                        break;
                    }
                    if (matLeft[tempRow][col]<tempCol){
                        tempCol=matLeft[tempRow][col];
                    }
                    result+=tempCol;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a={{1,0,1},{1,1,0},{1,1,0}};
        numSubmat(a);
    }
}