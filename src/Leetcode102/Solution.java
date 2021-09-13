package Leetcode102;

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root==null){
            return result;
        }
        Queue<nodeLevel> treeNodes=new LinkedList<>();
        treeNodes.add(new nodeLevel(root,0));
        nodeLevel treeNode;
        while (!treeNodes.isEmpty()){
            treeNode=treeNodes.poll();
            if (treeNode.node.left!=null){
                treeNodes.add(new nodeLevel(treeNode.node.left,treeNode.level+1));
            }
            if (treeNode.node.right!=null){
                treeNodes.add(new nodeLevel(treeNode.node.right,treeNode.level+1));
            }
            if (result.size()<treeNode.level+1){
                List<Integer> list=new ArrayList<>();
                list.add(treeNode.node.val);
                result.add(list);
            }else {
                result.get(treeNode.level).add(treeNode.node.val);
            }
        }
        return result;
    }
}

class nodeLevel{
    public TreeNode node;
    public int level;
    nodeLevel(TreeNode node,int level){
        this.level=level;
        this.node=node;
    }
}