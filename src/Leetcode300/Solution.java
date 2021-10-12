package Leetcode300;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int size=nums.length;
        int[] maxLength=new int[size];
        int max=0;
        for (int i=0;i<size;i++){
            maxLength[i]=1;
            for (int j=0;j<i;j++){
                if (nums[j]<nums[i]){
                    maxLength[i]=Math.max(maxLength[i],maxLength[j]+1);
                }
            }
            max=Math.max(max,maxLength[i]);
        }
        return max;
    }
    public int lengthOfLIS2(int[] nums) {
        int size=nums.length;
        int[] maxLengthArray=new int[size];
        maxLengthArray[0]=nums[0];
        int len=1;
        for (int a:nums
             ) {
            if (a>maxLengthArray[len-1]){
                maxLengthArray[len]=a;
                len++;
            }else if (a<maxLengthArray[len-1]){
                int loc=search(maxLengthArray,a,len);
                maxLengthArray[loc+1]=Math.min(a,maxLengthArray[loc+1]);
            }
        }
        return len;
    }
    private int search(int[] nums, int target,int len) {
        int left=0,right= len -1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]<target&&nums[mid+1]>=target){
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