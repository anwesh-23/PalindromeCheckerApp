/**
 * ==============================================================
 * MAIN CLASS - UseCase8PalindromeCheckerApp
 * ==============================================================
 *
 * Use Case 8: Linked List Based Palindrome Checker
 *
 * Description:
 * This class checks whether a string is a palindrome
 * using a singly linked list.
 *
 * Steps:
 * 1. Convert string into linked list
 * 2. Find middle using fast & slow pointers
 * 3. Reverse second half of list
 * 4. Compare both halves
 *
 * @author Developer
 * @version 8.0
 */

public class PalindromeCheckerApp {

    // Node class for singly linked list
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to check palindrome
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        // Find middle using fast & slow pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node prev = null;
        Node current = slow;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Compare first half and reversed second half
        Node firstHalf = head;
        Node secondHalf = prev;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data)
                return false;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // Convert string to linked list
    public static Node createList(String input) {
        Node head = null, tail = null;

        for (char c : input.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    /**
     * Application entry point for UC8
     */
    public static void main(String[] args) {

        String input = "level";   // change input here

        Node head = createList(input);

        boolean result = isPalindrome(head);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}