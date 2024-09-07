package com.example.javalearn;

public class MyClass {

    public static void main(String[] args) {
        System.out.println("hello world ");

        String name = "pratik dhkw lkdhkjs";

        System.out.println(name);
        int a = 12;
        int b = 12;
        System.out.println(a+b);
        System.out.println(name.length()); // show length og string
        System.out.println(name.substring(3,6)); // show start position of string

        oop o1 = new oop();
        o1.method1();

        inheritance o2 = new inheritance();
        o2.method2();
        o2.method1();
    }
}