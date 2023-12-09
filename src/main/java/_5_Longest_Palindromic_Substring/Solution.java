package _5_Longest_Palindromic_Substring;

class Solution {
  public String longestPalindrome(String s) {
    String longest = s.substring(0, 1);
    int longestPalindromeLength = 0;
    int length = s.length();
    boolean[][] isPalindrome = new boolean[length][length];
    for (int i = 0; i < length; i++) {
      for (int j = i; j >= 0; j--) {
        isPalindrome[i][j] = true;
      }
    }

    for (int i = 1; i <= length - 1; i++) {
      for (int j = 0; j + i < length; j++) {
        isPalindrome[j][j + i] = isPalindrome[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
        if (isPalindrome[j][j + i] && i > longestPalindromeLength) {
          longest = s.substring(j, j + i + 1);
        }
      }
    }
    return longest;
  }
}