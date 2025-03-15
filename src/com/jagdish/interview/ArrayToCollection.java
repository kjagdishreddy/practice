package com.jagdish.interview;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

// Convert an Array into Collection in Java
// import java util library

public class ArrayToCollection {
    public static void main(String[] args) {
        // array input
        String[] students = {"John", "Kevin", "Tim"};

        // printing array elements
        System.out.println("Arrays Input = " + Arrays.toString(students));

        // converting array into collection
        List<String> studentList = Arrays.asList(students);

        System.out.println("Students List = " + studentList);

    }

}
