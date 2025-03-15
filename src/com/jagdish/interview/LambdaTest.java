package com.jagdish.interview;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("John");
        list.add("Tom");
        list.add("Andrew");
        list.add("Martin");

        list.forEach(System.out::println);
        //list.forEach((name) -> {System.out.println(name);});
    }
}
