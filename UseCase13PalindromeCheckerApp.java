/**
 * ===============================================
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * ===============================================
 *
 * Use Case 13: Performance Comparison
 *
 * Description:
 * This class measures and compares the execution
 * performance of palindrome validation algorithms.
 *
 * At this stage, the application:
 * - Uses a palindrome strategy implementation
 * - Captures execution start and end time
 * - Calculates total execution duration
 * - Displays benchmarking results
 *
 * This use case focuses purely on performance
 * measurement and algorithm comparison.
 *
 * The goal is to introduce benchmarking concepts.
 *
 * @author Developer
 * @version 13.0
 */

public class UseCase13PalindromeCheckerApp {

    /**
     * Application entry point for UC13.
     *
     * @param args Command-Line arguments
     */
    public static void main(String[] args) {

        String input = "Level";

        // Normalize input for fair comparison
        input = input.toLowerCase();

        // Choose algorithm (can swap strategies)
        PalindromeStrategy1 stackStrategy = new StackStrategy1();
        PalindromeStrategy1 dequeStrategy = new DequeStrategy1();

        // Benchmark Stack Strategy
        long startTime = System.nanoTime();
        boolean stackResult = stackStrategy.check(input);
        long endTime = System.nanoTime();
        long stackDuration = endTime - startTime;

        // Benchmark Deque Strategy
        long startTime2 = System.nanoTime();
        boolean dequeResult = dequeStrategy.check(input);
        long endTime2 = System.nanoTime();
        long dequeDuration = endTime2 - startTime2;

        // Display Results
        System.out.println("Input : " + input);
        System.out.println("Stack Result : " + stackResult);
        System.out.println("Stack Execution Time : " + stackDuration + " ns");
        System.out.println("-------------------------------------");
        System.out.println("Deque Result : " + dequeResult);
        System.out.println("Deque Execution Time : " + dequeDuration + " ns");
    }
}

/**
 * Strategy Interface
 */
interface PalindromeStrategy1 {
    boolean check(String input);
}

/**
 * Stack-Based Strategy
 */
class StackStrategy1 implements PalindromeStrategy1 {

    public boolean check(String input) {

        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

/**
 * Deque-Based Strategy
 */
class DequeStrategy1 implements PalindromeStrategy1 {

    public boolean check(String input) {

        java.util.Deque<Character> deque =
                new java.util.ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}