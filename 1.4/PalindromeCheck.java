import java.util.*;

public class PalindromeCheck {

    public static boolean canFromPalindrome(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        for (int count : freq.values()) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }

        return oddCount <= 1;
    }

    public static void main(String[] args) {
        // true
        System.out.println(canFromPalindrome("aabbcc"));
        System.out.println(canFromPalindrome("aabbc"));
        System.out.println(canFromPalindrome("aabcc"));
        System.out.println(canFromPalindrome("a"));

        // false
        System.out.println(canFromPalindrome("aabbccddef"));
        System.out.println(canFromPalindrome("abc"));
        System.out.println(canFromPalindrome("aaabbbcc"));
    }
}
