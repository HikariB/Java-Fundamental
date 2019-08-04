package com.hbLib.ACNowCoder;

import java.util.*;

public class ComparableNComparator {

    /**
     * comparable 接口 指示一个类是可以比较的，属于内部比较器
     * 实现该接口的类，为可排序的类，在sort方法或者treemap，treeset，priorityque这样集合中是不需要额外传入comparator接口的
     * 通过 x.compareTo(y) 来“比较x和y的大小”。若返回“负数”，意味着“x比y小”；返回“零”，意味着“x等于y”；返回“正数”，意味着“x大于y”。
     */

    /**
     * comparator 属于外部比较器
     * 通常是传入sort 或者 需要排序的集合中new comparator
     */


    static class Student implements Comparable<Student> {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {

            return (this.score - o.score);
        }
    }

    static class MyComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.name.compareTo(o2.name);
        }
    }


    public static void main(String[] args) {

        Student a1 =new Student("Aef",11);
        Student b =new Student("Acd",11);
        Student c =new Student("qec",11);
        Student d =new Student("aef",11);
        Student e =new Student("Ddd",11);
        List<Student> myStus = new ArrayList<>();
        myStus.add(a1);
        myStus.add(b);
        myStus.add(c);
        myStus.add(d);
        myStus.add(e);
        Collections.sort(myStus,new MyComparator());




        //demo for comparable
        List<Student> stuList = new ArrayList<>();
        Student[] stuArray = new Student[6];
        Map<Student, String> stuMap = new TreeMap<>();
        Set<Student> stuSet = new TreeSet<>();
        // 此时是最小堆，注意堆只是堆顶最小并不意味着全序
        Queue<Student> studentQueue = new PriorityQueue<>();


        Random random = new Random(100);
        for (int i = 0; i < 6; i++) {

            Student a = new Student("TEST", random.nextInt(100));
            stuList.add(a);
            stuArray[i] = a;
            stuMap.put(a, "CS");
            stuSet.add(a);
            studentQueue.add(a);

        }
        Collections.sort(stuList);
        Arrays.sort(stuArray);

        Queue<Student> maxQueue = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.score - o1.score ;
            }
        });
        maxQueue.addAll(stuList);

        //
        System.out.println(maxQueue.peek().score + ","+studentQueue.peek().score);

    }
}
