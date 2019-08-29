package com.hbLib.TreeTraverse;

public class TestTraverse {

    //      _4_
    //   _2_   _6_
    //  1   3 5   7
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node2.left = node1;
        node2.right = node3;
        root.left = node2;
        root.right = node6;
        node6.left = node5;
        node6.right = node7;

        System.out.println("PreOrder: ");
        PreOrder.preOrder(root);
        System.out.println();
        System.out.println("PreOrderNonRecursive: ");
        PreOrder.preOrderNonRecursive(root);
        System.out.println();

        System.out.println("InOrder: ");
        InOrder.inOrder(root);
        System.out.println();
        System.out.println("InOrderNonRecursive: ");
        InOrder.inOrderNonRecursive(root);
        System.out.println();

        System.out.println("PostOrder: ");
        PostOrder.postOrder(root);
        System.out.println();
        System.out.println("PostOrderNonRecursive: ");
        PostOrder.postOrderNonRecursive(root);
        System.out.println();

        System.out.println("LevelOrder: ");
        LevelOrder.levelOrder(root);

    }

}
