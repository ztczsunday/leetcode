package Leetcode116;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        Node node;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                node = nodes.poll();
                if (i < size - 1) {
                    node.next = nodes.peek();
                }
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }
        return root;
    }
}