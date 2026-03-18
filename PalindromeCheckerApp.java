
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String word = "madam";
        boolean isPalindrome = true;
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println("=================================");
        System.out.println("Word: " + word);

        if (isPalindrome) {
            System.out.println("Result: The string IS a palindrome.");
        } else {
            System.out.println("Result: The string is NOT a palindrome.");
        }
        System.out.println("=================================");
    }
}
