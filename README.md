# JUnit 5 Basics Documentation

This repository provides an introduction to **JUnit 5** for unit testing in Java. It covers annotations, assertions, test ordering, and configurations for Maven projects.

## Table of Contents

[Annotations](#annotations)
[Assertions](#assertions)
[Test Execution Order](#test-execution-order)
[Maven Configuration](#maven-configuration)
[Running Tests](#running-tests)

---

## Introduction

JUnit 5 is the next generation of JUnit, consisting of three modules:
- **JUnit Platform**: For launching testing frameworks.
- **JUnit Jupiter**: For writing tests with JUnit 5.
- **JUnit Vintage**: For running JUnit 3 and 4 tests.

---

## Annotations

JUnit 5 introduces several annotations for test setup, execution, and cleanup:

- `@BeforeEach`: Executed before each test method.
  - Use for setting up test data or objects.
  
- `@AfterEach`: Executed after each test method.
  - Use for cleaning up resources.

- `@BeforeAll`: Executed once before all test methods.
  - Use for global setup (e.g., establishing database connections).

- `@AfterAll`: Executed once after all test methods.
  - Use for global cleanup.

- `@Test`: Marks a method as a test case.

- `@DisplayName`: Provides a custom name for a test method.

- `@Order`: Defines the execution order of test methods.

- Conditional Annotations:
  - `@EnabledOnOs`: Executes a test only on specified operating systems.
  - `@EnabledOnJre`: Executes a test only on specific Java Runtime versions.
  - `@EnabledIfEnvironmentVariable`: Executes a test based on an environment variable.
  - `@EnabledIfSystemProperty`: Executes a test based on a system property.

---

## Assertions

JUnit 5 provides various assertions to validate expected outcomes:

- `assertEquals(expected, actual)`: Verifies that two values are equal.
- `assertNotEquals(unexpected, actual)`: Verifies that two values are not equal.
- `assertNull(object)`: Checks that an object is `null`.
- `assertNotNull(object)`: Checks that an object is not `null`.
- `assertSame(expected, actual)`: Verifies that two objects refer to the same instance.
- `assertNotSame(unexpected, actual)`: Verifies that two objects do not refer to the same instance.
- `assertArrayEquals(expected, actual)`: Verifies that two arrays are equal.
- `assertThrows(expectedType, executable)`: Verifies that a specific exception is thrown.
- `assertTimeout(duration, executable)`: Ensures a test completes within the given time.

---

## Test Execution Order

Use `@TestMethodOrder` to define the order of test execution:

- **Default Order**: Tests run in an arbitrary order.
- **Ordered Tests**: Annotate the class with `@TestMethodOrder(MethodOrderer.OrderAnnotation.class)` and use `@Order` on methods.
