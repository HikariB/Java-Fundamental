package com.hbLib.TreeTraverse;

import java.util.Stack;

public class PreOrder {
    public static void preOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }


    public static void preOrderNonRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                System.out.print(node.val+" ");
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }


}
