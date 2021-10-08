package Leetcode46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int a : nums
        ) {
            output.add(a);
        }
        backtrack(size, output, result, 0);
        return result;
    }

    public void backtrack(int size, List<Integer> output, List<List<Integer>> result, int first) {
        if (first == size) {
            result.add((new ArrayList<>(output)));
        }
        for (int i = first; i < size; i++) {
            Collections.swap(output, i, first);
            backtrack(size, output, result, first + 1);
            Collections.swap(output, i, first);
        }
    }
}