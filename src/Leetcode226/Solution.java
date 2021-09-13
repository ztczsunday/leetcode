package Leetcode226;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode rightTree=root.right;
        root.right=invertTree(root.left);
        root.left=invertTree(rightTree);
        return root;
    }
}