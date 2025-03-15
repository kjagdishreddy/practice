package com.jagdish.lamda;

public class TypeInferenceExample {

    public static void main(String[] args) {
        StringLengthLambda myLambda  = String::length;
        System.out.println(myLambda.getLength("Hwllo Lambda"));
    }

    interface StringLengthLambda {
        int getLength(String s);
    }
}
