package org.example;

import org.example.tdd.FizzBuzz;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start FizzBuzz Application For Range 1-100");
        for(int i = 1; i <= 100; i++){
            System.out.println(i + " : " + FizzBuzz.compute(i));
        }
    }
}