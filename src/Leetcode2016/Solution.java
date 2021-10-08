package Leetcode2016;

class Solution {
    public int maximumDifference(int[] nums) {
        int lk = 0, rk = 1, size = nums.length;
        if (size == 0) {
            return -1;
        } else if (size == 1) {
            return 0;
        }
        int result = -1;
        while (rk < size) {
            if (nums[rk] - nums[lk] > result && nums[rk] - nums[lk] > 0) {
                result = nums[rk] - nums[lk];
            } else if (nums[rk] - nums[lk] < 0) {
                lk = rk;
            }
            rk++;
        }
        return result;
    }

}