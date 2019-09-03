package com.hbLib.LeetCode;

import com.hbLib.TreeTraverse.TreeNode;

import java.util.*;

public class Top100 {
    public int maxArea_11(int[] height) {
        if (height.length <= 1)
            return 0;
        int i = 0;
        int j = height.length - 1;
        int max = -1;
        while (i < j) {
            int newArea = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, newArea);
            if (height[i] <= height[j])
                i++;
            else
                j--;
        }


        return max;

    }

    public boolean isValid_20(String s) {
        if (s == null || (s.length() & 1) == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            if (sc == '(' || sc == '[' || sc == '{') {
                stack.push(sc);
            } else if (sc == ')' || sc == ']' || sc == '}') {
                if (stack.isEmpty())
                    return false;
                char c = stack.pop();

                if (sc == ')' && c != '(') {
                    return false;
                }
                if (sc == ']' && c != '[') {
                    return false;
                }
                if (sc == '}' && c != '{') {
                    return false;
                }

            } else
                return false;
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    public List<String> generateParenthesis_22(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
            return ans;
        }
        for (int i = 1; i <= n; i++) {
            for (String leftStr : generateParenthesis_22(i - 1))
                for (String rightStr : generateParenthesis_22(n - i))
                    ans.add("(" + leftStr + ")" + rightStr);
        }
        return ans;
    }

    public int longestValidParentheses(String s) {
        int max = -1;
        int right = 0;
        int pos = 0; // (
        int neg = 0; // )
        while (right < s.length()) {
            if (s.charAt(right) == '(') {
                pos++;
            } else if (s.charAt(right) == ')') {
                neg++;
            }
            if (neg > pos) {
                pos = 0;
                neg = 0;
            } else {
                max = Math.max(max, Math.min(neg, pos));
            }
            right++;
        }
        return max;
    }

    public List<String> restoreIpAddresses_93(String s) {

        List<String> ans = new LinkedList<>();
        if (s.length() < 4 || s.length() > 16) {
            return ans;
        }
        LinkedList<Integer> pre = new LinkedList<>();
        tryRestoreIp(s, ans, 0, pre);
        return ans;
    }

    private void tryRestoreIp(String s, List<String> ans, int i, LinkedList<Integer> pre) {
        if (pre.size() == 4) {
            if (i == s.length()) {
                List<String> sl = new LinkedList<>();
                for (int ip : pre) {
                    sl.add(String.valueOf(ip));
                }
                ans.add(String.join(".", sl));
            }
            return;
        }
        // 避免越界
        for (int len = 1; len <= Math.min(3, s.length() - i); len++) {
            String seg = s.substring(i, i + len);
            // 防止出现 010 001 00
            if (seg.startsWith("0") && len > 1) {
                return;
            }
            int ipSegment = Integer.parseInt(seg);
            if (ipSegment >= 0 && ipSegment <= 255) {
                pre.addLast(ipSegment);
                tryRestoreIp(s, ans, i + len, pre);
                pre.removeLast();
            } else {
                return;
            }
        }

    }

    public List<Integer> rightSideView_199(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        // level Traverse
        int levelNum;
        int nextLevelNum = 1;
        while (!queue.isEmpty()) {
            levelNum = nextLevelNum;
            nextLevelNum = 0;
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.pollFirst();
                // 该层的最后一个节点
                if (i == levelNum - 1)
                    res.add(node.val);
                if (node.left != null) {
                    nextLevelNum++;
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    nextLevelNum++;
                    queue.addLast(node.right);
                }
            }
        }
        return res;
    }

    public List<Integer> rightSideView_199_2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfsRightSideView(root, 1, res);
        return res;
    }

    private void dfsRightSideView(TreeNode node, int i, List<Integer> res) {
        if (node == null) return;
        if (res.size() < i) res.add(node.val);
        dfsRightSideView(node.right, i + 1, res);
        dfsRightSideView(node.left, i + 1, res);
    }


    public int lengthOfLIS_300(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxres = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            maxres = Math.max(max, maxres);
        }
        return maxres;
    }

    public int search_33(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] < nums[mid]) {
                // 左边有序
                if (target == nums[left]) {
                    return left;
                }
                // 是否位于左边
                if (target > nums[left] && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target == nums[right])
                    return right;
                // 右边有序
                if (target > nums[mid] && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

        }
        return nums[right] == target ? right : -1;


    }

    public int[] searchRange_34(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        if (nums == null || nums.length == 0) {
            return res;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                if (mid == 0) {
                    res[0] = 0;
                    break;
                }

                if (nums[mid] == nums[mid - 1]) {
                    right = mid - 1;
                } else {
                    res[0] = mid;
                    break;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {

                if (mid == nums.length - 1) {
                    res[1] = nums.length - 1;
                    break;
                }

                if (nums[mid] == nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    res[1] = mid;
                    break;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    // 积雨水
//    public int trap_42(int[] height) {
//
//    }

    public List<Integer> spiralOrder_54(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;


        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            if (--right < left) break;
            for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            if (++left > right) break;
        }
        return res;
    }

    public int[][] generateMatrix_59(int n) {
        int[][] res = new int[n][n];
        if (n <= 0) {
            return res;
        }
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int left = 0;

        for (int value = 1; value <= n * n; ) {
            for (int i = left; i <= right; i++) res[top][i] = value++;
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) res[i][right] = value++;
            if (--right < left) break;
            for (int i = right; i >= left; i--) res[bottom][i] = value++;
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) res[i][left] = value++;
            if (++left > right) break;
        }
        return res;
    }


    public static void main(String[] args) {
        new Top100().lengthOfLIS_300(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }

}
