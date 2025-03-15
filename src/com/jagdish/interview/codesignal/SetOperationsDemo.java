package com.jagdish.interview.codesignal;

import java.util.HashSet;

public class SetOperationsDemo {
    private HashSet<Integer> set1;
    private HashSet<Integer> set2;

    public SetOperationsDemo() {
        set1 = new HashSet<>();
        set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(4);
        set2.add(5);
    }

    public HashSet<Integer> performUnion() {
        HashSet<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }

    public HashSet<Integer> performIntersection() {
        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    public HashSet<Integer> performDifference() {
        // How to make this calculate symmetric difference?
        HashSet<Integer> difference1 = new HashSet<>(set1);
        difference1.removeAll(set2);

        HashSet<Integer> difference2 = new HashSet<>(set2);
        difference2.removeAll(set1);

        difference1.addAll(difference2);
        return difference1;
    }
    public static void main(String[] args) {
        SetOperationsDemo demo = new SetOperationsDemo();
        System.out.println("Union: " + demo.performUnion());
        System.out.println("Intersection: " + demo.performIntersection());
        System.out.println("Difference: " + demo.performDifference());
    }
}