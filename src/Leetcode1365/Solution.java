package Leetcode1365;

public class Solution {
    //暴力
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int count=0;
        int[] result=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            count=0;
            for (int j=0;j<nums.length;j++){
                if (nums[i]>nums[j]){
                    count++;
                }
            }
            result[i]=count;
        }
        return result;
    }

    public static int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] fre=new int[101];
        int[] result=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            fre[nums[i]]++;
        }
        for (int i=1;i<101;i++){
            fre[i]=fre[i]+fre[i-1];
        }
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                continue;
            }
            result[i]=fre[nums[i]-1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={8,1,2,2,3};
        smallerNumbersThanCurrent2(nums);
    }

}
