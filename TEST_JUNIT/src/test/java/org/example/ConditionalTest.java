package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

/**
 * This class demonstrates the use of conditional execution in JUnit 5 tests.
 * Conditional annotations are used to enable or disable tests based on various factors such as
 * operating system, Java runtime environment (JRE), system properties, and environment variables.
 */
public class ConditionalTest {

    /**
     * A basic test that is currently disabled.
     *
     * @Disabled - This annotation disables the test, preventing it from being executed.
     * The optional reason provides context for why the test is disabled.
     */
    @Test
    @Disabled("Don't run until JIRA #123 is resolved")
    void basicTest() {
        // Test logic here
    }

    /**
     * Test that runs only on Windows operating systems.
     *
     * @EnabledOnOs - Enables the test for specific operating systems.
     * Here, the test will execute only on Windows.
     */
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowsOnly() {
        // Test logic here
    }

    /**
     * Test that runs only on macOS operating systems.
     *
     * @EnabledOnOs - Enables the test for specific operating systems.
     * Here, the test will execute only on macOS.
     */
    @Test
    @EnabledOnOs(OS.MAC)
    void testForMacOnly() {
        // Test logic here
    }

    /**
     * Test that runs only on Linux operating systems.
     *
     * @EnabledOnOs - Enables the test for specific operating systems.
     * Here, the test will execute only on Linux.
     */
    @Test
    @EnabledOnOs(OS.LINUX)
    void testForLinuxOnly() {
        // Test logic here
    }

    /**
     * Test that runs only on Linux and macOS operating systems.
     *
     * @EnabledOnOs - Enables the test for specific operating systems.
     * Here, the test will execute on both Linux and macOS.
     */
    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testForLinuxAndMacOnly() {
        // Test logic here
    }

    /**
     * Test that runs only on Java 17 runtime environment.
     *
     * @EnabledOnJre - Enables the test for a specific Java runtime environment version.
     */
    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testForJAVA17() {
        // Test logic here
    }

    /**
     * Test that runs only within a range of Java runtime environment versions.
     *
     * @EnabledForJreRange - Enables the test for a range of Java runtime environment versions.
     * Here, the test will run on Java versions 8 through 18.
     */
    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_18)
    void testOnlyForJavaRange() {
        // Test logic here
    }

    /**
     * Test that runs on a minimum Java runtime environment version.
     *
     * @EnabledForJreRange - Enables the test for Java versions greater than or equal to the specified minimum.
     * Here, the test will run on Java 11 and later.
     */
    @Test
    @EnabledForJreRange(min = JRE.JAVA_11)
    void testOnlyMinJavaVersion() {
        // Test logic here
    }

    /**
     * Test that runs only when a specific environment variable is set.
     *
     * @EnabledIfEnvironmentVariable - Enables the test if the specified environment variable matches the given value.
     * Here, the test will run only if the "ENV" variable is set to "DEV".
     */
    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "DEV")
    void testOnlyForDevEnvironment() {
        // Test logic here
    }

    /**
     * Test that runs only when a specific system property is set.
     *
     * @EnabledIfSystemProperty - Enables the test if the specified system property matches the given value.
     * Here, the test will run only if the "SYS_PROP" property is set to "CI_CD_DEPLOY".
     */
    @Test
    @EnabledIfSystemProperty(named = "SYS_PROP", matches = "CI_CD_DEPLOY")
    void testOnlyForSystemProperty() {
        // Test logic here
    }
}
