/**
 * ==============================================================
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 12: Strategy Pattern for Palindromes
 *
 * Description:
 * Demonstrates how different palindrome validation
 * algorithms can be selected dynamically at runtime
 * using the Strategy Design Pattern.
 *
 * The application:
 *  - Defines a PalindromeStrategy interface
 *  - Implements a Stack-based strategy
 *  - Injects the strategy at runtime
 *  - Executes the selected algorithm
 *
 * Focus: Algorithm interchangeability & extensibility
 *
 * @author Developer
 * @version 12.0
 */

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        // Inject strategy at runtime
        PalindromeStrategy strategy = new StackStrategy();

        boolean result = strategy.check(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}

/**
 * INTERFACE: PalindromeStrategy
 *
 * Defines a contract for palindrome algorithms.
 */
interface PalindromeStrategy {
    boolean check(String input);
}

/**
 * CLASS: StackStrategy
 *
 * Implements palindrome validation using Stack.
 */
class StackStrategy implements PalindromeStrategy {

    /**
     * Uses LIFO behavior of stack to compare characters.
     */
    public boolean check(String input) {

        java.util.Stack<Character> stack = new java.util.Stack<>();

        // Push characters onto stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Compare by popping from stack
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}