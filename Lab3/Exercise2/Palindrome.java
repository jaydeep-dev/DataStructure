package Lab3.Exercise2;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check if it's a palindrome: ");
        String input = scanner.nextLine();

        System.out.println(input + " is " + (isPalindrome(input) ? "" : "NOT ") + "a palindrome.");

        scanner.close();
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) // base case
            return true;

        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindrome(s.substring(1, s.length() - 1)); // so "jaydeep" will become "aydee"
        } else {
            return false;
        }
    }

}
