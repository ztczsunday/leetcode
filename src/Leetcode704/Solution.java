package Leetcode704;

class Solution {
    public int search(int[] nums, int target) {
        int size=nums.length;
        if(size==0){
            return -1;
        }
        int left=0,right=size-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
}