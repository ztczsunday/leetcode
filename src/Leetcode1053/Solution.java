package Leetcode1053;

class Solution {
    public static int[] prevPermOpt1(int[] arr) {
        int size=arr.length;
        int val=0,index=0;
        boolean flag=false;
        for (int i=size-2;i>=0;i--){
            if (arr[i]>arr[i+1])
            {
                for (int j=i+1;j<size;j++){
                    if (arr[j]>val&&arr[j]<arr[i])
                    {
                        flag=true;
                        val=arr[j];
                        index=j;
                    }
                }
                if (flag){
                    arr[index]=arr[i];
                    arr[i]=val;
                    return arr;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a={3,2,1};
        prevPermOpt1(a);
    }
}