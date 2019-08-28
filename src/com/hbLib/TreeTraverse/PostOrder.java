package com.hbLib.TreeTraverse;

import java.util.Stack;

public class PostOrder {
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void postOrderNonRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode lastNode = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if (node.right != null && lastNode != node.right) {
                    node = node.right;
                } else {
                    System.out.print(node.val + " ");
                    stack.pop();
                    lastNode = node;
                    node = null;
                }
            }
        }
    }


}
