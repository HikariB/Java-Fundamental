package com.hbLib.LeetCode.backTrack;

import java.util.*;

public class ArrayBackTrack {
    // ------------
    Map<Character, String> map = new HashMap<>();

    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    List<String> output = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        output.clear();
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    // DFS
    private void backtrack(String s, String digits) {
        if (digits.length() == 0) {
            output.add(s);
            return;
        }
        char c = digits.charAt(0);
        if (map.containsKey(c)) {
            for (int i = 0; i < map.get(c).length(); i++) {
                backtrack(s + map.get(c).charAt(i), digits.substring(1));
            }
        } else {
            throw new IllegalArgumentException();
        }
    }


    // ----------
    //back track
    private List<List<Integer>> res = new LinkedList<>();
    private boolean[] isUsed;   // 记录状态


    public List<List<Integer>> permute(int[] nums) {
        res.clear();
        if (nums.length == 0)
            return res;
        LinkedList<Integer> pre = new LinkedList<>();
        isUsed = new boolean[nums.length];
        permuteBackTrack(nums, 0, pre);
        return res;
    }

    private void permuteBackTrack(int[] nums, int index, LinkedList<Integer> pre) {
        if (index == nums.length) {
            List<Integer> preNew = new LinkedList<>(pre);
            res.add(preNew);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                pre.addLast(nums[i]);
                isUsed[i] = true;
                permuteBackTrack(nums, index + 1, pre);
                isUsed[i] = false;
                pre.removeLast();
            }
        }
    }

    //----
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        if (nums.length == 0) {
            return ans;
        }
        List<Integer> numsList = new ArrayList<>();
        for (int i : nums) {
            numsList.add(i);
        }
        Collections.sort(numsList);
        permuteUniqueProcess(numsList, ans, 0);
        return ans;
    }

    private void permuteUniqueProcess(List<Integer> numsList, List<List<Integer>> ans, int currIndex) {

        if (currIndex == numsList.size()) {
            List<Integer> newList = new ArrayList<>(numsList);
            ans.add(newList);
        }
        Set<Integer> isSwapped = new HashSet<>();
        for (int i = currIndex; i < numsList.size(); i++) {
            if (isSwapped.contains(numsList.get(i))
            ) {
                continue;
            }
            isSwapped.add(numsList.get(i));
            Collections.swap(numsList, currIndex, i);
            permuteUniqueProcess(numsList, ans, currIndex + 1);
            Collections.swap(numsList, currIndex, i);
        }

    }


    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return null;
        }

        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> pre = new LinkedList<>();
        combineProcess(1, n, k, pre, ans);
        return ans;
    }

    private void combineProcess(int from, int to, int k, LinkedList<Integer> pre, List<List<Integer>> ans) {
        if (k == pre.size()) {
            List<Integer> newList = new LinkedList<>(pre);
            ans.add(newList);
            return;
        }
        // 还有 k - pre.size() 空位
        // 剪枝, i <= to 是不合理的，
        for (int i = from; i <= to - (k - pre.size()) + 1; i++) {
            pre.addLast(i);
            combineProcess(from + 1, to, k, pre, ans);
            pre.removeLast();   //回溯
        }
    }

    //-------39
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> pre = new LinkedList<>();

        if (target < candidates[0])
            return ans;
        combinationSum(candidates, 0, target, ans, pre);
        return ans;
    }

    private void combinationSum(int[] candidates, int from, int target, List<List<Integer>> ans, LinkedList<Integer> pre) {
        if (target == 0) {
            LinkedList<Integer> newList = new LinkedList<>(pre);
            ans.add(newList);
            return;
        }
        for (int i = from; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                pre.addLast(candidates[i]);
                combinationSum(candidates, i, target - candidates[i], ans, pre);
                pre.removeLast();
            } else {
                break;
            }
        }
    }

    //-------40
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> pre = new LinkedList<>();

        if (target < candidates[0])
            return ans;
        combinationSum2(candidates, 0, target, ans, pre);
        return ans;
    }

    private void combinationSum2(int[] candidates, int from, int target, List<List<Integer>> ans, LinkedList<Integer> pre) {
        if (target == 0) {
            LinkedList<Integer> newList = new LinkedList<>(pre);
            ans.add(newList);
            return;
        }
        for (int i = from; i < candidates.length; i++) {
            if (i != from && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] <= target) {
                pre.addLast(candidates[i]);
                combinationSum2(candidates, i + 1, target - candidates[i], ans, pre);
                pre.removeLast();
            } else {
                break;
            }
        }

    }

    //----------216
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> pre = new LinkedList<>();
        if (k > 9 || k <= 0 || 45 < n || n < 1)
            return ans;
        combinationSum3(k, n, 1, ans, pre);
        return ans;
    }

    private void combinationSum3(int targetLength, int target, int from, List<List<Integer>> ans, LinkedList<Integer> pre) {
        if (pre.size() > targetLength)
            return;
        if (pre.size() == targetLength && target == 0) {
            LinkedList<Integer> newList = new LinkedList<>(pre);
            ans.add(newList);
            return;
        }
        //
        for (int i = from; i < 10; i++) {
            if (i <= target) {
                pre.addLast(i);
                combinationSum3(targetLength, target - i, i + 1, ans, pre);
                pre.removeLast();
            } else {
                break;
            }
        }
    }

    // ---------78
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> pre = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        subsets(nums, pre, ans, 0);
        return ans;
    }

    private void subsets(int[] nums, LinkedList<Integer> pre, List<List<Integer>> ans, int start) {

        if (start == nums.length) {
            LinkedList<Integer> newList = new LinkedList<>(pre);
            ans.add(newList);
            return;
        }
        pre.addLast(nums[start]);
        subsets(nums,pre,ans,start+1);
        pre.removeLast();
        subsets(nums,pre,ans,start+1);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3
        };
        new ArrayBackTrack().permute(nums);


//        String str = "123";

    }
}
