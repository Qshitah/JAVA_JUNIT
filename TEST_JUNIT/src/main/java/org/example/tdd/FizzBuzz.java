package org.example.tdd;

public class FizzBuzz {

    // If the number divisible by 3 , print Fizz.
    // If the number divisible by 5 , print Buzz.
    // If the number divisible by 3 and 5 , print FizzBuzz.
    // If the number not divisible by 3 or 5 , then print the number.

    public static String compute(int number){
        StringBuilder result = new StringBuilder();

        if(number % 3 == 0){
            result.append("Fizz");
        }

        if(number % 5 == 0){
            result.append("Buzz");
        }

        if(result.isEmpty()){
           result.append(number);
        }

        return result.toString();
    }
   /*
    public static String compute(int number){
        if((number % 3 == 0) && (number % 5 == 0)){
            return "FizzBuzz";
        }
        else if( number % 3 == 0){
            return "Fizz";
        }
        else if( number % 5 == 0){
            return "Buzz";
        }
        return String.valueOf(number);
    }
    */
}
