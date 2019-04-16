package com.hbLib.Collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        List<String> alist = new LinkedList<>();
        alist.add("Amy");
        alist.add("Carl");
        alist.add("Erica");

        List<String> blist = new LinkedList<>();
        blist.add("Bob");
        blist.add("Doug");
        blist.add("Frances");
        blist.add("Gloria");

        ListIterator<String> aIter = alist.listIterator();
        Iterator<String> bIter = blist.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            //下面不能使用alist.add()方法，这样会抛出同时修改的异常
            aIter.add(bIter.next());
        }

        System.out.println(alist);

        bIter = blist.iterator();
        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }

        }

        System.out.println(blist);

        alist.removeAll(blist);

        System.out.println(alist);


    }
}
