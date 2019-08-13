package com.hbLib.JianZhiOffer;

import java.util.Arrays;

public class BinaryTree {

    //eg

    //pre : 1 2 4 7 3 5 6 8
    //in : 4 7 2 1 5 3 8 6


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre == null || in == null || pre.length != in.length)
            try {
                throw new Exception("输入参数不匹配");
            } catch (Exception e) {
                e.printStackTrace();
            }
        if (pre.length == 0)
            return null;

        // root
        TreeNode root = new TreeNode(pre[0]);

        //根据前序的根在中序遍历中确定左右子树
        int div = -1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                div = i;
                break;
            }
        }

        //new pre and new in
        if (div > 0) {
            int[] newPre = Arrays.copyOfRange(pre, 1, div + 1);
            int[] newIn = Arrays.copyOf(in, div);
            root.left = reConstructBinaryTree(newPre, newIn);
        } else {
            root.left = null;
        }

        if (div != pre.length - 1) {
            int[] newPre = Arrays.copyOfRange(pre, div + 1, pre.length);
            int[] newIn = Arrays.copyOfRange(in, div + 1, in.length);
            root.right = reConstructBinaryTree(newPre, newIn);
        } else {
            root.right = null;
        }

        return root;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        try {
            bt.reConstructBinaryTree(pre, in);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
