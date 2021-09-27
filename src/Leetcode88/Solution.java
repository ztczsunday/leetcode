package Leetcode88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        int index1 = m - 1;
        int index2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (nums1[index1] > nums2[index2]) {
                nums1[i] = nums1[index1];
                index1--;
                if (index1 < 0) {
                    System.arraycopy(nums2, 0, nums1, 0, index2 + 1);
                    return;
                }
            } else {
                nums1[i] = nums2[index2];
                index2--;
                if (index2 < 0) {
                    return;
                }
            }
        }
    }
}