package com.hbLib;

import com.sun.javafx.scene.text.HitInfo;

import javax.swing.text.html.InlineView;
import java.util.ArrayList;
import java.util.Stack;

public class NowcoderPractice {

    public static void main(String[] args) {
        int[][] a = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean f = Find(1, a);
        System.out.println(f);
        Stack<Integer> stack1 = new Stack<Integer>();

    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
//        if(pRoot.left )
//        if (pRoot.left != null && pRoot.right != null)
//            if (isSymmetrical(pRoot.left) && isSymmetrical(pRoot.right))
//                return true;
        return false;
    }

    //中序遍历
    /*
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)
            return null;
        if (pNode.right == null)
        {

            TreeLinkNode par = pNode.next;
            while (par != null){
                if (par.left == pNode)
                    return pNode.next;
                pNode = par;
                par = par.next;
            }
            return par;
        }
        else
        {
            pNode = pNode.right;
            while (pNode.left !=null)
                pNode = pNode.left;
        }
        return pNode;
    }
    */

    //
    public int NumberOf1(int n) {
        //31 -- 5
        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }


    public int RectCover(int target) {
        if (target <= 2)
            return target;
        int pre = 1;
        int in = 2;
        int res = pre + in;
        while ((--target) > 2) {
            pre = in;
            in = res;
            res = pre + in;
        }
        return res;


    }

    public int JumpFloorII(int target) {
        if (target < 0)
            return -1;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] * 2;
        }
        return dp[target];

    }

    public int JumpFloor(int target) {
        if (target < 0)
            return -1;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];

    }

    public int Fibonacci(int n) {
        if (n <= 1)
            return n;

        int pre = 0;
        int in = 1;
        int res = pre + in;
        while ((--n) > 1) {
            pre = in;
            in = res;
            res = pre + in;
        }
        return res;

    }


    //

    //
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] > array[i + 1])
                return array[i + 1];
        }
        return array[0];
    }

    //
    //Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);

        return root;
    }


    //

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null)
            return res;
        do {
            res.add(listNode.val);
            listNode = listNode.next;
        } while (listNode != null);

//        Collections.reverse(res);
        int head = 0;
        int tail = res.size() - 1;
        while (head < tail) {
            int temp = res.get(head);
            res.set(head++, res.get(tail));
            res.set(tail--, temp);
        }
        return res;

    }


    //空格替换为%20
    public String replaceSpace(StringBuffer str) {
//        List list = new ArrayList<>();
        StringBuffer res = new StringBuffer();
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == ' ') {
                res.append("%20");
            } else
                res.append(str.charAt(i));
            i++;
        }
        return res.toString();

    }


    //
    public String replaceSpace2(StringBuffer str) {
        //计算空格数
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                spaceNum++;
        }
        if (spaceNum == 0)
            return str.toString();
        //修改数组长度
        int originLength = str.length() - 1;
        str.setLength(str.length() + 2 * spaceNum);
        int newLength = str.length() - 1;
        //从末尾往前移动
        while (originLength >= 0) {
            if (str.charAt(originLength) == ' ') {
                str.setCharAt(newLength--, '0');
                str.setCharAt(newLength--, '2');
                str.setCharAt(newLength--, '%');
            } else
                str.setCharAt(newLength--, str.charAt(originLength));
            originLength--;
        }
        return str.toString();
    }


    //二维矩阵查找问题
    public boolean Find1(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0)
            return false;
        int i = array.length - 1;
        int j = 0;
        while (i >= 0 && j <= array[0].length - 1) {
            if (target == array[i][j])
                return true;
            else if (target > array[i][j])
                j++;
            else
                i--;
        }
        return false;

    }


    public static boolean Find(int target, int[][] array) {
        //Check null
        if (array.length == 0 || array[0].length == 0)
            return false;
        if (target < array[0][0] || target > array[array.length - 1][array[0].length - 1])
            return false;
        int rowLow = 0;
        int rowHigh = array.length - 1;
        int rowMid = (rowLow + rowHigh) / 2;
        int cLow = 0;
        int cHigh = array[0].length - 1;
        int cMid = (cLow + cHigh) / 2;


        while (cLow <= cHigh && rowLow <= rowHigh) {
            if (target == array[rowMid][cMid]) {
                return true;
            } else if (target < array[rowMid][cMid]) {
                rowHigh = rowMid - 1;
                rowMid = (rowLow + rowHigh) / 2;
                cHigh = cMid - 1;
                cMid = (cLow + cHigh) / 2;

            } else {
                rowLow = rowMid + 1;
                rowMid = (rowLow + rowHigh) / 2;
                cLow = cMid + 1;
                cMid = (cLow + cHigh) / 2;
            }
        }
        for (int i = 0; i < cLow; i++) {
            if (array[rowLow][i] == target)
                return true;
        }

        for (int i = 0; i < rowLow; i++) {
            if (array[i][cLow] == target)
                return true;
        }

        return false;


    }


}
