package com.jagdish.interview;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Reference: https://www.hackerrank.com/codepair/shvnedfovizculokmpdtnzitmcynkiea/questions/1?b=eyJpbnRlcnZpZXdfaWQiOjYwOTU5NTUsInJvbGUiOiJpbnRlcnZpZXdlciIsInNob3J0X3VybCI6Imh0dHBzOi8vaHIuZ3MvMGQ3ZjY1YyIsImNhbmRpZGF0ZV91cmwiOiJodHRwczovL2hyLmdzLzgxZDJjODEifQ
public class CompliancePriorties {

    public static List<Integer> reassignedPriorities(List<Integer> priorities) {
        List<Integer> reassignedList = new ArrayList<>();
        Set<Integer> prioritySet = new TreeSet<>();
        prioritySet.addAll(priorities);
        List<Integer> prioritiesArray = new ArrayList<>(prioritySet);
        Collections.sort(prioritiesArray);

        for(int i = 0; i < priorities.size(); i++) {
            int index = prioritiesArray.indexOf(priorities.get(i));
            reassignedList.add(index+1);
        }
        return reassignedList;
    }

    public static List<Integer> reassignedPrioritiesUpdated(List<Integer> priorities) {
        List<Integer> reassignedList = new ArrayList<>();

        List<Integer> sortedPriortiesList = new ArrayList<>(new TreeSet<>(priorities));

        Map<Integer, Integer> priorityRankMap  = new HashMap<>();
        for(int i = 0; i < sortedPriortiesList.size(); i++) {
            priorityRankMap.put(sortedPriortiesList.get(i), i+1 );
        }

        for(int priority : priorities) {
            reassignedList.add(priorityRankMap.get(priority));
        }
        return reassignedList;
    }

    public static List<Integer> reassignedPrioritiesUpdated1(List<Integer> priorities) {
        List<Integer> sortedPriortiesList = priorities.stream()
                .distinct().sorted().toList();

        Map<Integer, Integer> priorityRankMap  = IntStream.range(0,sortedPriortiesList.size())
                .boxed()
                .collect(Collectors.toMap(sortedPriortiesList::get, i-> i+1));

        return priorities.stream()
                .map(priorityRankMap::get)
                .collect(Collectors.toList());

    }
    public static void main(String[] args) {
        Integer[] prioriteis = {2, 9, 3, 2, 3}; //Expected output: [1, 3, 2, 1, 2]
        List<Integer> prioritiesList = new ArrayList<>(List.of(prioriteis));
        System.out.println(prioritiesList);
        System.out.println(reassignedPriorities(prioritiesList));
        System.out.println(reassignedPrioritiesUpdated(prioritiesList));
        System.out.println(reassignedPrioritiesUpdated1(prioritiesList));
    }
}

