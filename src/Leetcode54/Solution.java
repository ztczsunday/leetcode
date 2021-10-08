package Leetcode54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int maxRow = matrix.length;
        if (maxRow == 0) {
            return null;
        }
        int maxCol = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int left = 0, right = maxCol - 1, top = 0, bottom = maxRow - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                result.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    result.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    result.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
}