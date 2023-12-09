package _131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

class Solution {
  private List<List<String>> result = new ArrayList<>();

  private List<String> ans = new ArrayList<>();

  private boolean[][] isPalindrome;
  public List<List<String>> partition(String s) {
    int length = s.length();
    isPalindrome = new boolean[length][length];
    for (int i = 0; i < length; i++) {
      for (int j = i; j >= 0; j--) {
        isPalindrome[i][j] = true;
      }
    }

    for (int i = 1; i <= length - 1; i++) {
      for (int j = 0; j + i < length; j++) {
        isPalindrome[j][j + i] = isPalindrome[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
      }
    }

    backtrace(s, 0);

    return result;
  }

  private void backtrace(String s, int start) {
    if (start == s.length()) {
      result.add(new ArrayList<>(ans));
      return;
    }
    for (int i = start; i < s.length(); i++) {
      if (isPalindrome[start][i]) {
        ans.add(s.substring(start, i + 1));
        backtrace(s, i + 1);
        ans.remove(ans.size() - 1);
      }
    }
  }
}