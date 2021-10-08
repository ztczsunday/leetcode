package Leetcode33;

class Solution {
    public int search(int[] nums, int target) {
        int size = nums.length;
        if (size == 0) {
            return -1;
        }
        if (size == 1) {
            return target == nums[0] ? 0 : -1;
        }
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[0]) {
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[size - 1] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}