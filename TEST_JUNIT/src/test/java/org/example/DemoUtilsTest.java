package org.example;

/*
 * This class demonstrates unit testing using JUnit 5.
 * It includes the typical structure for unit tests:
 * 1. Setup - Prepare the necessary objects and state.
 * 2. Execute - Call the method being tested.
 * 3. Assert - Verify that the results match the expected outcomes.
 * The annotations used provide additional functionality like ordering tests,
 * setting up and tearing down resources, and testing specific conditions.
 */

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class) // Generates display names for test methods
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Specifies the order in which tests are executed
public class DemoUtilsTest {

    DemoUtils demoUtils; // Instance of the class to be tested

    /**
     * This method is executed before each test method.
     * It initializes the necessary setup for the test.
     */
    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
        System.out.println("@BeforeEach executes before the execution of each test method");
    }

    /**
     * This method is executed after each test method.
     * It performs cleanup tasks after each test.
     */
    @AfterEach
    void tearDownAfterEach() {
        System.out.println("@AfterEach executes after the execution of each test method");
    }

    /**
     * This static method is executed once before all test methods in the class.
     * It is typically used for one-time setup tasks like initializing shared resources.
     */
    @BeforeAll
    static void setupBeforeClass() {
        System.out.println("@BeforeAll executes only once before all test methods execution in the class");
    }

    /**
     * This static method is executed once after all test methods in the class.
     * It is typically used for one-time cleanup tasks like releasing shared resources.
     */
    @AfterAll
    static void tearDownAfterClass() {
        System.out.println("@AfterAll executes only once after all test methods execution in the class");
    }

    /**
     * Test for equality and inequality.
     * Verifies that the addition method returns the correct result.
     */
    @Test
    @Order(1)
    void testEqualsAndNotEquals() {
        System.out.println("Running Test: testEqualsAndNotEquals");
        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
    }

    /**
     * Test for null and non-null values.
     * Verifies the behavior of the method when handling null and non-null inputs.
     */
    @Test
    @Order(2)
    void testNullAndNotNull() {
        System.out.println("Running Test: testNullAndNotNull");
        assertNull(demoUtils.checkNull(null));
        assertNotNull(demoUtils.checkNull("test"));
    }

    /**
     * Test for object sameness and non-sameness.
     * Verifies if two references point to the same object or different objects.
     */
    @Test
    @Order(3)
    void testSameAndNotSame() {
        System.out.println("Running Test: testSameAndNotSame");
        String str = "Test22";
        assertSame(demoUtils.getAcademyDuplicate(), demoUtils.getAcademy(), "Academy does match");
        assertNotSame(str, demoUtils.getAcademy(), "Academy does not match");
    }

    /**
     * Test for array equality.
     * Verifies if two arrays contain the same elements in the same order.
     */
    @DisplayName("Array Equals")
    @Test
    @Order(4)
    void testArrayEquals() {
        String[] strArr = {"Test22", "Test33", "Test44"};
        String[] strArr2 = {"Test22", "Test33", "Test44"};
        assertArrayEquals(strArr, strArr2, "Arrays are equal");
    }

    /**
     * Test for iterable equality.
     * Verifies if two collections contain the same elements in the same order.
     */
    @DisplayName("Test Iterable Equals")
    @Test
    @Order(6)
    void testIterableEquals() {
        List<String> theList = Arrays.asList("Test22", "Test33", "Test44");
        List<String> theList2 = Arrays.asList("Test22", "Test33", "Test44");
        System.out.println("Test Iterable Equals");
        assertIterableEquals(theList, theList2, "Iterables equal");
    }

    /**
     * Test for exception throwing and non-throwing.
     * Verifies that the method throws an exception for invalid inputs
     * and does not throw exceptions for valid inputs.
     */
    @DisplayName("Throws and Does Not Throws")
    @Test
    @Order(5)
    void testThrowsAndDoesNotThrow() {
        assertThrows(Exception.class, () -> demoUtils.throwException(-1), "Should throw an exception");
        assertDoesNotThrow(() -> demoUtils.throwException(2), "Should not throw an exception");
    }

    /**
     * Test for timeout.
     * Verifies that the method executes within the specified duration.
     */
    @DisplayName("Timeout")
    @Test
    @Order(7)
    void testTimeOut() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> demoUtils.checkTimeout(), "Method should execute in 3 seconds");
    }
}
