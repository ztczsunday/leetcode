package Leetcode538;


class Solution {
    int count=0;
    public TreeNode convertBST(TreeNode root) {
        if (root==null){
            return null;
        }
        convertBST(root.right);
        root.val+=count;
        convertBST(root.left);
        return root;
    }
}