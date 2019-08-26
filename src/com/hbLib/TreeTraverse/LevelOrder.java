package com.hbLib.TreeTraverse;

import java.util.Deque;
import java.util.LinkedList;

public class LevelOrder {
    public static void levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return;
        TreeNode node = root;
        queue.addLast(node);
        while (!queue.isEmpty()) {
            node = queue.pollFirst();
            System.out.print(node.val + " ");
            if (node.left != null)
                queue.addLast(node.left);
            if (node.right != null)
                queue.addLast(node.right);
        }
    }
}
