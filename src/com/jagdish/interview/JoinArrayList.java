package com.jagdish.interview;

import java.util.ArrayList;

public class JoinArrayList {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();

        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");

        ArrayList<String> list2 = new ArrayList<String>();

        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");

        list1.addAll(list2);

        System.out.println("Joined list = " + list1);


    }
}
