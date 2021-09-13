package Leetcode958;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        ArrayList<Node> list = new ArrayList<>();
        list.add(new Node(root, 1));
        int i = 0;
        while (i < list.size()) {
            Node node = list.get(i);
            i++;
            if (node.treeNode != null) {
                list.add(new Node(node.treeNode.left, node.index * 2));
                list.add(new Node(node.treeNode.right, node.index * 2 + 1));
            }
        }
        if (i == list.get(i - 1).index) {
            return true;
        }
        return false;
    }

    public boolean isCompleteTree2(TreeNode root){
        boolean flag=false;
        Queue<TreeNode> treeNodes=new LinkedList<>();
        TreeNode treeNode;
        treeNodes.add(root);
        while (!treeNodes.isEmpty()){
            treeNode=treeNodes.peek();
            if (flag&&(treeNode.right!=null||treeNode.left!=null)){
                return false;
            }
            else if (treeNode.left!=null&&treeNode.right!=null){
                treeNodes.add(treeNode.left);
                treeNodes.add(treeNode.right);
            }
            else if (treeNode.right!=null&&treeNode.left==null){
                return false;
            }
            else if(treeNode.right!=null){
                flag=!flag;
            }
        }
        return true;
    }
}

class Node {
    TreeNode treeNode;
    int index;

    Node(TreeNode treeNode, int index) {
        this.treeNode = treeNode;
        this.index = index;
    }
}
