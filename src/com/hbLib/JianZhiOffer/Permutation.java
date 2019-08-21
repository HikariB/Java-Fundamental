package com.hbLib.JianZhiOffer;

import com.hbLib.SortSolution.ArraySort;
import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Permutation {
    private ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> solution(String str) {
        res.clear();
        if (str == null || str.length()==0)
            return res;

        solution(str, 0);
        Collections.sort(res);
        return res;
    }

    private void solution(String str, int begin) {
        if (begin == str.length() - 1) {
            if (!res.contains(str))
                res.add(str);
            return;
        } else {
            for (int i = begin; i < str.length(); i++) {
                String newStr = swap(str, i, begin);
                solution(newStr, begin + 1);
            }
        }
    }

    private String swap(String str, int i, int begin) {
        StringBuilder res = new StringBuilder(str);
        char temp = str.charAt(i);
        res.setCharAt(i, str.charAt(begin));
        res.setCharAt(begin, temp);
        return res.toString();

    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        List<String> res = p.solution("abc");
        System.out.println(res.toString());
    }
}


/**
 * 1、递归算法
 *
 * 解析：http://www.cnblogs.com/cxjchen/p/3932949.html  (感谢该文作者！)
 *
 * 对于无重复值的情况
 *
 * 固定第一个字符，递归取得首位后面的各种字符串组合；
 * 再把第一个字符与后面每一个字符交换，并同样递归获得首位后面的字符串组合； *递归的出口，就是只剩一个字符的时候，递归的循环过程，就是从每个子串的第二个字符开始依次与第一个字符交换，然后继续处理子串。
 *
 * 假如有重复值呢？
 * *由于全排列就是从第一个数字起，每个数分别与它后面的数字交换，我们先尝试加个这样的判断——如果一个数与后面的数字相同那么这两个数就不交换了。
 * 例如abb，第一个数与后面两个数交换得bab，bba。然后abb中第二个数和第三个数相同，就不用交换了。
 * 但是对bab，第二个数和第三个数不 同，则需要交换，得到bba。
 * 由于这里的bba和开始第一个数与第三个数交换的结果相同了，因此这个方法不行。
 *
 * 换种思维，对abb，第一个数a与第二个数b交换得到bab，然后考虑第一个数与第三个数交换，此时由于第三个数等于第二个数，
 * 所以第一个数就不再用与第三个数交换了。再考虑bab，它的第二个数与第三个数交换可以解决bba。此时全排列生成完毕！
 *
 *
 * @param str
 * @return
 */