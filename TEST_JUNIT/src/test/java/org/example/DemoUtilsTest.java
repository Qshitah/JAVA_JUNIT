package org.example;
/*
    Unit test have the following structure
    Set Up -- Create instance of the class to test
    Execute -- Call the method you want to test
    Assert -- Check the result and verify that it's the expected result
 */

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach(){
        demoUtils = new DemoUtils();
        System.out.println("@BeforeEach executes before the execution of each test method");
    }

    @AfterEach
    void tearDownAfterEach(){
        System.out.println("@AfterEach executes after the execution of each test method");
    }

    //By default, methods must be static
    //They are static because they only executed once should be depend on class not an object
    @BeforeAll
    static void setupBeforeClass(){
        System.out.println("@BeforeAll executes only once before all test methods execution in the class");
    }

    @AfterAll
    static void tearDownAfterClass(){
        System.out.println("@AfterAll executes only once after all test methods execution in the class");
    }

    @Test
    void testEqualsAndNotEquals() {
        //Set Up
        System.out.println("Running Test: testEqualsAndNotEquals");

        //execute and assert
        assertEquals(6, demoUtils.add(2,4), "2+4 must be 6");
    }

    @Test
    void testNullAndNotNull(){
        System.out.println("Running Test: testNullAndNotNull");

        assertNull(demoUtils.checkNull(null));
        assertNotNull(demoUtils.checkNull("test"));
    }

    @Test
    void testSameAndNotSame(){
        System.out.println("Running Test: testSameAndNotSame");

        String str = "Test22";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademy(),"Academy does match");
        assertNotSame(str,demoUtils.getAcademy(),"Academy does not match");
    }

    @DisplayName("Array Equals")
    @Test
    void testArrayEquals(){
        String[] strArr = {"Test22","Test33","Test44"};
        String[] strArr2 = {"Test22","Test33","Test44"};

        assertArrayEquals(strArr,strArr2,"Arrays are equal");
    }

    @DisplayName("Test Iterable Equals")
    @Test
    void testIterableEquals(){
        List<String> theList = Arrays.asList("Test22","Test33","Test44");
        List<String> theList2 = Arrays.asList("Test22","Test33","Test44");

        System.out.println("Test Iterable Equals");
        assertIterableEquals(theList,theList2,"Iterables equal");
    }

}
