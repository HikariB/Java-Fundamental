package com.hbLib.MyApi;

import com.sun.org.apache.xpath.internal.operations.Gt;

import java.util.Arrays;

/**
 * 核心操作 Union
 * find：找到所属的组
 */


public class UnionFindSet {

    public int[] parent;   //定义组
    public int[] weight;   //定义改组的个数，用于不同组合并时判断的依据，将个数多的组作为root
    public int size;

    public UnionFindSet(int size) {
        this.size = size;
        parent = new int[size];
        weight = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            weight[i] = 1;
        }
    }

    // 找到自己所在的组
    public int find(int element) {
        while (element != parent[element]) {
            // 路劲压缩
            parent[element] = parent[parent[element]];
            element = parent[element];
        }
        return element;
    }

    public boolean isConnect(int firstElement, int secondElement) {
        return find(firstElement) == find(secondElement);
    }

    public void unionElement(int firstElement, int secondElement) {
        int firstRoot = find(firstElement);
        int secondRoot = find(secondElement);
        if (firstRoot == secondRoot) {
            return;
        }

        if (weight[firstElement] > weight[secondElement]) {
            parent[secondRoot] = firstRoot;
            weight[firstRoot] += weight[secondRoot];
        } else {
            parent[firstRoot] = secondRoot;
            weight[secondRoot] += weight[firstRoot];
        }
    }

    public static class ReturnType {
        public int groupCount;
        public int groupMaxSize;

        public ReturnType(int count, int maxSize) {
            groupCount = count;
            groupMaxSize = maxSize;
        }

        @Override
        public String toString() {
            return "ReturnType{" +
                    "groupCount=" + groupCount +
                    ", groupMaxSize=" + groupMaxSize +
                    '}';
        }
    }

    public ReturnType getGroups() {
        int count = 0;
        int maxsize = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (i == parent[i]) {
                count++;
                maxsize = Math.max(maxsize, weight[i]);
            }
        }
        return new ReturnType(count, maxsize);
    }

    public static void main(String[] args) {
        int size = 10;
        UnionFindSet ufs = new UnionFindSet(size);
        ufs.unionElement(5, 6);
        ufs.unionElement(1, 8);
        ufs.unionElement(2, 6);
        ufs.unionElement(3, 7);
        System.out.println(ufs.isConnect(2, 5));
        System.out.println(ufs.getGroups());
        System.out.println(Arrays.toString(ufs.parent));
    }


}
