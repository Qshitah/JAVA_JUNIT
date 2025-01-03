package org.example.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FizzBuzzTest {


    // If the number divisible by 3 , print Fizz.
    @DisplayName("Divisible By Three")
    @Test
    @Order(1)
    void testDivisibleByThree(){
        String expected = "Fizz";

        assertEquals(expected, FizzBuzz.compute(3),"Should return Fizz");
    }

    // If the number divisible by 5 , print Buzz.
    @DisplayName("Divisible By Five")
    @Test
    @Order(2)
    void testDivisibleByFive(){
        String expected = "Buzz";

        assertEquals(expected, FizzBuzz.compute(5),"Should return Buzz");
    }

    // If the number divisible by 3 and 5 , print FizzBuzz.
    @DisplayName("Divisible By Three And Five")
    @Test
    @Order(3)
    void testDivisibleByThreeAndFive(){
        String expected = "FizzBuzz";

        assertEquals(expected, FizzBuzz.compute(15),"Should return FizzBuzz");
    }

    // If the number not divisible by 3 or 5 , then print the number.
    @DisplayName("Not Divisible By Three Or Five")
    @Test
    @Order(4)
    void testNotDivisibleByThreeOrFive(){
        String expected = "1";

        assertEquals(expected, FizzBuzz.compute(1),"Should return 1");
    }

    //Testing with small data test
    @DisplayName("Small Data Test File")
    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    @Order(5)
    void testSmallData(int value, String expected){
        assertEquals(expected, FizzBuzz.compute(value));
    }
}
