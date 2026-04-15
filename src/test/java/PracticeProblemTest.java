import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.lang.reflect.*;

public class PracticeProblemTest {

    // =========================================================
    // Q1 - intChecker()
    // =========================================================

    @Test
    @DisplayName("intChecker: valid integer input returns the integer")
    public void testIntCheckerValidInput() {
        String data = "42\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("intChecker");
            int result = (int) method.invoke(null);
            assertEquals(42, result);
        } catch (NoSuchMethodException e) {
            fail("Method intChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("intChecker: prompts 'Input an integer: ' on valid input")
    public void testIntCheckerPrompt() {
        String data = "7\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("intChecker");
            method.invoke(null);
            assertTrue(bos.toString().contains("Input an integer: "),
                "Expected prompt 'Input an integer: ' was not printed");
        } catch (NoSuchMethodException e) {
            fail("Method intChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("intChecker: re-prompts on invalid input, then accepts integer")
    public void testIntCheckerRepromptThenValid() {
        // First input is invalid (a word), second is a valid integer
        String data = "hello\n5\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("intChecker");
            int result = (int) method.invoke(null);
            assertEquals(5, result);
            // Should have printed the prompt at least twice
            String output = bos.toString();
            int count = output.split("Input an integer: ", -1).length - 1;
            assertTrue(count >= 2, "Expected prompt to appear at least twice on invalid input");
        } catch (NoSuchMethodException e) {
            fail("Method intChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("intChecker: rejects a decimal, then accepts integer")
    public void testIntCheckerRejectsDecimal() {
        String data = "3.14\n10\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("intChecker");
            int result = (int) method.invoke(null);
            assertEquals(10, result);
        } catch (NoSuchMethodException e) {
            fail("Method intChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("intChecker: accepts negative integer")
    public void testIntCheckerNegativeInteger() {
        String data = "-99\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("intChecker");
            int result = (int) method.invoke(null);
            assertEquals(-99, result);
        } catch (NoSuchMethodException e) {
            fail("Method intChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("intChecker: accepts zero")
    public void testIntCheckerZero() {
        String data = "0\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("intChecker");
            int result = (int) method.invoke(null);
            assertEquals(0, result);
        } catch (NoSuchMethodException e) {
            fail("Method intChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    // =========================================================
    // Q2 - doubleChecker()
    // =========================================================

    @Test
    @DisplayName("doubleChecker: valid double input returns the double")
    public void testDoubleCheckerValidDouble() {
        String data = "3.14\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("doubleChecker");
            double result = (double) method.invoke(null);
            assertEquals(3.14, result, 0.0001);
        } catch (NoSuchMethodException e) {
            fail("Method doubleChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("doubleChecker: prompts 'Input a number: ' on valid input")
    public void testDoubleCheckerPrompt() {
        String data = "2.5\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("doubleChecker");
            method.invoke(null);
            assertTrue(bos.toString().contains("Input a number: "),
                "Expected prompt 'Input a number: ' was not printed");
        } catch (NoSuchMethodException e) {
            fail("Method doubleChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("doubleChecker: integer input is accepted as a number")
    public void testDoubleCheckerAcceptsInteger() {
        String data = "10\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("doubleChecker");
            double result = (double) method.invoke(null);
            assertEquals(10.0, result, 0.0001);
        } catch (NoSuchMethodException e) {
            fail("Method doubleChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("doubleChecker: re-prompts on non-numeric input, then accepts double")
    public void testDoubleCheckerRepromptThenValid() {
        String data = "abc\n9.81\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("doubleChecker");
            double result = (double) method.invoke(null);
            assertEquals(9.81, result, 0.0001);
            String output = bos.toString();
            int count = output.split("Input a number: ", -1).length - 1;
            assertTrue(count >= 2, "Expected prompt to appear at least twice on invalid input");
        } catch (NoSuchMethodException e) {
            fail("Method doubleChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("doubleChecker: accepts negative double")
    public void testDoubleCheckerNegativeDouble() {
        String data = "-7.5\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("doubleChecker");
            double result = (double) method.invoke(null);
            assertEquals(-7.5, result, 0.0001);
        } catch (NoSuchMethodException e) {
            fail("Method doubleChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    // =========================================================
    // Q3 - booleanChecker()
    // =========================================================

    @Test
    @DisplayName("booleanChecker: 'true' input returns true")
    public void testBooleanCheckerTrue() {
        String data = "true\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("booleanChecker");
            boolean result = (boolean) method.invoke(null);
            assertTrue(result);
        } catch (NoSuchMethodException e) {
            fail("Method booleanChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("booleanChecker: 'false' input returns false")
    public void testBooleanCheckerFalse() {
        String data = "false\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("booleanChecker");
            boolean result = (boolean) method.invoke(null);
            assertFalse(result);
        } catch (NoSuchMethodException e) {
            fail("Method booleanChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("booleanChecker: prompts 'Input a boolean: ' on valid input")
    public void testBooleanCheckerPrompt() {
        String data = "true\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("booleanChecker");
            method.invoke(null);
            assertTrue(bos.toString().contains("Input a boolean: "),
                "Expected prompt 'Input a boolean: ' was not printed");
        } catch (NoSuchMethodException e) {
            fail("Method booleanChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("booleanChecker: re-prompts on invalid input, then accepts 'true'")
    public void testBooleanCheckerRepromptThenTrue() {
        String data = "yes\ntrue\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("booleanChecker");
            boolean result = (boolean) method.invoke(null);
            assertTrue(result);
            String output = bos.toString();
            int count = output.split("Input a boolean: ", -1).length - 1;
            assertTrue(count >= 2, "Expected prompt to appear at least twice on invalid input");
        } catch (NoSuchMethodException e) {
            fail("Method booleanChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("booleanChecker: re-prompts on invalid input, then accepts 'false'")
    public void testBooleanCheckerRepromptThenFalse() {
        String data = "no\n0\nfalse\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("booleanChecker");
            boolean result = (boolean) method.invoke(null);
            assertFalse(result);
        } catch (NoSuchMethodException e) {
            fail("Method booleanChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    // =========================================================
    // Q4 - multipleIntChecker()
    // =========================================================

    @Test
    @DisplayName("multipleIntChecker: four valid integers returns true")
    public void testMultipleIntCheckerAllValid() {
        String data = "1\n2\n3\n4\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("multipleIntChecker");
            boolean result = (boolean) method.invoke(null);
            assertTrue(result);
        } catch (NoSuchMethodException e) {
            fail("Method multipleIntChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("multipleIntChecker: prompts 'Input an integer: ' four times")
    public void testMultipleIntCheckerPromptsFourTimes() {
        String data = "10\n20\n30\n40\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("multipleIntChecker");
            method.invoke(null);
            String output = bos.toString();
            int count = output.split("Input an integer: ", -1).length - 1;
            assertEquals(4, count, "Expected prompt 'Input an integer: ' to appear exactly 4 times");
        } catch (NoSuchMethodException e) {
            fail("Method multipleIntChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("multipleIntChecker: re-prompts on invalid input within count")
    public void testMultipleIntCheckerRepromptOnInvalid() {
        // Invalid on slot 2, then valid — total prompts should be > 4
        String data = "1\nabc\n2\n3\n4\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("multipleIntChecker");
            boolean result = (boolean) method.invoke(null);
            assertTrue(result);
            String output = bos.toString();
            int count = output.split("Input an integer: ", -1).length - 1;
            assertTrue(count > 4, "Expected more than 4 prompts when invalid input is given");
        } catch (NoSuchMethodException e) {
            fail("Method multipleIntChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("multipleIntChecker: multiple invalid inputs before each valid integer")
    public void testMultipleIntCheckerManyInvalidInputs() {
        String data = "a\nb\n1\nfoo\n2\n!\n3\n?\n4\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("multipleIntChecker");
            boolean result = (boolean) method.invoke(null);
            assertTrue(result);
        } catch (NoSuchMethodException e) {
            fail("Method multipleIntChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("multipleIntChecker: accepts negative integers as valid")
    public void testMultipleIntCheckerNegativeIntegers() {
        String data = "-1\n-2\n-3\n-4\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("multipleIntChecker");
            boolean result = (boolean) method.invoke(null);
            assertTrue(result);
        } catch (NoSuchMethodException e) {
            fail("Method multipleIntChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("multipleIntChecker: rejects decimals, then accepts integers")
    public void testMultipleIntCheckerRejectsDecimals() {
        String data = "1.5\n1\n2.2\n2\n3.9\n3\n4.1\n4\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        try {
            Class<?> testClass = PracticeProblem.class;
            Method method = testClass.getDeclaredMethod("multipleIntChecker");
            boolean result = (boolean) method.invoke(null);
            assertTrue(result);
        } catch (NoSuchMethodException e) {
            fail("Method multipleIntChecker does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        } finally {
            System.setOut(originalOut);
        }
    }
}