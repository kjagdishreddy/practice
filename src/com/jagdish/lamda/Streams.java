package com.jagdish.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        Integer[] numbersArray = {7, 5, 8, 2, 4, 5, 2};
        List<Integer> numbers = new ArrayList<>(Arrays.asList(numbersArray));

        // print even numbers
        numbers.stream().filter(x -> x % 2 == 0).forEach(System.out::println);

        System.out.println("---------------");
        List<Integer> evenNumbers = numbers.stream().filter(x -> x % 2 == 0).toList();
        evenNumbers.forEach(System.out::println);

        System.out.println("---------------");
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        sortedNumbers.forEach(System.out::println);

        System.out.println("sort---------------");
        numbers.stream().map(sortedNumbers::indexOf).map(x -> (x + 1) ).forEach(System.out::println);


        System.out.println("---------------");
        Stream<String> fruits = Stream.of("banana", "apple", "mango");
        fruits.map(String::toUpperCase).forEach(System.out::println);

        System.out.println("---------------");
        numbers.stream().distinct().sorted().toList().forEach(System.out::println);
    }
}
