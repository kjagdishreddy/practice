package com.jagdish.lamda;

public class Greeter {
    public void greet(Greeting greeting) {
        greeting.perform();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        //HelloWorldGreeting greeting = new HelloWorldGreeting();
        Greeting lambdaGreeting = () -> System.out.println("Hello World");
        greeter.greet(lambdaGreeting);
    }
}

