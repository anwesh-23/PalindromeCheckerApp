/**
 * ==============================================================
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 13: Performance Comparison
 *
 * Description:
 * This class measures and compares the execution
 * performance of a palindrome validation algorithm.
 *
 * The application:
 *  - Captures start & end execution time
 *  - Calculates total duration
 *  - Displays benchmarking results
 *
 * Focus: Performance measurement concepts
 *
 * @author Developer
 * @version 13.0
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        // Capture start time
        long startTime = System.nanoTime();

        boolean result = isPalindrome(input);

        // Capture end time
        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
        System.out.println("Execution Time : " + executionTime + " ns");
    }

    // Simple palindrome check method
    public static boolean isPalindrome(String input) {

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}