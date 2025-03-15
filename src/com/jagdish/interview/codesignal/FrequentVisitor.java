package com.jagdish.interview.codesignal;

import java.util.HashMap;

/*
Alright, Stellar Navigator, imagine you're a webmaster of a popular website and you monitor visits from various users.
You've got a list of identifier numbers linked to each visit, where each number represents a unique user.
Now, imagine a situation where one of them visits the site more frequently, precisely, more than n/4 times, where
n is the total number of visits. If that's the case, you'd want to find out who it is. So, here's your task:
Write a script that scans the list and points out that frequent visitor. Non-negative integers represent the identifiers,
but ignore the case when the identifier is zero. If there's no such frequent user, your script should return -1.
Your journey awaits, but remember, don't rush and keep an eye on the stars!

Reference: https://codesignal.com/learn/course/37/unit/6/practice/1
 */
public class FrequentVisitor {
    public int frequentUser(int[] visits) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int frequentVisitThreshold = visits.length / 4;

        for (int visit : visits) {
            countMap.put(visit, countMap.getOrDefault(visit, 0) + 1);
            if (countMap.get(visit) > frequentVisitThreshold) {
                return visit;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FrequentVisitor solution = new FrequentVisitor();

        int[] visits1 = {1,2,3,1,2,3,1,2,3,1};
        int frequentUser1 = solution.frequentUser(visits1);
        System.out.println("Frequent User: " + frequentUser1);  // Expected output: 1

        int[] visits2 = {5,0,5,0,5,0,5,0,1,1,1,1,1};
        int frequentUser2 = solution.frequentUser(visits2);
        System.out.println("Frequent User: " + frequentUser2);  // Expected output: 5

        int[] visits3 = {3,2,2,1,3,2,3,0,0,1,4,1};
        int frequentUser3 = solution.frequentUser(visits3);
        System.out.println("Frequent User: " + frequentUser3);  // Expected output: -1
    }

}
