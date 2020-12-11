public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().findEncryptedWord("abcxcba"));
    }

    // Base Case: When input string's length is 0 or 1, return it
    // Get the middle character, convert it back to string and call recusion function with substring of the left and right.
    // Time: O(n), Space: O(n)

    String findEncryptedWord(String s) {
        // Write your code here
        if(s.length() <= 1) {
            return s;
        }
        int mid = (s.length() - 1) / 2;

        return String.valueOf(s.charAt(mid)) + findEncryptedWord(s.substring(0, mid)) + findEncryptedWord(s.substring(mid+1, s.length()));
    }
}
