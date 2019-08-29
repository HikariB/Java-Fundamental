package com.hbLib.JianZhiOffer;

public class MirrorTree {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        process(root);
    }

    private TreeNode process(TreeNode root) {
        if (root == null)
            return null;
        TreeNode leftRoot = null;
        TreeNode rightRoot = null;
        leftRoot = (root.left == null) ? null : process(root.left);
        rightRoot = (root.right == null) ? null : process(root.right);
        root.left = rightRoot;
        root.right = leftRoot;
        return root;
    }
}
